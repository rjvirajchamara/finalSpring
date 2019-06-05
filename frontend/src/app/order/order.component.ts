import { Component, OnInit } from '@angular/core';
import {Customer} from '../modals/Customer';
import {Item} from '../modals/Item';
import {Order} from '../modals/Order';
import {Router} from '@angular/router';
import {FormsModule} from '@angular/forms';
import {OrderLists} from '../modals/OrderList';
import { catchError, retry } from 'rxjs/operators';
import {ErrorHandlerService} from '../services/error-handler.service';
import {CustomerService} from '../services/customer.service';
import {ItemService} from '../services/item.service';
import {OrderService} from '../services/order.service';

@Component({
  selector: 'app-order',
  templateUrl: './order.component.html',
  styleUrls: ['./order.component.scss']
})
export class OrderComponent implements OnInit {
  //private orderdetail:Array<{item:object,oid:string,cid:string,date:string}>=[];
  //private orderdetail:Array<{item:object,oid:string,cid:string,date:string}>=[];
  public OrderList=new OrderLists();
  private customer:Customer;
  private customerArr:Customer[];
  private itemArr:Item[];
  private item:Item;
  private itemTemp:Item;
  private order:Order;

  public code:string='';
  private qty:number;
  private price:number;
  private amount:number;
  private totqty:number;
  private stockqty:number;

    codefield:string='';
    descfield:string='';
    pricefield:string='';
    qtyfield:string='';
    idfield:string='';
    oidfield:string='';
    datefield:string='';
    stockfield:string='';
    cusid:string='';
    myDateValue:Date;

    iscuccess:boolean=false;
    displayAlert:boolean=false;
    message:string='';

  private rows:Array<{code:string,description:string,qty:number,price:number,amount:number}>=[];

  constructor(private errorhandler:ErrorHandlerService,private orderservice:OrderService,private itemservice:ItemService,private customerservice:CustomerService,private rout:Router) { }

  ngOnInit() {
    this.order=this.orderservice.getter();
    this.customer=this.customerservice.getter();
    this.item=this.itemservice.getter();
    this.OrderList.orderDTO= this.order;
   this.OrderList.orderDTO.customer=this.customer;
      this.loadCustomerId();
      this.loadItemCodes();
      this.myDateValue = new Date();


  }
    saveOrder(){
        this.OrderList.orderDTO.customer.id=this.customer.id;
        this.OrderList.orderDTO.date=this.order.date;
        //this.orderservice.saveOrder(this.OrderList).pipe(catchError(this.errorhandler.handleError));

       return this.orderservice.saveOrder(this.OrderList).subscribe(data=>this.clearInputfields(data,true,"success"),
          error1 => this.errorhandler.handleError(error1));

  }
    addItem(){

      this.itemTemp = this.rows.find(k=>k.code===this.item.code);

      if(this.itemTemp!==undefined){
          let index=this.rows.findIndex(ind=>ind.code===this.item.code);
          this.rows.splice(index,1);

          let index2=this.OrderList.itemDTOList.findIndex(ind=>ind.code===this.item.code);
            this.OrderList.itemDTOList.splice(index2,1);
          this.totqty=this.itemTemp.qty+this.qty;
            this.price=this.item.price;
            this.amount=this.totqty*this.price;
      }else{
          this.amount=this.qty*this.item.price;
          this.totqty=this.qty;
      }
        this.rows.push({code:this.item.code,description:this.item.description,qty:this.totqty,price:this.item.price,amount:this.amount});
        this.OrderList.itemDTOList.push({code:this.item.code,description:this.item.description,qty:this.totqty,price:this.item.price,amount:this.amount});

      console.log("this.item.qty  "+this.item.qty);
    }
    deleteItem(codes:string){
       let index=this.rows.findIndex(r=> r.code===codes);
        this.rows.splice(index,1);
        let item=this.OrderList.itemDTOList.findIndex(c=>c.code===codes);
        this.OrderList.itemDTOList.splice(item,1);

  }
    clearInputfields(data?:any,success?:boolean,mesage?:string){
        this.codefield=null;
        this.descfield=null;
        this.pricefield=null;
        this.qtyfield=null;
        this.idfield=null;
        this.oidfield=null;
        this.datefield=null;
        this.stockfield=null;

        if(success!==undefined){
            this.displayAlert=true;
        }else{}
        this.message=mesage;
        this.iscuccess=success;
        console.log("success Client side ,Backend",data);
        this.rows=null;
       // this.rout.navigate(['/dashboard']);

    }

    loadCustomerId(){
        this.customerservice.readCustomer().subscribe(data=>
        this.customerArr=data,error1 => this.errorhandler.handleError(error1));
    }
    selectCustomer(cusid:any){
      this.cusid=cusid;
      console.log("cust id  :"+this.cusid);
        if(cusid==="0"){
            alert("plase select ID");
            return;
        }else{
            this.customerservice.searchbyId(cusid).subscribe(data=>this.customer=data,error1 => this.errorhandler.handleError(error1));
        }
    }

    loadItemCodes(){
      this.itemservice.readItem().subscribe(data=>this.itemArr=data,error1 => this.errorhandler.handleError(error1));
    }

    selectItemcode(code:any){
     // this.item.code=code;
      this.itemservice.serchItem(code).subscribe(data=>this.item=data,error1 => this.errorhandler.handleError(error1));
        this.stockqty=this.item.qty;
        console.log("this.item.qty :"+this.item.qty);
        console.log("this.stockqty :"+this.stockqty);
    }
    onDateChange(newDate: Date) {

        console.log(newDate);
        console.log("new date"+newDate.toLocaleDateString() );
    }
    onValueChange(value: Date): void {

        this.myDateValue=value;
        console.log(this.myDateValue);
        let s = this.myDateValue.toLocaleDateString();
        console.log(s);
        this.order.date=s;

        this.myDateValue = value;
       // alert("this.myDateValue "+this.myDateValue);
       // alert("this.myDateValue "+this.myDateValue.toString());

    }
}

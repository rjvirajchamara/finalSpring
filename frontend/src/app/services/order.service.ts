import { Injectable } from '@angular/core';
import {Order} from '../modals/Order';
import {Customer} from '../modals/Customer';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {OrderLists} from '../modals/OrderList';

@Injectable(
//     {
//   providedIn: 'root'
// }
)
export class OrderService {
    //private baseuri:string="http://localhost:8080";
    private baseuri:string='http://localhost:8080';
    private header= new HttpHeaders().set('contentType','application/json');
    private order=new Order();
    private customer=new Customer();

    constructor(private http:HttpClient) { }

    setter(order:Order){
        this.order=order;
    }
    getter(){
        return this.order;
    }
    saveOrder(orderdlist:OrderLists){

        console.log("od==2 "+this.customer.valueOf());
        console.log("33 orderservice "+orderdlist);
        console.log("44 orderservice  length"+orderdlist.itemDTOList.length);
        console.log("455 orderservice tostring  "+orderdlist.toString());
        //let objectObservable = this.http.get(this.baseuri+'/api/v1/orders');
        let objectObservable = this.http.post(this.baseuri+'/api/v1/orders/'+orderdlist.orderDTO.oid,orderdlist);

        console.log("55 orderdetail "+orderdlist);
        return objectObservable;
    }

}

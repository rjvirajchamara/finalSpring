import { Component, OnInit } from '@angular/core';
import {Customer} from '../modals/Customer';
import {Router} from '@angular/router';
import {catchError} from 'rxjs/operators';
import {ErrorHandlerService} from '../services/error-handler.service';
import {CustomerService} from '../services/customer.service';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {

    //private customers :object;
    private customers :Customer[];
        addressfield:string='';
        namefield:string='';
        idfield:string='';
        isSave:boolean=false;
        iscustomerexist:boolean=false;
        iscuccess:boolean=false;
        displayAlert:boolean=false;

        private customersarray :object[];
        private customer :Customer;


  constructor(private custmerservice:CustomerService,private rout:Router,private errorhandler:ErrorHandlerService) {

  }

  ngOnInit() {
     this.customer=this.custmerservice.getter();
     this.readCustomer();
}

        create() {
            if(!this.isSave){
            // this.custmerservice.saveCustomer(this.customer).pipe(catchError(this.errorhandler.handleError));
                this.custmerservice.saveCustomer(this.customer).subscribe(
                    data=>this.clearInputfields(data,true),
                    //error1 => console.log("oops",error1));
                    error1 => {this.errorhandler.handleError(error1),this.clearInputfields(error1,false)});
      }else{

          this.modifyCustomer(this.customer);
      }

  }
        modifyCustomer(customer:Customer) {
             this.custmerservice.updateCustomer(this.customer).subscribe(data=>{
                 this.isSave=false;
                 this.clearInputfields(data);
                this.rout.navigate(['desktop'])
            },error1 => {
                console.log("update failed"+error1);

                 this.isSave=false;
            });
        }



  setCustomer(customer:Customer){
      this.custmerservice.setter(customer);
      this.rout.navigate(['/users']);
  }

  deleteCustomer(customer:Customer){
      this.custmerservice.deleteCustomer(customer).subscribe(data=>{
          console.log("delete Success");
          this.readCustomer();
      },error=>{
          console.log("Delete failed "+error);

      });
  }
  clearInputfields(data?:any,success?:boolean){
      this.addressfield=null;
      this.namefield=null;
      this.idfield=null;
      if(success){
          this.displayAlert=true;
      }else{}
      this.iscuccess=success;
      console.log("success",data);
    //  this.readCustomer();
      //this.rout.navigate(['/dashboard']);

  }
  doUpdate(customer:Customer){
      this.customer=customer;
      this.isSave=true;
  }
  readCustomer(){
      this.custmerservice.readCustomer().subscribe(data=>{
          this.customers=data;
          this.iscustomerexist=true;

      }, error1 => {console.log(error1); } );

  }

}

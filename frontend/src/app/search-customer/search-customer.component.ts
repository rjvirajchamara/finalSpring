import { Component, OnInit } from '@angular/core';
import {CustomerService} from '../services/customer.service';
import {Customer} from '../modals/Customer';

@Component({
  selector: 'app-search-customer',
  templateUrl: './search-customer.component.html',
  styleUrls: ['./search-customer.component.scss']
})
export class SearchCustomerComponent implements OnInit {

  private customer:object;
    id:string='';
    name:string='';
    idfield:string='';
    namefield:string='';
    isCustomer:boolean=false;


  constructor(private customerservice:CustomerService ) { }

  ngOnInit() {
  }

  searchByid(){

    console.log("id "+this.idfield);
    let subscription = this.customerservice.searchbyId(this.idfield).subscribe(datas=>{
        this.customer=datas;

    },error1 => {
      console.log("Not Found "+error1);
    });
  }

}

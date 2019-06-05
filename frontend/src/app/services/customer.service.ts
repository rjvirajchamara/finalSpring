import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {VERSION} from '@angular/core';
import {Customer} from '../modals/Customer';

@Injectable()
export class CustomerService {
    private baseuri:string='http://localhost:8080';
    private header= new HttpHeaders().set('contentType','application/json');
    private customer=new Customer();

    constructor(private http:HttpClient) { }

    readCustomer() {
        console.log('version is '+VERSION.full);

        //return this.http.get(this.baseuri+'/api/v1/customers', {headers: this.header});
        //let objectObservable = this.http.get(this.baseuri+'/api/v1/customers');
        let objectObservable = this.http.get<Customer[]>(this.baseuri+'/api/v1/customers');

        return objectObservable;
    }

    saveCustomer(custmr:Customer){
        return  this.http.post(this.baseuri+'/api/v1/customers/'+custmr.id,custmr);

    }
    setter(customer:Customer){
        this.customer=customer;
    }
    getter(){
        return this.customer;
    }

    updateCustomer(customer:Customer){
        let put = this.http.put(this.baseuri+'/api/v1/customers/'+customer.id,customer);
        console.log("put "+put);
        return put;
    }
    deleteCustomer(customer:Customer){
        let delete1 = this.http.delete(this.baseuri+'/api/v1/customers/'+customer.id);
        console.log("delete1 "+delete1);
        return delete1;
    }
    searchbyId(id:string){
        console.log("************service****************8");
        // let objectObservable = this.http.get(this.baseuri+'/api/v1/customers/'+id);
        return this.http.get<Customer>(this.baseuri+'/api/v1/customers/'+id);
        //console.log("search "+objectObservable)
        //return objectObservable;

    }
    searchbyname(){}

}

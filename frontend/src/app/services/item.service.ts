import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Item} from '../modals/Item';


@Injectable(
    // { // providedIn: 'root'}
)
export class ItemService {
    private  baseuri:string="http://localhost:8080";
    private item=new Item();

    constructor(private http:HttpClient) { }

    setter(items:Item){
        this.item=items;
    }
    getter(){
        return this.item;
    }

    readItem(){
        console.log("read items called=========");
        return this.http.get<Item[]>(this.baseuri+'/api/v1/items');
        //return this.http.get(this.baseuri+'/api/v1/items');
    }

    saveItem(item:Item){
        return this.http.post(this.baseuri+'/api/v1/items/'+item.code,item);
    }
    updateItem(item:Item){
        return this.http.put(this.baseuri+'/api/v1/items/'+item.code,item);
    }
    deleteItem(item:Item){
        return this.http.delete(this.baseuri+'/api/v1/items/'+item.code);
    }
    serchItem(code:string){
        // return this.http.get<User>(this.baseUrl + '/' + id);
        return this.http.get<Item>(this.baseuri+'/api/v1/items/'+code);
    }


}

import {Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';
import {Item} from '../modals/Item';
import {ItemService} from '../services/item.service';
import { HttpClient, HttpResponse, HttpEventType } from '@angular/common/http';



@Component({
  selector: 'app-item',
  templateUrl: './item.component.html',
  styleUrls: ['./item.component.scss']
})
export class ItemComponent implements OnInit {

  private items:Item[];
  private item:Item;
    codefield:string='';
    descfield:string='';
    pricefield:string='';
    qtyfield:string='';

    // image
    selectedFiles: FileList;
    currentFileUpload: File;
    progress: { percentage: number } = { percentage: 0 };


  constructor(private itemservice:ItemService,private  rout:Router) { }

  ngOnInit() {
    this.item=this.itemservice.getter();
    this.readItem();
  }

  create(){
    return this.itemservice.saveItem(this.item).subscribe(data=>{
      console.log(" item saved "+data);
           this.clearInputfields();
      this.rout.navigate(['/dashboard']);

    },
        error1 => {
            console.log(" Not saved  "+error1);

            this.clearInputfields();
        });
  }

  modify(){
   return  this.itemservice.updateItem(this.item).subscribe(data=>{
        console.log(" item updated "+data);
        this.rout.navigate(['/item']);
    },error1 => {
        console.log(" item not updated "+error1);
        this.rout.navigate(['/item']);
    });
  }

  delete(){
   return this.itemservice.deleteItem(this.item).subscribe(data=>{
        console.log(" item deleted "+data);
        this.rout.navigate(['/item']);
        let index=this.items.findIndex(r=> r.code===this.item.code);
        this.items.splice(index,1);
    },error1 => {
        console.log(" item not deleted "+error1);
        this.rout.navigate(['/item']);
    });
  }

  readItem(){
      console.log("read item ");
   return this.itemservice.readItem().subscribe(data=>{
      this.items=data;
    },error1 => {
            console.log(" Error caused "+error1);
        });
  }
    clearInputfields(){
        this.codefield=null;
        this.descfield=null;
        this.pricefield=null;
        this.qtyfield=null;
    }

    // selectFile(event) {
    //     const file = event.target.files.item(0);
    //
    //     if (file.type.match('image.*')) {
    //         this.selectedFiles = event.target.files;
    //     } else {
    //         alert('invalid format!');
    //     }
    // }

    // upload() {
    //     this.progress.percentage = 0;
    //     this.currentFileUpload = this.selectedFiles.item(0);
    //     //this.uploadService.pushFileToStorage(this.currentFileUpload).subscribe(event => {
    //     this.uploadService.saveImage(this.currentFileUpload).subscribe(event => {
    //         if (event === HttpEventType.UploadProgress) {
    //             console.log(" image saving...");
    //             //this.progress.percentage = Math.round(100 * event.loaded / event.total);
    //         } else if (event instanceof HttpResponse) {
    //             console.log('File is completely uploaded!');
    //         }
    //     });
    //
    //     this.selectedFiles = undefined;
    // }
}

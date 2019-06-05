import { Component, OnInit,ElementRef, ViewChild } from '@angular/core';
//import { ElementRef, ViewChild} from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import { MyService} from '../services/image.service';
import 'reflect-metadata';

@Component({
  selector: 'app-imagedisplay',
  templateUrl: './imagedisplay.component.html',
  styleUrls: ['./imagedisplay.component.scss']
})
export class ImagedisplayComponent implements OnInit {
    // title = ' File Upload';
    // file = null;
    // successMsg= null;
    // errorMsg= null;
    // error = null;

    @ViewChild("myFile")
    myFile: ElementRef;

    constructor(private service: MyService,private http:HttpClient) { }
    ngOnInit() {

    }

    uploadFile(): void {
        // Let's extract the file
        let file = this.myFile.nativeElement.files[0];
        // Check whether there is a file exists
        if (file) {
            // If so, let's upload it
            this.service.uploadFile(file).subscribe(result=>{

                if (result){
                    alert("Upload successfully");
                }else{
                    alert("Failed to upload");
                }
            });
        }
    }

    // getFiles(files: any) {
    //     let empDataFiles: FileList = files.files;
    //     this.file = empDataFiles[0];
    // }

    // postfile() {
    //     if (this.file !== undefined) {
    //         this.service.postFormData(this.file).map(responce => {
    //         }).catch( error =>
    //             this.errorMsg = "Failed to Upload File"
    //         );
    //         this.successMsg = "Successfully uploaded !!";
    //     } else {
    //         this.errorMsg = "Failed to Upload File";
    //     }
    // }


}











import { Component, OnInit,Input} from '@angular/core';

@Component({
  selector: 'app-imagedetails',
  templateUrl: './imagedetails.component.html',
  styleUrls: ['./imagedetails.component.scss']
})
export class ImagedetailsComponent implements OnInit {
    @Input() fileUpload: string;
  constructor() { }

  ngOnInit() {
  }

}

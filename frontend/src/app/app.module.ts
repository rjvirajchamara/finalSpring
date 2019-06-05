import { BrowserModule } from '@angular/platform-browser';
import {ErrorHandler, NgModule} from '@angular/core';
import { FormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';
import { AppRoutingModule } from './app.routing';
import { NavbarModule } from './shared/navbar/navbar.module';
import { FooterModule } from './shared/footer/footer.module';
import { SidebarModule } from './sidebar/sidebar.module';
import { LbdModule } from './lbd/lbd.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { UserComponent } from './user/user.component';
import {HttpClientModule} from '@angular/common/http';
import { SearchCustomerComponent } from './search-customer/search-customer.component';
import { OrderComponent } from './order/order.component';
import { ItemComponent } from './item/item.component';
import {OrderService} from './services/order.service';
import {ItemService} from './services/item.service';
import {ErrorHandlerService} from './services/error-handler.service';
import {CustomerService} from './services/customer.service';
import { ImagedisplayComponent } from './imagedisplay/imagedisplay.component';
import { ImagedetailsComponent } from './imagedetails/imagedetails.component';
import { MyService} from './services/image.service';
import { BsDatepickerModule } from 'ngx-bootstrap';
import { CarouselModule } from 'ngx-bootstrap';



@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    UserComponent,
    SearchCustomerComponent,
    OrderComponent,
    ItemComponent,
    ImagedisplayComponent,
    ImagedetailsComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    NavbarModule,
    FooterModule,
    SidebarModule,
    RouterModule,
    AppRoutingModule,
    HttpClientModule,
    LbdModule,
      BsDatepickerModule.forRoot(),
      CarouselModule.forRoot()
  ],

  providers: [CustomerService,ItemService,OrderService,MyService,{provide: ErrorHandler, useClass: ErrorHandlerService}],
  bootstrap: [AppComponent]
})
export class AppModule {}

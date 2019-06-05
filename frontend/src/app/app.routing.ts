import { NgModule } from '@angular/core';
import { CommonModule, } from '@angular/common';
import { BrowserModule  } from '@angular/platform-browser';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { UserComponent } from './user/user.component';
import { SearchCustomerComponent } from './search-customer/search-customer.component';
import {OrderComponent} from './order/order.component';
import {ItemComponent} from './item/item.component';
import {ImagedisplayComponent} from './imagedisplay/imagedisplay.component';

const routes:Routes = [
    { path: 'dashboard',      component: HomeComponent },
    { path: 'user',           component: UserComponent },
    { path: 'search-customer',  component: SearchCustomerComponent },
    { path: 'order',            component: OrderComponent },
    { path: 'item',             component: ItemComponent },
    { path: 'imagedisplay',     component: ImagedisplayComponent },
    { path: '',          redirectTo: 'dashboard', pathMatch: 'full' }
];

@NgModule({
  imports: [
    CommonModule,
    BrowserModule,
    RouterModule.forRoot(routes)
  ],
  exports: [
  ],
})
export class AppRoutingModule { }

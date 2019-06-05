import { Component, OnInit } from '@angular2/core';

declare const $: any;
declare interface RouteInfo {
    path: string;
    title: string;
    icon: string;
    class: string;
}
export const ROUTES: RouteInfo[] = [
    { path: 'dashboard', title: 'Dashboard',  icon: 'pe-7s-graph', class: '' },
    { path: 'user', title: 'User Profile',  icon:'pe-7s-user', class: '' },
    { path: 'search-customer', title: 'SearchCustomer',  icon:'pe-7s-search', class: '' },
    { path: 'order', title: 'Order Form',  icon:'pe-7s-note2', class: '' },
    { path: 'item', title: 'Item Form',  icon:'pe-7s-note2', class: '' },
    { path: 'imagedisplay', title: 'Image',  icon:'pe-7s-note2', class: '' },


];

@Component({
  selector: 'app-sidebar',
  templateUrl: './sidebar.component.html'
})
export class SidebarComponent implements OnInit {
  menuItems: any[];

  constructor() { }

  ngOnInit() {
    this.menuItems = ROUTES.filter(menuItem => menuItem);
  }
  isMobileMenu() {
      if ($(window).width() > 991) {
          return false;
      }
      return true;
  };
}

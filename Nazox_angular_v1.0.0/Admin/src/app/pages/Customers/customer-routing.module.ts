import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {CustomersComponent} from "./customers/customers.component";
import {approveDeleteCustomersComponent} from "./approveDeleteCustomers/approveDeleteCustomers.component";
import {approveCustomersComponent} from "./approveCustomers/approveCustomers.component";
import {deleteCustomers} from "./deleteCustomers/deleteCustomers";
import {ServiceGuard} from "../services/service.guard";







const routes: Routes = [

  {
    path: 'customers',
    component: CustomersComponent,
    //canActivate: [ServiceGuard]
  },
  {
    path: 'deleteCustomers',
    component: deleteCustomers,
    //canActivate: [ServiceGuard]
  },
  {
    path: 'approveCustomers',
    component: approveCustomersComponent,

  },
  {
    path: 'approveDeleteCustomers',
    component: approveDeleteCustomersComponent,

  }


];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class CustomerRoutingModule { }

import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {PermitComponent} from "./permit/permit.component";
import {permitTypeComponent} from "./permitType/permitType.component";
import {InvoiceComponent} from "./invoice/invoice.component";
import {approvePermitComponent} from "./approvePermit/approvePermit.Component";







const routes: Routes = [

  {
    path: 'permit',
    component: PermitComponent

   // canActivate: [ServiceGuard]

  },
  {
    path: 'permitType',
    component: permitTypeComponent

    // canActivate: [ServiceGuard]

  },
  {
    path: 'invoice',
    component: InvoiceComponent

    // canActivate: [ServiceGuard]

  },
  {
    path: 'approvePermit',
    component: approvePermitComponent

    // canActivate: [ServiceGuard]

  },



];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class SBPRoutingModule { }

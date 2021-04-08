import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {PermitComponent} from "./permit/permit.component";
import {permitTypeComponent} from "./permitType/permitType.component";
import {InvoiceComponent} from "./invoice/invoice.component";
import {approvePermitComponent} from "./approvePermit/approvePermit.Component";
import {permitRenewalComponent} from "./permit/permitRenewal.component";







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
  {
    path: 'erevenue/reports',
    component: InvoiceComponent

    // canActivate: [ServiceGuard]

  },
  {
    path: 'permitRenewal',
    component: permitRenewalComponent

    // canActivate: [ServiceGuard]

  },



];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class SBPRoutingModule { }

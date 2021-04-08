import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {LandRegeistrationComponent} from "./landRegeistration.component";
import {ApproveLandComponent} from "./approveLand.component";
import {LandInvoiceComponent} from "./landInvoice.component";








const routes: Routes = [

  {
    path: 'landRates',
    component: LandRegeistrationComponent

    // canActivate: [ServiceGuard]

  },
  {
    path: 'approveLand',
    component: ApproveLandComponent

    // canActivate: [ServiceGuard]

  },
  {
    path: 'landinvoice',
    component: LandInvoiceComponent

    // canActivate: [ServiceGuard]

  },




];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class landRoutingModule { }

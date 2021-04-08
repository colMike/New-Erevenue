import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {DeviceRegComponent} from "./deviceRegistration/deviceReg.component";
import {DeviceIssueComponent} from "./deviceIssue/deviceIssue.component";








const routes: Routes = [

  {

    path: 'deviceRegistration',

    component: DeviceRegComponent

    // canActivate: [ServiceGuard]

  },
  {
    path: 'deviceIssue',
    component: DeviceIssueComponent

    // canActivate: [ServiceGuard]

  },


];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class DeviceRoutingModule { }

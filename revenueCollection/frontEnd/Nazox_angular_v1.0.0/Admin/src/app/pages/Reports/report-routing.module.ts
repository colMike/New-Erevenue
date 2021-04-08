import {AuditTrailComponent} from "./auditTrail/auditTrail.component";

import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {ServiceGuard} from "../services/service.guard";

const routes: Routes = [

  {
    path: 'auditTrail',
    component: AuditTrailComponent,
    canActivate: [ServiceGuard]
  }


];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class reportRoutingModule { }

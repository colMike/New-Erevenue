import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {AccessControlComponent} from "./accessControl/accessControl.component";
import {ServiceGuard} from "../services/service.guard";
import {approveDeleteRoleComponent} from "./approveDeleteRoles/approveDeleteRole.component";
import {deleteRoleComponent} from "./deleteRoles/deleteRole.component";
import {approveRoleComponent} from "./approveRoles/approveRole.component";







const routes: Routes = [

  {

    path: 'accessControl',

    component: AccessControlComponent

   // canActivate: [ServiceGuard]

  },
  {
    path: 'approveRoles',
    component: approveRoleComponent

    // canActivate: [ServiceGuard]

  },
  {
    path: 'deleteRoles',
    component: deleteRoleComponent

    // canActivate: [ServiceGuard]

  },
  {
    path: 'approveDeleteRoles',
    component: approveDeleteRoleComponent

    // canActivate: [ServiceGuard]

  }


];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AccessControlRoutingModule { }

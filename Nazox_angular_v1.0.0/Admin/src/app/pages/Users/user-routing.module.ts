import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {UsersComponent} from "./users/users.component";
import {approveUsersComponent} from "./approveUsers/approveUsers.component";
import {deleteUsersComponent} from "./deleteUsers/deleteUsers.component";
import {approveDeleteUsersComponent} from "./approveDeleteUsers/approveDeleteUsers.component";
import {ServiceGuard} from "../services/service.guard";






const routes: Routes = [

  {
    path: 'users',
    component: UsersComponent,
   // canActivate: [ServiceGuard]
  },
  {
    path: 'approveUsers',
    component: approveUsersComponent,
    //canActivate: [ServiceGuard]
  },
  {
    path: 'deleteUsers',
    component: deleteUsersComponent,
    //canActivate: [ServiceGuard]
  },
  {
    path: 'approvedeleteusers',
    component: approveDeleteUsersComponent,
   // canActivate: [ServiceGuard]
  }


];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class UserRoutingModule { }

import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';


import {RegionComponent} from "./region.component";
import {WardComponent} from "./ward.component";






const routes: Routes = [

  {
    path: 'subcounty',
    component: RegionComponent
  },
  {
    path: 'ward',
    component: WardComponent
  },





];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class regionRoutingModule { }

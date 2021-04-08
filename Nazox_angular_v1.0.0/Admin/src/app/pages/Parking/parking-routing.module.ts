import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import {ParkingComponent} from "./parking/parking.component";
import {PriceConfigComponent} from "./priceConfig/priceConfig.component";
import {CarTypeComponent} from "./carType/carType.component";
import {deleteParkingComponent} from "./deleteParking/deleteParking.component";
import {approveParkingComponent} from "./approveParking/approveParking.component";
import {approveDeleteParkingComponent} from "./approveDeleteParking/approveDeleteParking.component";
import {ServiceGuard} from "../services/service.guard";






const routes: Routes = [

  {
    path: 'parking',
    component: ParkingComponent,
    //canActivate: [ServiceGuard]
  },
  {
    path: 'priceConfig',
    component: PriceConfigComponent,
   // canActivate: [ServiceGuard]
  },
  {
    path: 'carType',
    component: CarTypeComponent,
   // canActivate: [ServiceGuard]
  },
  {
    path: 'approvePriceConfig',
    component: approveParkingComponent,
    //canActivate: [ServiceGuard]
  },
  {
    path: 'deletePriceConfig',
    component: deleteParkingComponent,
    //canActivate: [ServiceGuard]
  },
  {
    path: 'approveDeletePriceConfig',
    component: approveDeleteParkingComponent,
    //canActivate: [ServiceGuard]
  }




];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class parkingRoutingModule { }

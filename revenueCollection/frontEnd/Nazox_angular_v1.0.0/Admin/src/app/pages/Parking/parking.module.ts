import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

// tslint:disable-next-line: max-line-length
import { NgbAccordionModule, NgbNavModule, NgbTypeaheadModule, NgbPaginationModule, NgbCollapseModule, NgbTooltipModule, NgbModalModule } from '@ng-bootstrap/ng-bootstrap';
import { ArchwizardModule } from 'angular-archwizard';
import { Ng5SliderModule } from 'ng5-slider';
import { NgSelectModule } from '@ng-select/ng-select';
import { DropzoneModule } from 'ngx-dropzone-wrapper';

import { ToastrModule } from 'ngx-toastr';
import {UiModule} from "../../shared/ui/ui.module";
import {ParkingComponent} from "./parking/parking.component";
import {parkingRoutingModule} from "./parking-routing.module";
import {PriceConfigComponent} from "./priceConfig/priceConfig.component";
import {CarTypeComponent} from "./carType/carType.component";
import {deleteParkingComponent} from "./deleteParking/deleteParking.component";
import {approveParkingComponent} from "./approveParking/approveParking.component";
import {approveDeleteParkingComponent} from "./approveDeleteParking/approveDeleteParking.component";
import {BlockUIModule} from "ng-block-ui";







@NgModule({
  // tslint:disable-next-line: max-line-length
  declarations: [ParkingComponent,PriceConfigComponent,CarTypeComponent,deleteParkingComponent,approveParkingComponent,approveDeleteParkingComponent],

    imports: [
        CommonModule,

        ToastrModule.forRoot(),
        FormsModule,
        UiModule,
        DropzoneModule,
        ReactiveFormsModule,
        parkingRoutingModule,
        ArchwizardModule,
        NgbAccordionModule,
        NgbNavModule,
        NgbTypeaheadModule,
        NgbPaginationModule,
        NgbTooltipModule,
        NgbCollapseModule,
        NgSelectModule,
        Ng5SliderModule,
        NgbModalModule,
        BlockUIModule
    ]
})
export class parkingModule { }

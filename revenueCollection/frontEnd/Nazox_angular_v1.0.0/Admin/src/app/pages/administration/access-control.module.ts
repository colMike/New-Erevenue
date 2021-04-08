
import {AccessControlComponent} from "./accessControl/accessControl.component";





import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

// tslint:disable-next-line: max-line-length
import {
  NgbAccordionModule,
  NgbDropdown,
  NgbNavModule,
  NgbTypeaheadModule,
  NgbPaginationModule,
  NgbCollapseModule,
  NgbTooltipModule,
  NgbModalModule,
  NgbDropdownModule
} from '@ng-bootstrap/ng-bootstrap';
import { ArchwizardModule } from 'angular-archwizard';
import { Ng5SliderModule } from 'ng5-slider';
import { NgSelectModule } from '@ng-select/ng-select';
import { DropzoneModule } from 'ngx-dropzone-wrapper';
import {UiModule} from "../../shared/ui/ui.module";
import { Ng2SmartTableModule } from 'ng2-smart-table';
import {BlockUIModule} from "ng-block-ui";
import {AccessControlRoutingModule} from "./access-control-routing.module";
import {ServiceGuard} from "../services/service.guard";
import {HTTP_INTERCEPTORS} from "@angular/common/http";
import {JwtInterceptor} from "../../core/helpers/jwt.interceptor";
import {ErrorInterceptor} from "../../core/helpers/error.interceptor";
import {FakeBackendInterceptor} from "../../core/helpers/fake-backend";
import {approveDeleteRoleComponent} from "./approveDeleteRoles/approveDeleteRole.component";
import {deleteRoleComponent} from "./deleteRoles/deleteRole.component";
import {approveRoleComponent} from "./approveRoles/approveRole.component";







@NgModule({
  // tslint:disable-next-line: max-line-length
  declarations: [AccessControlComponent,approveDeleteRoleComponent,deleteRoleComponent,approveRoleComponent],

  imports: [
    CommonModule,
    Ng2SmartTableModule,
    FormsModule,
    UiModule,
    DropzoneModule,
    NgbDropdownModule,
    ReactiveFormsModule,
    AccessControlRoutingModule,
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
    BlockUIModule,

  ],
  providers: [
    { provide: HTTP_INTERCEPTORS, useClass: JwtInterceptor, multi: true },
    { provide: HTTP_INTERCEPTORS, useClass: ErrorInterceptor, multi: true },
    { provide: HTTP_INTERCEPTORS, useClass: FakeBackendInterceptor, multi: true },
    ServiceGuard
  ],
})
export class accessControlModule { }

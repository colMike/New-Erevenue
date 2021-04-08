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
import {UsersComponent} from "./users/users.component";
import {UserRoutingModule} from "./user-routing.module";
import {approveDeleteUsersComponent} from "./approveDeleteUsers/approveDeleteUsers.component";
import {approveUsersComponent} from "./approveUsers/approveUsers.component";
import {deleteUsersComponent} from "./deleteUsers/deleteUsers.component";
import {BlockUIModule} from "ng-block-ui";






@NgModule({
  // tslint:disable-next-line: max-line-length
  declarations: [UsersComponent,approveDeleteUsersComponent,approveUsersComponent,deleteUsersComponent],

    imports: [
        CommonModule,

        ToastrModule.forRoot(),
        FormsModule,
        UiModule,
        DropzoneModule,
        ReactiveFormsModule,
        UserRoutingModule,
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
export class userModule { }

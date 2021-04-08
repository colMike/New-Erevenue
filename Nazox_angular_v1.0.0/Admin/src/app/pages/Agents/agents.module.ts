import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

// tslint:disable-next-line: max-line-length
import { NgbAccordionModule, NgbNavModule, NgbTypeaheadModule, NgbPaginationModule, NgbCollapseModule, NgbTooltipModule, NgbModalModule } from '@ng-bootstrap/ng-bootstrap';
import { ArchwizardModule } from 'angular-archwizard';
import { Ng5SliderModule } from 'ng5-slider';
import { NgSelectModule } from '@ng-select/ng-select';
import { DropzoneModule } from 'ngx-dropzone-wrapper';
import {AgentsRoutingModule} from "./agents-routing.module";



import {approveAgentsComponent} from "./approveAgents/approveAgents.component";
import {AgentsComponent} from "./agents/agents.component";
import {deleteAgentsComponent} from "./deleteAgents/deleteAgents.components";
import {UiModule} from "../../shared/ui/ui.module";
import {approveDeleteUsersComponent} from "../Users/approveDeleteUsers/approveDeleteUsers.component";
import {approveDeleteAgentsComponent} from "./approveDeleteAgents/approveDeleteAgents.component";








@NgModule({
  // tslint:disable-next-line: max-line-length
  declarations: [AgentsComponent,deleteAgentsComponent,approveAgentsComponent,approveDeleteAgentsComponent],

  imports: [
    CommonModule,

    FormsModule,
    UiModule,
    DropzoneModule,
    ReactiveFormsModule,
    AgentsRoutingModule,
    ArchwizardModule,
    NgbAccordionModule,
    NgbNavModule,
    NgbTypeaheadModule,
    NgbPaginationModule,
    NgbTooltipModule,
    NgbCollapseModule,
    NgSelectModule,
    Ng5SliderModule,
    NgbModalModule
  ]
})
export class AgentsModule { }

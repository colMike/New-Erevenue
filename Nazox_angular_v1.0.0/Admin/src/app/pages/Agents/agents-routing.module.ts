import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import {approveAgentsComponent} from "./approveAgents/approveAgents.component";
import {AgentsComponent} from "./agents/agents.component";
import {deleteAgentsComponent} from "./deleteAgents/deleteAgents.components";
import {approveDeleteAgentsComponent} from "./approveDeleteAgents/approveDeleteAgents.component";
import {ServiceGuard} from "../services/service.guard";





const routes: Routes = [

  {
    path: 'agents',
    component: AgentsComponent,

  },
  {
    path: 'deleteAgents',
    component: deleteAgentsComponent,

  },
  {
    path: 'approveAgents',
    component: approveAgentsComponent,

  },
  {
    path: 'approveDeleteAgents',
    component: approveDeleteAgentsComponent,

  }


];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AgentsRoutingModule { }

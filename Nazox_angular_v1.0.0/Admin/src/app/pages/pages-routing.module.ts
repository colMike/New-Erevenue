import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { DashboardComponent } from './dashboard/dashboard.component';
import { CalendarComponent } from './calendar/calendar.component';
import { ChatComponent } from './chat/chat.component';
import { KanbanComponent } from './kanban/kanban.component';
import {ServiceGuard} from './services/service.guard';

const routes: Routes = [
    { path: '', component: DashboardComponent },
    { path: 'calendar', component: CalendarComponent },
    { path: 'chat', component: ChatComponent },
    { path: 'kanban-board', component: KanbanComponent },
    { path: 'ecommerce', loadChildren: () => import('./ecommerce/ecommerce.module').then(m => m.EcommerceModule) },
    { path: 'email', loadChildren: () => import('./email/email.module').then(m => m.EmailModule) },
  { path: 'Agents', loadChildren: () => import('./Agents/agents.module').then(m => m.AgentsModule) },
  { path: 'Users', loadChildren: () => import('./Users/user.module').then(m => m.userModule) },
  { path: 'Delete agents', loadChildren: () => import('./Agents/agents.module').then(m => m.AgentsModule) },
 { path: 'administration', loadChildren: () => import('./administration/access-control.module').then(m => m.accessControlModule) },
  { path: 'Reports', loadChildren: () => import('./Reports/report.module').then(m => m.reportModule) },
  { path: 'customers', loadChildren: () => import('./Customers/customer.module').then(m => m.customerModule) },
  { path: 'parking', loadChildren: () => import('./Parking/parking.module').then(m => m.parkingModule) },
  { path: 'subcounty', loadChildren: () => import('./regionSettings/region.module').then(m => m.regionModule) },

  { path: 'SBP', loadChildren: () => import('./SBP/SBP.module').then(m => m.SBPModule) },
  { path: 'landRates', loadChildren: () => import('./landRates/land.module').then(m => m.landModule) },

  { path: 'device', loadChildren: () => import('./device/device.module').then(m => m.DeviceModule) },
  { path: 'pages', loadChildren: () => import('./utility/utility.module').then(m => m.UtilityModule) },
    { path: 'ui', loadChildren: () => import('./ui/ui.module').then(m => m.UIModule) },
    { path: 'icons', loadChildren: () => import('./icons/icons.module').then(m => m.IconsModule) },
    { path: 'charts', loadChildren: () => import('./chart/chart.module').then(m => m.ChartModule) },
    { path: 'form', loadChildren: () => import('./form/form.module').then(m => m.FormModule) },
    { path: 'tables', loadChildren: () => import('./tables/tables.module').then(m => m.TablesModule) },
    { path: 'maps', loadChildren: () => import('./maps/maps.module').then(m => m.MapsModule) },
];

@NgModule({
    imports: [RouterModule.forChild(routes)],
    exports: [RouterModule]
})
export class PagesRoutingModule { }

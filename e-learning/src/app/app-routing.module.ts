import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LayoutComponent } from './layout/layout.component';

const routes: Routes = [
  // { path: 'account',  loadChildren: () => import('./account/account.module').then(m => m.AccountModule) },
  // tslint:disable-next-line: max-line-length
  { path: '',  component: LayoutComponent, loadChildren: () => import('./outPage/outPage.module').then(m => m.OutPageModule) },
];



@NgModule({
  imports: [RouterModule.forRoot(routes,{scrollPositionRestoration: 'top'})],
  exports: [RouterModule]
})
export class AppRoutingModule { }

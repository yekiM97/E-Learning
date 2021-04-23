import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes } from '@angular/router';
import { HomePageComponent } from './home-page/home-page.component';
import { AuthGuard } from '../guard/auth.guard';

export const routes: Routes = [
  {
    path: 'home',
    component: HomePageComponent,
   
  },
];

@NgModule({
  declarations: [],
  imports: [RouterModule.forChild(routes), CommonModule],
})
export class AdminRoutingModule {}

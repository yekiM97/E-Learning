import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes } from '@angular/router';
import { UserComponent } from './user/user.component';
import { HomePageComponent } from './home-page/home-page.component';
import { DetailsComponent } from './details/details.component';
import { ProfileComponent } from './profile/profile.component';
import { MyCourseComponent } from './my-course/my-course.component';

export const routes: Routes = [
  {
    path: '',
    component: HomePageComponent,
  },
  {
    path: 'myCourse/:id/details',
    component: DetailsComponent,
  },
  {
    path: 'profile',
    component: ProfileComponent,
  },
  {
    path: 'myCourse',
    component: MyCourseComponent,
  },
 
];



@NgModule({
  declarations: [],
  imports: [RouterModule.forChild(routes), CommonModule],
})
export class OutPageRoutingModule {}

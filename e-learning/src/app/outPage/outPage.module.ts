import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { NgbDropdownModule, NgbModalModule, NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { NgModule } from '@angular/core';
import { NgSelectModule } from '@ng-select/ng-select';
import { UIModule } from '../ui/ui.module';
import { ToastrModule } from 'ngx-toastr';
import { OutPageRoutingModule } from './outPage-routing.module';
import { UserComponent } from './user/user.component';
import { HomePageComponent } from './home-page/home-page.component';
import { DetailsComponent } from './details/details.component';
import { RouterModule } from '@angular/router';
import { ProfileComponent } from './profile/profile.component';
import { MyCourseComponent } from './my-course/my-course.component';


@NgModule({
  declarations: [UserComponent,HomePageComponent, DetailsComponent, ProfileComponent, MyCourseComponent],
  imports: [
    CommonModule,
    FormsModule,
    UIModule,
    RouterModule,
    ReactiveFormsModule,
    OutPageRoutingModule,
    NgbModalModule,
    NgbDropdownModule,
    NgbModule,
    NgSelectModule,
    ToastrModule.forRoot(),
    ToastrModule.forRoot({
      preventDuplicates: true,
      countDuplicates: true
    }),
  ],
  bootstrap: [UserComponent,HomePageComponent]
})
export class OutPageModule { }

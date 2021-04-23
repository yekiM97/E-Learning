import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';
import { NgbDropdownModule, NgbModalModule, NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { ToastrModule } from 'ngx-toastr';
import { AdminRoutingModule } from './admin-routing.module';
import { HomePageComponent } from './home-page/home-page.component';



@NgModule({
  declarations: [HomePageComponent],
  imports: [
    CommonModule,
    AdminRoutingModule,
    FormsModule,
    RouterModule,
    ReactiveFormsModule,
    NgbModalModule,
    NgbDropdownModule,
    NgbModule,
    ToastrModule.forRoot(),
    ToastrModule.forRoot({
      preventDuplicates: true,
      countDuplicates: true
    }),
  ],
  bootstrap: [HomePageComponent]
})
export class AdminModule { }

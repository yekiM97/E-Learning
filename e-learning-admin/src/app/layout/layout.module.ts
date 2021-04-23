import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';
import { NgbDropdownModule } from '@ng-bootstrap/ng-bootstrap';
import { ClickOutsideModule } from 'ng-click-outside';
import { LayoutComponent } from './layout.component';
import { SidebarComponent } from './sidebar/sidebar.component';
import { TopbarComponent } from './topbar/topbar.component';
import { FooterComponent } from './footer/footer.component';



@NgModule({
  declarations: [LayoutComponent,TopbarComponent,SidebarComponent, FooterComponent],
  imports: [
    CommonModule,
    RouterModule,
    NgbDropdownModule,
    
    ClickOutsideModule,
    ReactiveFormsModule,
    FormsModule
  ]
})
export class LayoutModule { }

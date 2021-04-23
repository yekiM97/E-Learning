import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

import { NgbCollapseModule, NgbDatepickerModule, NgbTimepickerModule, NgbDropdownModule } from '@ng-bootstrap/ng-bootstrap';

import { PreloaderComponent } from './preloader/preloader.component';
import { ClickOutsideModule } from 'ng-click-outside';

@NgModule({
  declarations: [PreloaderComponent],
  imports: [
    CommonModule,
    FormsModule,
    ClickOutsideModule,
    NgbCollapseModule,
    NgbDatepickerModule,
    NgbTimepickerModule,
    NgbDropdownModule,
  ],
  exports: [PreloaderComponent]
})
export class UIModule { }

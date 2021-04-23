import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { AdminModule } from './admin/admin.module';

import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HttpClientModule  } from "@angular/common/http";
import { ToastrModule } from 'ngx-toastr';
import { LayoutModule } from './layout/layout.module';
import { LoginComponent } from './login/login.component';
import { AuthGuard } from './guard/auth.guard';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent
   
   
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    
    LayoutModule,
    AppRoutingModule,
    HttpClientModule,
    ReactiveFormsModule,
    FormsModule,
    ToastrModule.forRoot(),
    ToastrModule.forRoot({
      preventDuplicates: true,
      countDuplicates: true
    }),
  ],
  providers: [HttpClientModule,AuthGuard],
  bootstrap: [AppComponent]
})
export class AppModule { }

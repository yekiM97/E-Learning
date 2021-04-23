import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Course } from '../model/course.model';
import { Login } from '../model/login.module';
import { User } from '../model/user.model';
import { CommandURL } from '../url/command-url';

@Injectable({
  providedIn: 'root',
})
export class AuthenticateService {
  constructor(private http: HttpClient) {}

  //login
  loginAdmin(json: any) {
    return this.http.post<Login>(CommandURL.LOGIN_ADMIN, json);
  }
}

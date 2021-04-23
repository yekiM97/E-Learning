import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Course } from '../model/course.model';
import { Login } from '../model/login.module';
import { User } from '../model/user.model';
import { CommandURL } from '../url/comman-url';

@Injectable({
  providedIn: 'root',
})
export class AuthenticateService {
  constructor(private http: HttpClient) {}

  //register
  register(json: any) {
    return this.http.post<User>(CommandURL.REGISTER, json);
  }

  //login
  login(json: any) {
    return this.http.post<Login>(CommandURL.LOGIN, json);
  }
}

import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Course } from '../model/course.model';
import { Target } from '../model/target.model';
import { User } from '../model/user.model';
import { CommandURL } from '../url/command-url';

@Injectable({
  providedIn: 'root',
})
export class UserService {
  constructor(private http: HttpClient) {}
  //Normal
  //GET LIST
  // getListUser(json: any) {
  //   return this.http.post<Array<User>>(CommandURL.LIST_USER, json);
  // }
  
  // //FIND
  // findUserByID(json: any){
  //   return this.http.post<User>(CommandURL.FIND_USER_BY_ID, json);
  // }

  // //FIND
  // findUserByEmail(json: any){
  //   return this.http.post<User>(CommandURL.FIND_USER_BY_EMAIL, json);
  // }

  // editUser(json: any){
  //   return this.http.post<User>(CommandURL.EDIT_USER, json);

  // }

  // editUserPassword(json: any){
  //   return this.http.post<User>(CommandURL.EDIT_USER_PASSWORD, json);

  // }
 
  //ADMIN
  getListUserAdmin(json: any) {
    return this.http.post<Array<User>>(CommandURL.LIST_USER_ADMIN, json);
  }
}

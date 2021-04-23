import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { UserCourse } from '../model/userCourse.model';
import { CommandURL } from '../url/command-url';

@Injectable({
  providedIn: 'root',
})
export class UserCourseService {
  constructor(private http: HttpClient) {}
  //Normal
  //GET LIST
  // getListCourseByUserId(json: any) {
  //   return this.http.post<Array<UserCourse>>(CommandURL.FIND_BY_USER_ID, json);
  // }

  // addUserCourse(json: any) {
  //   return this.http.post<UserCourse>(CommandURL.ADD_USER_COURSE, json);
  // }

  // findUserCourseByCourseID(json: any) {
  //   return this.http.post<UserCourse>(CommandURL.FIND_USER_COURSE_BY_COURSE_ID, json);
  // }

  // deleteUserCourse(json: any){
  //   return this.http.post<UserCourse>(CommandURL.DELETE_USER_COURSE, json);
  // }

  getListCourse(json: any){
    return this.http.post<Array<UserCourse>>(CommandURL.LIST_USER_COURSE_ADMIN, json);
  }
}

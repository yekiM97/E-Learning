import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Course } from '../model/course.model';
import { CommandURL } from '../url/command-url';

@Injectable({
  providedIn: 'root',
})
export class CourseService {
  constructor(private http: HttpClient) {}

  //Normal
  //GET LIST
  // getListCourse(json: any) {
  //   return this.http.post<Array<Course>>(CommandURL.LIST_COURSE, json);
  // }

  // getListCourseByUserID(json: any) {
  //   return this.http.post<Array<Course>>(CommandURL.GET_LIST_COURSE_BY_USER_ID, json);
  // }

  
  // findCourseByID(json: any){
  //   return this.http.post<Course>(CommandURL.FIND_COURSE_BY_ID, json);
  // }
  

  //ADMIN
  getListCourseAdmin(json: any) {
    return this.http.post<Array<Course>>(CommandURL.LIST_COURSE_ADMIN, json);
  }
}

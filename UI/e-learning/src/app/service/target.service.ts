import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Course } from '../model/course.model';
import { Target } from '../model/target.model';
import { CommandURL } from '../url/comman-url';

@Injectable({
  providedIn: 'root',
})
export class TargetService {
  constructor(private http: HttpClient) {}
  //Normal
  //GET LIST
  getListTarget(json: any) {
    return this.http.post<Array<Target>>(CommandURL.LIST_TARGET, json);
  }

  
  //FIND
  findTargetByID(json: any){
    return this.http.post<Target>(CommandURL.FIND_TARGET_BY_ID, json);
  }

  findTargetByCourseID(json: any){
    return this.http.post<Array<Target>>(CommandURL.FIND_TARGET_BY_COURSE_ID, json);
  }
 
  //ADMIN
  getListTargetAdmin(json: any) {
    return this.http.post<Array<Target>>(CommandURL.LIST_TARGET_ADMIN, json);
  }
}

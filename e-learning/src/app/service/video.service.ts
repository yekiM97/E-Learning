import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Course } from '../model/course.model';
import { Target } from '../model/target.model';
import { Video } from '../model/video.model';
import { CommandURL } from '../url/comman-url';

@Injectable({
  providedIn: 'root',
})
export class VideoService {
  constructor(private http: HttpClient) {}

  //Normal
  //GET LIST
  getListVideo(json: any) {
    return this.http.post<Array<Video>>(CommandURL.LIST_VIDEO, json);
  }

  getListVideoByCourseId(json: any) {
    return this.http.post<Array<Video>>(CommandURL.LIST_VIDEO_BY_COURSE_ID, json);
  }

  //FIND
  findVideoByID(json: any){
    return this.http.post<Video>(CommandURL.FIND_VIDEO_BY_ID, json);
  }
  


  //ADMIN
  getListVideoAdmin(json: any) {
    return this.http.post<Array<Video>>(CommandURL.LIST_VIDEO_ADMIN, json);
  }
}

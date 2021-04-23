import { Component, OnInit } from '@angular/core';
import { ToastrService } from 'ngx-toastr';
import { Course } from 'src/app/model/course.model';
import { User } from 'src/app/model/user.model';
import { UserCourse } from 'src/app/model/userCourse.model';
import { CourseService } from 'src/app/service/course.service';
import { UserService } from 'src/app/service/user.service';
import { UserCourseService } from 'src/app/service/userCourse.service';

@Component({
  selector: 'app-my-course',
  templateUrl: './my-course.component.html',
  styleUrls: ['./my-course.component.scss']
})
export class MyCourseComponent implements OnInit {
  user: User;
  listUserCourse: Array<UserCourse>;
  listCourse: Array<Course>;
  constructor(private userService : UserService,private courseService: CourseService,private userCourseService: UserCourseService,private toastrService: ToastrService) { }

  ngOnInit(): void {
    this.findUserByEmail();
  }

  findUserByEmail(){
    const json = {
      email: localStorage.getItem("email"),
    }
    this.userService.findUserByEmail(json).subscribe(data => {
      if(data){
        this.user = data
        this.getListUserCourse(this.user.id)
      }
    },
    error => console.log("Lỗi"))
  }

  getListUserCourse(id: number){
    
    const json = {
      user_id: id
    }
    this.courseService.getListCourseByUserID(json).subscribe(data => {
      if(data){
        this.listCourse = data
      }
    },
    error => this.toastrService.error("Không có tồn tại khóa học","Lỗi",{timeOut: 3000}))
  }
}

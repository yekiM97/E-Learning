import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Params } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { Course } from 'src/app/model/course.model';
import { Target } from 'src/app/model/target.model';
import { User } from 'src/app/model/user.model';
import { UserCourse } from 'src/app/model/userCourse.model';
import { Video } from 'src/app/model/video.model';
import { CourseService } from 'src/app/service/course.service';
import { TargetService } from 'src/app/service/target.service';
import { UserService } from 'src/app/service/user.service';
import { UserCourseService } from 'src/app/service/userCourse.service';
import { VideoService } from 'src/app/service/video.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-details',
  templateUrl: './details.component.html',
  styleUrls: ['./details.component.scss'],
})
export class DetailsComponent implements OnInit {
  listCourse: Array<Course>;
  listTarget: Array<Target>;
  listVideo: Array<Video>;
  isBuy: boolean = false;
  loading: boolean;
  user: User;
  course: Course;
  idCourse: number;
  public idUserCourse: number;
  userCourse: UserCourse;


  constructor(
    private courseService: CourseService,
    private targetService: TargetService,
    private videoService: VideoService,
    private userService: UserService,
    private userCourseService: UserCourseService,
    private toastr: ToastrService,
    private route: ActivatedRoute
  ) {}

  ngOnInit(): void {
    this.route.params.subscribe((params : Params) => this.idCourse = params['id'])
    this.findCourseByID();
    this.getListTarget();
    this.getListVideo();
    this.findUserByEmail();

  }

  findUserByEmail(){
    const json = {
      email: localStorage.getItem("email"),
    }
    this.userService.findUserByEmail(json).subscribe(data => {
      if(data){
        this.user = data
        this.findUserCourseByCourseID(data.id)
      }
    },
    error => console.log("Lỗi"))
  }
 
  findCourseByID() {
    const json = {
      id:  this.idCourse,
    };
    this.courseService.findCourseByID(json).subscribe(
      (data) => {
        if (data) {
          this.course = data;
        }
      },
      (error) => this.toastr.error('Lỗi', 'Thông báo')
    );
  }

  findUserCourseByCourseID(userId: number){
    const json = {
      course_id: this.idCourse,
      user_id: userId
    }
    this.userCourseService.findUserCourseByCourseID(json).subscribe(data => {
      if(data){
        this.userCourse = data;
        this.idUserCourse = data.id
        
        this.isBuy = true;
      }
      else{
        this.isBuy = false;
      }
    },
    error => console.log(error))
  }

  getListTarget() {
    const json = {
      course_id: this.idCourse,
    };
    this.targetService.findTargetByCourseID(json).subscribe(
      (data) => {
        if (data) {
          this.listTarget = data;
        }
      },
      (error) => this.toastr.error('Lỗi', 'Thông báo')
    );
  }

  getListVideo(){
    const json ={
      course_id: this.idCourse
    };
    this.videoService.getListVideoByCourseId(json).subscribe(data => {
      if(data){
        this.listVideo = data;
      }
    },
    (error) => this.toastr.error('Lỗi', 'Thông báo'))
  }

  addCourseToUser(){
    this.isBuy = false;
    this.loading = true;
    const json={
      course_id: this.idCourse, 
      user_id: this.user.id,
      role_id: this.user.role_id
    }
    this.userCourseService.addUserCourse(json).subscribe(data => {
      if(data){
        console.log(data)
        this.isBuy = true;
        this.loading = false;
        this.toastr.success("Đăng ký khóa học thành công","Thông báo")
      }
      else{
        this.toastr.error("Không được đăng ký 1 khóa học quá 2 lần","Lỗi")
      }
    },
    error => {
      this.toastr.error("Đăng ký thất bại","Lỗi")
      this.loading = false;
      this.isBuy = false;
    })
  }

  deleteCourse(id: number){
    Swal.fire({
      title: "ÁD" ,
      imageHeight: 150,
      imageWidth: 320,
      animation: true,
      showCancelButton: true,
      confirmButtonColor: "#3085d6",
      cancelButtonColor: "",
      confirmButtonText: "Dồng ý",
      cancelButtonText: "Bỏ qua"
    }).then((result) => {
        if(result){
          const json = {
            id: id
          }
          this.userCourseService.deleteUserCourse(json).subscribe(data => {
            if(data){
              this.toastr.success("Bạn đã hoàn thành khóa học","Thông báo")
              this.isBuy = false;
            }
            else{
              this.toastr.error("Bạn chưa hoàn thành khóa học","Thông báo")
              this.isBuy = true;

            }
          },
          error => this.toastr.error("Khóa học chưa được hoàn thành","Lỗi"));
        }
      });


   
  }
}

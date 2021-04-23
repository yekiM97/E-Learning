import { Component, OnInit } from '@angular/core';
import { ToastrService } from 'ngx-toastr';
import { Categories } from 'src/app/model/categories.model';
import { Course } from 'src/app/model/course.model';
import { CategoryService } from 'src/app/service/category.service';
import { CourseService } from 'src/app/service/course.service';

@Component({
  selector: 'app-home-page',
  templateUrl: './home-page.component.html',
  styleUrls: ['./home-page.component.scss'],
})
export class HomePageComponent implements OnInit {
  listCourse: Array<Course>;
  listIcon: Array<Categories>;

  constructor(
    private courseService: CourseService,
    private cateService: CategoryService,
    private toastr: ToastrService
  ) {}

  ngOnInit(): void {
    this.getListCourse();
    this.getListCategory();
  }

  getListCourse() {
    const json = {};
    this.courseService.getListCourse(json).subscribe(
      (data) => {
        if (data) {
          this.listCourse = data;
        }
      },
      (error) => this.toastr.error("Lỗi","Thông báo")
    );
  }

  getListCategory() {
    const json = {};
    this.cateService.getListCategory(json).subscribe((data) => {
      if (data) {
        this.listIcon = data;
      }
    },
    (error) => this.toastr.error("Lỗi","Thông báo"));
  }
}

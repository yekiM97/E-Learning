 
 import { NgModule } from '@angular/core';
 import { CommonModule } from '@angular/common';
 import { environment } from 'src/environments/environment';
 
 @NgModule({
   declarations: [],
   imports: [CommonModule],
 })
 export class BaseURL {
    //ADMIN PORT
  public static PORT_ADMIN_CATEGORY = environment.PORT_ADMIN + 'category/';

  public static PORT_ADMIN_COURSE = environment.PORT_ADMIN + 'course/';

  public static PORT_ADMIN_ROLE = environment.PORT_ADMIN + 'role/';

  public static PORT_ADMIN_TARGET = environment.PORT_ADMIN + 'target/';

  public static PORT_ADMIN_USER_COURSE = environment.PORT_ADMIN + 'userCourse/';

  public static PORT_ADMIN_USER = environment.PORT_ADMIN + 'user/';

  public static PORT_ADMIN_VIDEO = environment.PORT_ADMIN + 'video/';

  public static PORT_ADMIN_LOGIN = environment.PORT_ADMIN + 'login';
 }
 
 
export class CommandURL {
 
    public static LOGIN_ADMIN = BaseURL.PORT_ADMIN_LOGIN;
 /*
  ADMIN
  */
  //Category
  public static LIST_CATEGORY_ADMIN = BaseURL.PORT_ADMIN_CATEGORY + 'getListCategory';

  public static ADD_CATEGORY_ADMIN = BaseURL.PORT_ADMIN_CATEGORY + 'addCategory';

  public static EDIT_CATEGORY_ADMIN = BaseURL.PORT_ADMIN_CATEGORY + 'editCategory';

  public static DELETE_CATEGORY_ADMIN = BaseURL.PORT_ADMIN_CATEGORY + 'deleteCategory';

  public static FIND_CATEGORY_ADMIN_BY_ID = BaseURL.PORT_ADMIN_CATEGORY + 'findCategoryByID';


  //User
  public static LIST_USER_ADMIN = BaseURL.PORT_ADMIN_USER + 'getListUser';

  public static ADD_USER_ADMIN = BaseURL.PORT_ADMIN_USER + 'addUser';

  public static EDIT_USER_ADMIN = BaseURL.PORT_ADMIN_USER + 'editUser';

  public static FIND_USER_BY_EMAIL_ADMIN = BaseURL.PORT_ADMIN_USER + 'findByEmail';

  public static FIND_USER_BY_ID_ADMIN = BaseURL.PORT_ADMIN_USER + 'findByID';

  //Course
  public static LIST_COURSE_ADMIN = BaseURL.PORT_ADMIN_COURSE + 'getListCourse';

  public static ADD_COURSE_ADMIN = BaseURL.PORT_ADMIN_COURSE + 'addCourse';

  public static EDIT_COURSE_ADMIN = BaseURL.PORT_ADMIN_COURSE + 'editCourse';

  public static DELETE_COURSE_ADMIN = BaseURL.PORT_ADMIN_COURSE + 'deleteCourse';

  public static FIND_COURSE_ADMIN_BY_ID = BaseURL.PORT_ADMIN_COURSE + 'findCourseByID';


  //Role
  public static LIST_ROLE_ADMIN = BaseURL.PORT_ADMIN_ROLE + 'getListRole';

  public static ADD_ROLE_ADMIN = BaseURL.PORT_ADMIN_ROLE + 'addRole';

  public static EDIT_ROLE_ADMIN = BaseURL.PORT_ADMIN_ROLE + 'editRole';

  public static DELETE_ROLE_ADMIN = BaseURL.PORT_ADMIN_ROLE + 'deleteRole';

  public static FIND_ROLE_ADMIN_BY_ID = BaseURL.PORT_ADMIN_ROLE + 'findRoleByID';


  //Target
  public static LIST_TARGET_ADMIN = BaseURL.PORT_ADMIN_TARGET + 'getListTarget';

  public static ADD_TARGET_ADMIN = BaseURL.PORT_ADMIN_TARGET + 'addTarget';

  public static EDIT_TARGET_ADMIN = BaseURL.PORT_ADMIN_TARGET + 'editTarget';

  public static DELETE_TARGET_ADMIN = BaseURL.PORT_ADMIN_TARGET + 'deleteTarget';

  public static FIND_TARGET_ADMIN_BY_ID = BaseURL.PORT_ADMIN_TARGET + 'findTargetByID';


  //User Course
  public static LIST_USER_COURSE_ADMIN =
    BaseURL.PORT_ADMIN_USER_COURSE + 'getListUserCourse';

  public static ADD_USER_COURSE_ADMIN = BaseURL.PORT_ADMIN_USER_COURSE + 'addUserCourse';

  public static EDIT_USER_COURSE_ADMIN = BaseURL.PORT_ADMIN_USER_COURSE + 'editUserCourse';

  public static DELETE_USER_COURSE_ADMIN =
    BaseURL.PORT_ADMIN_USER_COURSE + 'deleteUserCourse';

    public static FIND_USER_COURSE_ADMIN_BY_ID = BaseURL.PORT_ADMIN_USER_COURSE + 'findUserCourseByID';


  //Video
  public static LIST_VIDEO_ADMIN = BaseURL.PORT_ADMIN_VIDEO + 'getListVideo';

  public static ADD_VIDEO_ADMIN = BaseURL.PORT_ADMIN_VIDEO + 'addVideo';

  public static EDIT_VIDEO_ADMIN = BaseURL.PORT_ADMIN_VIDEO + 'editVideo';

  public static DELETE_VIDEO_ADMIN = BaseURL.PORT_ADMIN_VIDEO + 'deleteVideo';

  public static FIND_VIDEO_ADMIN_BY_ID = BaseURL.PORT_ADMIN_VIDEO + 'findVideoByID';
}
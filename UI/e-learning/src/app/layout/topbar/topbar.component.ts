import { Component, OnInit } from '@angular/core';
import {
  FormBuilder,
  FormControl,
  FormGroup,
  Validators,
} from '@angular/forms';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { ToastrService } from 'ngx-toastr';
import { Categories } from 'src/app/model/categories.model';
import { User } from 'src/app/model/user.model';
import { AuthenticateService } from 'src/app/service/authenticate.service';
import { CategoryService } from 'src/app/service/category.service';
import { UserService } from 'src/app/service/user.service';

@Component({
  selector: 'app-topbar',
  templateUrl: './topbar.component.html',
  styleUrls: ['./topbar.component.scss'],
})
export class TopbarComponent implements OnInit {
  listIcon: Array<Categories>;
  loading: boolean;
  email: string;
  user: User;
  isLogin: boolean;
  token: string;
  isSignIn: boolean = false;
  formSignIn: FormGroup;
  formSignUp: FormGroup;
  constructor(
    private cateService: CategoryService,
    private modalService: NgbModal,
    private authService: AuthenticateService,
    private toastrService: ToastrService,
    private userService: UserService,
    private formBuilder: FormBuilder
  ) {}

  ngOnInit(): void {
    if(localStorage.getItem("token")){
      this.isLogin = true;
      this.findUserByEmail(localStorage.getItem("email"));
    }
    else{
      this.isLogin = false
    }
    this.getListCategory();
    
  }

  getListCategory() {
    const json = {};
    this.cateService.getListCategory(json).subscribe((data) => {
      if (data) {
        this.listIcon = data;
      }
    });
  }

  openModal(isLogin: boolean, content: any) {
    if (isLogin) {
      this.formSignIn = new FormGroup({
        email: new FormControl('', [Validators.required, Validators.email]),
        password: new FormControl('', [Validators.required]),
      });
      this.isSignIn = isLogin;
    } else {
      this.formSignUp = new FormGroup({
        email: new FormControl('', [Validators.required, Validators.email]),
        password: new FormControl('', [Validators.required,Validators.pattern("^[a-zA-Z0-9]*$")]),
        confirmPassword: new FormControl('', [Validators.required,Validators.pattern("^[a-zA-Z0-9]*$")]),
        fullname: new FormControl('', [Validators.required]),
      });
      this.isSignIn = isLogin;
    }
    this.modalService.open(content, {
      centered: true,
      size: 'md',
      backdrop: 'static',
    });
  }

  onSubmit(value: User) {
    this.loading = true;
    if (this.isSignIn) {
      const json = {
        email: value.email,
        password: value.password,
      };
      this.authService.login(json).subscribe(
        (data) => {
          if (data) {
            this.modalService.dismissAll(),
            this.token = data.token,
            this.email = data.email,
            this.toastrService.success('Đăng nhập thành công', 'Thông báo')
            this.isLogin = true;
            this.findUserByEmail(this.email);
            localStorage.setItem("token",this.token),
            localStorage.setItem("email",data.email),
            this.loading = false;
          }
        },
        (error) => {
          this.toastrService.error('Lỗi token', 'Thông báo');
        }
      );
    } else {
      const json = {
        fullname: value.fullname,
        email: value.email,
        password: value.password,
        address: '',
        phone: '',
        role_id: 2,
        avatar: '',
      };
      this.authService.register(json).subscribe(
        (data) => {
          if (data) {
            this.modalService.dismissAll(),
            this.email = data.email,
            this.toastrService.success('Đăng ký thành công', 'Thông báo');
           
          }
        },
        (error) => this.toastrService.error('Lỗi', 'Thông báo')
      );
    }
  }


  findUserByEmail(email: string){
    const json = {
      email: email
    }
    this.userService.findUserByEmail(json).subscribe(data => {
      if(data){
        this.user = data;
      }
    })
  }
  closeModal(callback: () => void) {
    callback();
  }

  logOut() {
    this.isLogin = false;
    localStorage.clear();
  
  }
}

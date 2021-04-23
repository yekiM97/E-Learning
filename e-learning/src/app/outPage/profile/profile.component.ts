import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { ToastrService } from 'ngx-toastr';
import { User } from 'src/app/model/user.model';
import { UserDTO } from 'src/app/model/userDTO.model';
import { UserService } from 'src/app/service/user.service';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.scss'],
})
export class ProfileComponent implements OnInit {
  isSubmit: boolean;
  loading: boolean;
  aa: string;
  user: User;
  form: FormGroup;
  formAvatar: FormGroup;
  formPassword: FormGroup;
  constructor(
    private userService: UserService,
    private formBuilder: FormBuilder,
    private toastr: ToastrService
  ) {}

  ngOnInit(): void {
    this.Init();
  }

  findUserByID(){
    const json = {
      email: localStorage.getItem("email"),
    }
    this.userService.findUserByEmail(json).subscribe(data => {
      if(data){
        this.user = data
        this.form.patchValue(data);
        this.formPassword.patchValue(data);
      }
    },
    error => this.toastr.error("Người dùng không tồn tại","Lỗi"))
  }

  Init() {
    this.findUserByID();
    this.form = new FormGroup({
      id: new FormControl("", [Validators.required]),
      email: new FormControl("", [Validators.required,Validators.email]),
      fullname: new FormControl("", [Validators.required]),
      address: new FormControl("", [Validators.required]),
      phone: new FormControl("", [Validators.required]),
      newPassword: new FormControl("", [Validators.required,Validators.pattern("")]),
      password: new FormControl("", [Validators.required,Validators.pattern("^[a-zA-Z0-9]*$")]),
      avatar: new FormControl("", [Validators.required]),
    });

    this.formPassword = new FormGroup({
      id: new FormControl("", [Validators.required]),
      email: new FormControl("", [Validators.required,Validators.email]),
      newPassword: new FormControl("", [Validators.required,Validators.pattern("^[a-zA-Z0-9]*$")]),
    });

  }

  update(value: User){
    this.loading = true;
    this.isSubmit = true;
    const json={
      id: value.id,
      email: value.email,
      fullname: value.fullname,
      address: value.address,
      phone: value.phone,
      avatar: value.avatar,
      role_id: this.user.role_id
    };
    
    this.userService.editUser(json).subscribe(data => {
      if(data){
        this.isSubmit = false;
        console.log("OK")
        this.toastr.success("Chỉnh sửa thành công","Thông báo",{timeOut: 5000}),
        this.loading = false;
      }else{
        this.toastr.error("Password mismatch","Thông báo",{timeOut: 5000}),
        this.isSubmit = false,
        this.loading = false;
      }
    },
    error =>  this.toastr.error("Chỉnh sửa thất bại","Lỗi",{timeOut: 5000})),this.isSubmit = false;
    this.Init();
  }

  updatePassword(value: UserDTO){
    this.loading = true;
    this.isSubmit = true;
    const json={
      email: value.email,
      password: value.newPassword,
    };
    
    this.userService.editUserPassword(json).subscribe(data => {
      if(data){
        this.isSubmit = false;
        console.log("OK password")
        this.toastr.success("Đổi mật khẩu thành công","Thông báo",{timeOut: 5000}),
        this.loading = false;
      }else{
        this.toastr.error("Password mismatch","Thông báo",{timeOut: 5000}),
        this.isSubmit = false,
        this.loading = false;
      }
    },
    error => { this.toastr.error("Đổi mật khẩu thất bại","Lỗi",{timeOut: 5000}),this.isSubmit = false});
    this.Init();
  }

  get f(){
    return this.form.controls;
  }
}

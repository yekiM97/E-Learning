import { Component, OnInit } from '@angular/core';
import { AbstractControl, FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Login } from '../model/login.module';
import { AuthenticateService } from '../service/authenticate.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {
  public loginForm: FormGroup;
  public submitted: boolean = false;
  public login: FormGroup;
  token: String;

  constructor(private fb: FormBuilder, private authen: AuthenticateService,private router: Router) { }

  ngOnInit(): void {
    this.initLoginForm();
  }


  public initLoginForm(): void {
    this.login = new FormGroup({
      email: new FormControl('',[Validators.required, Validators.email]),
      password: new FormControl('', [Validators.required]),
    })
  }

  Login(value: Login){
    const json = {
      email: value.email,
      password: value.password  
    }
    this.authen.loginAdmin(json).subscribe(data => {
      if(data){
        this.token = data.token;
        localStorage.setItem("token",data.token),
        this.router.navigate(['/home'])
      }
    })
  }
 
}

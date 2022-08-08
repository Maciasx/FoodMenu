import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { LoginService } from 'src/service/login.service';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {

  public signUp !: FormGroup;
  constructor(private formBuilder : FormBuilder, private http : HttpClient, private loginService: LoginService, private router:Router) { }

  ngOnInit(): void {
    this.signUp = this.formBuilder.group({
      username:['',Validators.required],
      email:['',Validators.required],
      password:['',Validators.required]
    })
  }

  addSignUp(){

    this.loginService.addSignUp(this.signUp).subscribe(
      (response: any) => {
        alert("Dodano użytkownika")
        this.signUp.reset();
        this.router.navigate(['login']);
      },
      (error: HttpErrorResponse) => {
        console.log(error);
        alert(error.error.message);
      }
    );
  }

}

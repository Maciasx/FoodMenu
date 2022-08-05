import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators} from '@angular/forms';
import { Router } from '@angular/router';
import { LoginService } from 'src/service/login.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  
  public login !: FormGroup
  constructor(private formBuilder: FormBuilder, private http: HttpClient, private loginService: LoginService, private router: Router) { }

  ngOnInit(): void {
    this.login = this.formBuilder.group({
      email:['',Validators.required],
      password:['', Validators.required]
    })
  }

  getLogin()
  {
    this.loginService.getLogin(this.login).subscribe(
      (response: any) => {
        if(response != null)
        {
        alert("Logowanie powiodło się");
        this.login.reset();
        this.router.navigate(['menu'])
        }
        else
        {
          alert("Nie ma takiego użytkownika")
        }
       }
      ,
      (error: HttpErrorResponse) => {
        alert("Coś poszło nie tak");
      }
    );
  }

  }


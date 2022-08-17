import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { User } from 'src/model/user';
import { LoginService } from 'src/service/login.service';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {

  public user: number;
  public updateUser !: FormGroup;
  public userDate: User;
  constructor(private formBuilder : FormBuilder, private http : HttpClient, private route: ActivatedRoute, private loginService: LoginService) { }

  ngOnInit(): void {


    this.route.params.subscribe(params => {
      this.user = params['user'];
      console.log(this.user);
    });

    this.getUser();

    this.updateUser = this.formBuilder.group({
      id:[this.user],
      sex:[''],
      height: [''],
      weight: [''],
      age: ['']
    })

    
  }


  update(){

    this.loginService.updateUser(this.updateUser).subscribe(
      (response: any) => {
        alert("Zmieniono dane użytkownika")
      },
      (error: HttpErrorResponse) => {
        alert("Coś poszło nie tak");
      }
    );

    this.getUser();
  }

  public getUser(): void {
    this.loginService.getUserById(this.user).subscribe(
      (response: any) => {
        this.userDate = response;  
        console.log(this.userDate);     
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  reloadCurrentPage() {
    window.location.reload();
   }

}

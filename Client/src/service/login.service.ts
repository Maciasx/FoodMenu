import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { FormGroup } from '@angular/forms';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  private apiServerUrl = environment.apiBaseUrl;

  constructor(private http: HttpClient) { }


  addSignUp(signUp : FormGroup ) {
    return this.http.post<any>(`${this.apiServerUrl}/login/add`,signUp.value);
  }

  getLogin(login : FormGroup) {
    return this.http.post<any>(`${this.apiServerUrl}/login/login`,login.value)
  }
}

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
    return this.http.post<any>(`${this.apiServerUrl}/login/registration`,signUp.value);
  }

  getLogin(login : FormGroup) {
    return this.http.post<any>(`${this.apiServerUrl}/login`, login.value)
  }

  updateUser(updateUser: FormGroup) {
    console.log(updateUser)
    return this.http.put<any>(`${this.apiServerUrl}/login/update`, updateUser.value)
  }

  getUserById(user : Number) {
    return this.http.get<any>(`${this.apiServerUrl}/login/find/${user}`)
  }

  getDailyEnergy(user: number) {
    return this.http.get<any>(`${this.apiServerUrl}/login/energy/${user}`)
  }
}

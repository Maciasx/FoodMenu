import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { FormGroup } from '@angular/forms';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Food } from 'src/model/food';

@Injectable({
  providedIn: 'root'
})
export class FoodService {
  addFood(food: FormGroup<any>) {
    return this.http.post<Food[]>(`${this.apiServerUrl}/food/add`,food.value);
  }
  private apiServerUrl= environment.apiBaseUrl;

  constructor(private http: HttpClient) { }

  public getFoods(): Observable<Food[]> {
    return this.http.get<Food[]>(`${this.apiServerUrl}/food/all`);
  }

}

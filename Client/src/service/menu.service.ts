import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { FormGroup } from '@angular/forms';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Menu } from 'src/model/menu';

@Injectable({
  providedIn: 'root'
})
export class MenuService {
  private apiServerUrl= environment.apiBaseUrl;

  constructor(private http: HttpClient) { }

  getMenuByDate(DataSelected: Date) {
    return this.http.get<Menu[]>(`${this.apiServerUrl}/menu/find/${DataSelected}`)
  }

  public getAllMenu(): Observable<Menu[]> {
    return this.http.get<Menu[]>(`${this.apiServerUrl}/menu/all`);
  }

  deleteMenu(menuId: number) {
    return this.http.delete<void>(`${this.apiServerUrl}/menu/delete/${menuId}`);
  }
  
  addFood(pickFood: FormGroup) {
    return this.http.post<any>(`${this.apiServerUrl}/menu/add`,pickFood.value)
  }
}

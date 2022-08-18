import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { FormGroup } from '@angular/forms';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class NoteService {
 
  private apiServerUrl= environment.apiBaseUrl;

  constructor(private http: HttpClient) { }


  public addNote(note: FormGroup) {
    return this.http.post<any>(`${this.apiServerUrl}/note/add`,note.value)
  }

  public getNote(note: FormGroup): Observable<any> {
    return this.http.get<any>(`${this.apiServerUrl}/note/get`,note.value);
  }


}

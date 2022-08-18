import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { FoodService } from 'src/service/food.service';
import { MenuService } from 'src/service/menu.service';
import { NoteService } from 'src/service/note.service';

@Component({
  selector: 'app-note',
  templateUrl: './note.component.html',
  styleUrls: ['./note.component.css']
})
export class NoteComponent implements OnInit {


  public noteData !: FormGroup;
  public meal: number;
  public date: Date;
  public user: number;
  
  constructor(private formBuilder : FormBuilder,private route: ActivatedRoute, private noteService: NoteService) { }

  ngOnInit(): void {

    this.route.params.subscribe(params => {
      this.meal = params['meal'];
      this.date = params['date'];
      this.user = params['user'];
    });


    this.noteData = this.formBuilder.group({
      user:[this.user],
      dateMenu:[this.date],
      meal:[this.meal],
      note:['',Validators.required]
    })
  }


  public addNote(){
    this.noteService.addNote(this.noteData).subscribe(
      (response: void) => {
        console.log(this.noteData);
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
    
  }
}

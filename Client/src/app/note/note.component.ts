import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { Note } from 'src/model/note';
import { User } from 'src/model/user';
import { NoteService } from 'src/service/note.service';

@Component({
  selector: 'app-note',
  templateUrl: './note.component.html',
  styleUrls: ['./note.component.css']
})
export class NoteComponent implements OnInit {

  public notes : Note;
  public noteData !: FormGroup;
  public meal: number;
  public date: Date;
  public user: number;
  public id: number;
  
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

    this.getNote();
  }

  public getNote(): void {
    this.noteService.getNote(this.noteData).subscribe(
      (response: Note) => {
        console.log(response);
        this.notes = response;
        this.noteData.patchValue({note:[this.notes.note]});
        this.id = this.notes.id;
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }


  public addNote(){

    this.noteData.addControl('id', new FormControl(this.id));
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

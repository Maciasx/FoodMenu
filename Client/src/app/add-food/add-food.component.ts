import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { FoodService } from 'src/service/food.service';
import { LoginService } from 'src/service/login.service';

@Component({
  selector: 'app-add-food',
  templateUrl: './add-food.component.html',
  styleUrls: ['./add-food.component.css']
})
export class AddFoodComponent implements OnInit {

  public food !: FormGroup;
  public user: number;
  constructor(private formBuilder : FormBuilder, private http : HttpClient, private foodService: FoodService, private route: ActivatedRoute) { }

  ngOnInit(): void {

    this.route.params.subscribe(params => {
      this.user = params['user'];
    });

    this.food = this.formBuilder.group({
      name:['',Validators.required],
      calorie: ['',Validators.required],
      protein: ['',Validators.required],
      fat: ['',Validators.required],
      carbohydrates: ['',Validators.required]
    })

   
  }

  addSignUp(){

    this.foodService.addFood(this.food).subscribe(
      (response: any) => {
        alert("Dodano produkt do bazy")
        this.food.reset();
      },
      (error: HttpErrorResponse) => {
        alert("Coś poszło nie tak");
      }
    );
  }

}

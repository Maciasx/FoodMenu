import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { Food } from 'src/model/food';
import { FoodService } from 'src/service/food.service';
import { MenuService } from 'src/service/menu.service';

@Component({
  selector: 'app-pick-food',
  templateUrl: './pick-food.component.html',
  styleUrls: ['./pick-food.component.css']
})
export class PickFoodComponent implements OnInit {

  public pickFood !: FormGroup;
  public meal: number;
  public date: Date;
  public user: number;
  public foods: Food[];
  constructor(private formBuilder : FormBuilder,private route: ActivatedRoute, private foodService: FoodService, private menuService: MenuService) { }


  ngOnInit(): void {

    this.getFood();

    this.route.params.subscribe(params => {
      this.meal = params['meal'];
      this.date = params['date'];
      this.user = params['user'];
    });

    this.pickFood = this.formBuilder.group({
      user:[this.user],
      dateMenu:[this.date],
      meal:[this.meal],
      food:[''],
      weight: ['',Validators.required]
    })

  }

  public getFood(){
    this.foodService.getFoods().subscribe(
      (response: any) => {
        this.foods = response;  
        console.log(this.foods);     
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  public addFood(){
    this.menuService.addFood(this.pickFood).subscribe(
      (response: void) => {
        console.log(this.pickFood);
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
    
  }
}

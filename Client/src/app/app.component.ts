import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Food } from '../model/food';
import { FoodService } from '../service/food.service';
import { Menu } from '../model/menu';
import { MenuService } from '../service/menu.service';
import { DatePipe } from '@angular/common';
import { Meal } from '../model/meal';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})

export class AppComponent implements OnInit{
  foods: Food[];
  menus: Menu[];
  DataSelected : any = this.datePipe.transform(new Date(),"yyyy-MM-dd");
  allMeal = Meal;

  constructor(private foodService: FoodService,private menuService: MenuService, private datePipe:DatePipe){}
  ngOnInit() {
    this.getAllMenu();
  }

  addFood()
  {

  }

  editFood()
  {

  }

  public deleteFood(menuId: number)
  {
    this.menuService.deleteMenu(menuId).subscribe(
      (response: void) => {
        console.log(response);
        this.getAllMenu();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }
  

    public getFoods(): void {
      this.foodService.getFoods().subscribe(
        (response: Food[]) => {
          this.foods = response;
        },
        (error: HttpErrorResponse) => {
          alert(error.message);
        }
      );
    }

    public getAllMenu(): void {
      this.menuService.getMenuByDate(this.DataSelected).subscribe(
        (response: Menu[]) => {
          this.menus = response;  
          console.log(this.menus);     
        },
        (error: HttpErrorResponse) => {
          alert(error.message);
        }
      );
    }

  


  }
  


import { DatePipe } from '@angular/common';
import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Food } from 'src/model/food';
import { Meal } from 'src/model/meal';
import { Menu } from 'src/model/menu';
import { FoodService } from 'src/service/food.service';
import { MenuService } from 'src/service/menu.service';

@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.css']
})
export class MenuComponent implements OnInit {

  foods: Food[];
  menus: Menu[];
  DataSelected : any = this.datePipe.transform(new Date(),"yyyy-MM-dd");
  allMeal = Meal;
  

  constructor(private foodService: FoodService,private menuService: MenuService, private datePipe:DatePipe){}
  ngOnInit() {
    this.getAllMenu();
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

import { DatePipe } from '@angular/common';
import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
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

  public foods: Food[];
  public menus: Menu[];
  public dataSelected : any = this.datePipe.transform(new Date(),"yyyy-MM-dd");
  public allMeal = Meal;
  public user: number;
  
  constructor(private foodService: FoodService,private menuService: MenuService, private datePipe:DatePipe, private route: ActivatedRoute){}
  ngOnInit() {
    this.getAllMenu();
    this.route.params.subscribe(params => {
      this.user = params["user"];
    });
    console.log(this.user);
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
      this.menuService.getMenuByDate(this.dataSelected).subscribe(
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

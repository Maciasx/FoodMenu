import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Food } from './food';
import { FoodService } from './food.service';
import { MatTableDataSource } from '@angular/material/table';
import { Menu } from './menu';
import { MenuService } from './menu.service';
import { animate, state, style, transition, trigger } from '@angular/animations';
import { DatePipe } from '@angular/common';
import { Meal } from './meal';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
  animations: [
    trigger('detailExpand', [
      state('collapsed', style({ height: '0px', minHeight: '0' })),
      state('expanded', style({ height: '*' })),
      transition('expanded <=> collapsed', animate('225ms cubic-bezier(0.4, 0.0, 0.2, 1)')),
    ]),
  ],
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
  


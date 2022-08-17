import { DatePipe } from '@angular/common';
import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Food } from 'src/model/food';
import { Meal } from 'src/model/meal';
import { Menu } from 'src/model/menu';
import { FoodService } from 'src/service/food.service';
import { LoginService } from 'src/service/login.service';
import { MenuService } from 'src/service/menu.service';


@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.css']
})

export class MenuComponent implements OnInit {

  public menus: Menu[];
  public dataSelected : any = this.datePipe.transform(new Date(),"yyyy-MM-dd");
  public allMeal = Meal;
  public user: number;
  public dailyEnergy: number = 0;
  public menuEnergy : number = 0;
  
  constructor(private foodService: FoodService,private menuService: MenuService,private loginService: LoginService, private datePipe:DatePipe, private route: ActivatedRoute){}
  
  ngOnInit() {
    this.route.params.subscribe(params => {
      this.user = params["user"];
    });

    this.getAllMenu();

  }


  public getDailyEnergy() {
    this.loginService.getDailyEnergy(this.user).subscribe(
      (response: any) => {
        this.dailyEnergy = response;  
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
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

    public getAllMenu(): void {
      this.menuEnergy = 0;
      this.menuService.getAllMenu(this.dataSelected,this.user).subscribe(
        (response: Menu[]) => {
          this.menus = response;
          console.log(this.menus);

          this.menus.forEach(e => {
            this.menuEnergy = this.menuEnergy + e.food.energy;
          })

          console.log(this.menuEnergy);
          this.getDailyEnergy();
        },
        (error: HttpErrorResponse) => {
          alert(error.message);
        }
      );
    }
}

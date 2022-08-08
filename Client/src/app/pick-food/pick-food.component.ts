import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-pick-food',
  templateUrl: './pick-food.component.html',
  styleUrls: ['./pick-food.component.css']
})
export class PickFoodComponent implements OnInit {

  public meal: number;
  public date: String;
  public user: number;
  constructor(private route: ActivatedRoute) { }


  ngOnInit(): void {
    this.route.params.subscribe(params => {
      this.meal = params['meal'];
      this.date = params['date'];
      this.user = params['user'];
    });


  }

}

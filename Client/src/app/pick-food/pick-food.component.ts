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
  constructor(private route: ActivatedRoute) { }


  ngOnInit(): void {
    let meal = Number(this.route.snapshot.paramMap.get('meal'));
    this.meal = meal;

    let date = String(this.route.snapshot.paramMap.get('date'));
    this.date = date;
  }

}

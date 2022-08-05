import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-pick-food',
  templateUrl: './pick-food.component.html',
  styleUrls: ['./pick-food.component.css']
})
export class PickFoodComponent implements OnInit {

  public meal: number;
  constructor(private route: ActivatedRoute) { }


  ngOnInit(): void {
    let meal = Number(this.route.snapshot.paramMap.get('meal'));
    this.meal = meal;
  }

}

import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PickFoodComponent } from './pick-food.component';

describe('PickFoodComponent', () => {
  let component: PickFoodComponent;
  let fixture: ComponentFixture<PickFoodComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PickFoodComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(PickFoodComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

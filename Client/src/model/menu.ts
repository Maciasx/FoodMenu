import { DatePipe } from "@angular/common";
import { Food } from "./food";
import { Meal } from "./meal";

export interface Menu {
    id: number,
    foods: Food,
    meal: Meal,
    dateMenu: Date;
}
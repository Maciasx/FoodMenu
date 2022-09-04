import { Meal } from "./meal";
import { User } from "./user";

export interface Note {
    id: number,
    note: String,
    meal: Meal,
    dateMenu: Date,
    user: User;
}

import { NgModule } from "@angular/core";
import { RouterModule, Routes} from '@angular/router'
import { AddFoodComponent } from "./add-food/add-food.component";
import { LoginComponent } from "./login/login.component";
import { MenuComponent } from "./menu/menu.component";
import { PickFoodComponent } from "./pick-food/pick-food.component";
import { SignupComponent } from "./signup/signup.component";

const routes: Routes = [
 {path:'', redirectTo:'login', pathMatch:'full'},
 {path:'login', component:LoginComponent},
 {path:'signup', component:SignupComponent},
 {path:'menu',component:MenuComponent},
 {path:'pickFood/:date/:meal',component:PickFoodComponent},
 {path:'addFood',component:AddFoodComponent}

]

@NgModule({
    imports:[RouterModule.forRoot(routes)],
    exports: [RouterModule]
})

export class AppRoutingModule {}
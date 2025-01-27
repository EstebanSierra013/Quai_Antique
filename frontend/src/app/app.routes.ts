import { Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { ProfileComponent } from './profile/profile.component';
import { DishFormComponent } from './dish-form/dish-form.component';
import { RestaurantFormComponent } from './restaurant-form/restaurant-form.component';
import { MenuFormComponent } from './menu-form/menu-form.component';

export const routes: Routes = [
  {
    path: '',
    component: HomeComponent,
    title: "Restaurant Quai Antique"
  },
  {
    path: 'profile',
    component: ProfileComponent,
    title: "Restaurant Quai Antique"
  },
  {
    path: 'gestion-dish',
    component: DishFormComponent,
    title: "Restaurant Quai Antique"
  },
  {
    path: 'gestion-menu',
    component: MenuFormComponent,
    title: "Restaurant Quai Antique"
  },
  {
    path: 'gestion-restaurant',
    component: RestaurantFormComponent,
    title: "Restaurant Quai Antique"
  },
  {
    path: "**",
    redirectTo: '',
    pathMatch: 'full'
  }
];

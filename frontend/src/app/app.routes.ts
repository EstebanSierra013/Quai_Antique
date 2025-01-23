import { Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { ProfileComponent } from './profile/profile.component';

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
    path: "**",
    redirectTo: '',
    pathMatch: 'full'
  }
];

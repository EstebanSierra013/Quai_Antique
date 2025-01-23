import { Component } from '@angular/core';
import { NavbarComponent } from '../navbar/navbar.component';
import { HeroComponent } from '../hero/hero.component';
import { AboutComponent } from './about/about.component';
import { CarteHomeComponent } from './carte-home/carte-home.component';
import { GaleryHomeComponent } from './galery-home/galery-home.component';
import { ScheduleHomeComponent } from './schedule-home/schedule-home.component';
import { FooterComponent } from '../footer/footer.component';

@Component({
  selector: 'app-home',
  imports: [NavbarComponent, HeroComponent, AboutComponent, CarteHomeComponent, GaleryHomeComponent, ScheduleHomeComponent, FooterComponent],
  templateUrl: './home.component.html',
  styleUrl: './home.component.css',
})
export class HomeComponent {}

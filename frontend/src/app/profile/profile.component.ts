import { Component } from '@angular/core';
import { NavbarComponent } from '../navbar/navbar.component';
import { FooterComponent } from '../footer/footer.component';
import { PersonalInfoComponent } from './personal-info/personal-info.component';
import { ListReservationsComponent } from './list-reservations/list-reservations.component';

@Component({
  selector: 'app-profile',
  imports: [NavbarComponent, FooterComponent, PersonalInfoComponent, ListReservationsComponent],
  templateUrl: './profile.component.html',
  styleUrl: './profile.component.css'
})
export class ProfileComponent {

}

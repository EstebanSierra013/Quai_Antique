import { Component } from '@angular/core';
import { NavbarComponent } from '../navbar/navbar.component';
import { FooterComponent } from '../footer/footer.component';
import { PersonalInfoComponent } from './personal-info/personal-info.component';
import { ListReservationsComponent } from './list-reservations/list-reservations.component';
import { User } from '../models/user';
import { UserService } from '../services/user.service';
import { ActivatedRoute, RouterModule, Router } from '@angular/router';

@Component({
  selector: 'app-profile',
  imports: [NavbarComponent, FooterComponent, PersonalInfoComponent, ListReservationsComponent, RouterModule],
  templateUrl: './profile.component.html',
  styleUrl: './profile.component.css'
})
export class ProfileComponent {
  user?: User;

  constructor(private userService:UserService, private activatedRoute: ActivatedRoute, private router: Router) {}

  ngOnInit(): void { 
    let id = this.activatedRoute.snapshot.paramMap.get('id');
    this.getUserById("anesierrasa")
  }

  getUserById(id: string) {
    this.userService.getUserById(id).subscribe({
      next: (foundUser) => {
        this.user = foundUser;
      },
      error: () => {
        this.router.navigateByUrl('/');
      },
    });
  }
}

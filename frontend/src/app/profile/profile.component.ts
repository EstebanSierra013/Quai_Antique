import { Component } from '@angular/core';
import { NavbarComponent } from '../navbar/navbar.component';
import { FooterComponent } from '../footer/footer.component';
import { PersonalInfoComponent } from './personal-info/personal-info.component';
import { ListReservationsComponent } from './list-reservations/list-reservations.component';
import { UserService } from '../services/user.service';
import { ActivatedRoute, RouterModule, Router } from '@angular/router';
import { GestionMenuComponent } from "./gestion-menu/gestion-menu.component";

@Component({
  selector: 'app-profile',
  imports: [NavbarComponent, FooterComponent, PersonalInfoComponent, ListReservationsComponent, RouterModule, GestionMenuComponent],
  templateUrl: './profile.component.html',
  styleUrl: './profile.component.css'
})
export class ProfileComponent {
  user: any;
  isLoggedIn = false;
  isSaveInProgress = false;
  id = "anesierrasa";

  constructor(private userService:UserService, private activatedRoute: ActivatedRoute, private router: Router) {}

  ngOnInit(): void { 
    let id = this.activatedRoute.snapshot.paramMap.get('id');
    this.getUserById(this.id)
  }

  getUserById(id: string) {
    this.userService.getUserById(id).subscribe({
      next: (foundUser) => {        
        this.user = foundUser;
        this.isLoggedIn = true;
      },
      error: () => {
        this.router.navigateByUrl('/');
      },
    });
  }

  updateProfile(isSaveInProgress: boolean){
    this.isSaveInProgress = true;
    if(isSaveInProgress) this.getUserById(this.id);
  }
}

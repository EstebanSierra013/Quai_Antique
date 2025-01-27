import { Component, Input, SimpleChanges } from '@angular/core';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators} from '@angular/forms';
import { UserService } from '../../services/user.service';

@Component({
  selector: 'app-personal-info',
  imports: [ReactiveFormsModule],
  templateUrl: './personal-info.component.html',
  styleUrl: './personal-info.component.css'
})
export class PersonalInfoComponent {
  @Input() dataUser: any;
  profileForm!: FormGroup;

  constructor(private fb: FormBuilder, private userService: UserService) {
    this.profileForm = this.fb.group({
      firstname: ["", [Validators.required]],
      lastname: ["", [Validators.required]],
      email: ["", [Validators.required, Validators.email]],
      password: ["", [Validators.required]],
      guests: ["", [Validators.required]],
      allergy: ["", [Validators.required]],
    });  
  }

  
  ngOnInit() : void{
    this.profileForm.patchValue(this.dataUser);
  }
  
  ngOnChanges(changes: SimpleChanges): void {
    if (changes['datosUsuario']) {
      console.log('Datos actualizados en el componente hijo:', this.dataUser);
    }
  }

  onSubmit(): void {
    console.log(this.profileForm.value)
    const updatedUsuario = this.profileForm.value;
    this.userService.updateUser(updatedUsuario,this.dataUser.email).subscribe({
      next: () => {
        console.log('Utilisateur mis à jour :');
        alert('Utilisateur mis à jour avec succès.');
      },
      error: () => {
        console.error('Erreur lors de la mise à jour de l\'utilisateur :');
      },
    });              
  }

  onDelete(): void {
    if (confirm('¿Estás seguro de eliminar este usuario?')) {
      this.userService.deleteUser(this.dataUser.email).subscribe({
        next: () => {
          console.log('Utilisateur supprimé :');
          alert('Utilisateur supprimé avec succès.');
        },
        error: ()  => {
          console.error('Erreur lors de la suppression de l\'utilisateur :');
        },
      });
    }
  }

}

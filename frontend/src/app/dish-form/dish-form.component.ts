import { Component } from '@angular/core';
import { NavbarComponent } from "../navbar/navbar.component";
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Dish } from '../models/dish';
import { DishService } from '../services/dish.service';

@Component({
  selector: 'app-dish-form',
  imports: [NavbarComponent, ReactiveFormsModule],
  templateUrl: './dish-form.component.html',
  styleUrl: './dish-form.component.css'
})
export class DishFormComponent {
  dishForm!: FormGroup;
  isSaveInProgress: boolean = false;
  isDeleteInProgress: boolean = false;
  edit: boolean = false;
  dishList: Dish[] = [];

  constructor(private fb: FormBuilder, private dishService:DishService, private activatedRoute: ActivatedRoute, private router: Router) {
    this.dishForm = this.fb.group({
      idDish: [null],
      title: ["", [Validators.required]],
      description: ["", [Validators.required]],
      prix: ["", [Validators.required]],
    });  
  }

  ngOnInit(): void{
    this.getAllDishes();
  }

  getAllDishes(){
    this.dishService.getAllDishes().subscribe((data) => {
      this.dishList = data;
    })
  };  

  createDish(){
    console.log(this.dishForm.value)
    const createdDish = this.dishForm.value;
    this.dishService.createDish(createdDish).subscribe({
      next: () => {
        console.log('Dish creé');
        alert('Dish creé');
      },
      error: () => {
        console.error('Erreur lors de la création de la réservacion');
      },
    });      
  }

  updateDish(id: number){
    const updateDish = this.dishForm.value;
    this.dishService.updateDish(updateDish, id).subscribe({
      next: () => {
        console.log('Dish mis à jour');
        alert('Dish mis à jour avec succès.');
      },
      error: () => {
        console.error('Erreur lors de la mise à jour de la réservacion');
      },
    });     
  }

  deleteDish(id: number){
    this.isDeleteInProgress = true;
    this.dishService.deleteDish(id).subscribe({
      next: () => {
        console.log('Dish suprimée ');
        alert('Dish suprimée');
      },
      error: () => {
        console.error('Erreur lors de supprimer la réservacion');
      },
    });  
  }
}

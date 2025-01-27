import { Component, ElementRef, Input, ViewChild } from '@angular/core';
import { NavbarComponent } from "../navbar/navbar.component";
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { RestaurantService } from '../services/restaurant.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Restaurant } from '../models/restaurant';

@Component({
  selector: 'app-restaurant-form',
  imports: [NavbarComponent, ReactiveFormsModule],
  templateUrl: './restaurant-form.component.html',
  styleUrl: './restaurant-form.component.css'
})
export class RestaurantFormComponent {
  restaurantForm!: FormGroup;
  dataRestaurant : any;
  isDeleteInProgress: boolean = false;
  edit: boolean = false;
  restaurantList: Restaurant[] = [];
  @ViewChild("closebutton") modal!: ElementRef;

  constructor(private fb: FormBuilder, private restaurantService:RestaurantService, private activatedRoute: ActivatedRoute, private router: Router) {
    this.restaurantForm = this.fb.group({
      idRestaurant: [null],
      name: ["", [Validators.required]],
      description: ["", [Validators.required]],
      amOpeningTime: ["", [Validators.required]],
      pmOpeningTime: ["", [Validators.required]],
      maxGuests: ["", [Validators.required]],
    });  
  }

  ngOnInit(): void{
    this.getAllRestaurants();
  }

  getAllRestaurants(){
    this.restaurantService.getAllRestaurants().subscribe((data) => {
      this.restaurantList = data;
    })
  };  

  getRestaurantById(id: number){
    this.restaurantService.getRestaurantById(id).subscribe((data) => {
      this.dataRestaurant = data;
    })
  }

  createRestaurant(){
    console.log(this.restaurantForm.value)
    const createdRestaurant = this.restaurantForm.value;
    this.restaurantService.createRestaurant(createdRestaurant).subscribe({
      next: () => {
        console.log('Restaurant creé');
        alert('Restaurant creé');
        this.closeModal();
      },
      error: () => {
        console.error('Erreur lors de la création de la réservacion');
      },
    });      
  }

  updateRestaurant(id: number){
    const updateRestaurant = this.restaurantForm.value;
    this.restaurantService.updateRestaurant(updateRestaurant, id).subscribe({
      next: () => {
        console.log('Restaurant mis à jour');
        alert('Restaurant mis à jour avec succès.');
        this.closeModal();
      },
      error: () => {
        console.error('Erreur lors de la mise à jour de la réservacion');
      },
    });     
  }

  deleteRestaurant(id: number){
    this.isDeleteInProgress = true;
    this.restaurantService.deleteRestaurant(id).subscribe({
      next: () => {
        console.log('Restaurant suprimée ');
        alert('Restaurant suprimée');
        this.getAllRestaurants();
      },
      error: () => {
        console.error('Erreur lors de supprimer la réservacion');
      },
    });  
  }

  updateModal(id: number){
    this.dataRestaurant = this.restaurantList.find(restaurant => restaurant.idRestaurant === id)
    this.edit = true;
    this.restaurantForm.patchValue(this.dataRestaurant);        
  }

  closeModal(){
    this.restaurantForm.reset();
    this.modal.nativeElement.click();
    this.getAllRestaurants();
  }
}

import { Component, EventEmitter, ElementRef, Input, Output, ViewChild } from '@angular/core';
import { ReservationService } from '../../services/reservation.service';
import { ActivatedRoute, Router } from '@angular/router';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { Reservation } from '../../models/reservation';

@Component({
  selector: 'app-list-reservations',
  imports: [ReactiveFormsModule],
  templateUrl: './list-reservations.component.html',
  styleUrl: './list-reservations.component.css'
})
export class ListReservationsComponent {
  @Input() reservationList: Reservation[] = []
  @Input() userEmail: any;
  dataReservation: any;
  @ViewChild("closebutton") modal!: ElementRef;
  @Output() isSaveInProgress = new EventEmitter<boolean>();
  reservationForm!: FormGroup;  
  edit: boolean = false;

  constructor(private fb: FormBuilder, private reservationService:ReservationService, private activatedRoute: ActivatedRoute, private router: Router) { }

  ngOnInit(): void {
    this.reservationForm = this.fb.group({
      idReservation: [null],
      guests: ["", [Validators.required]],
      date: ["", [Validators.required]],
      allergy: ["", [Validators.required]],
      userEmail: [this.userEmail, [Validators.required]],
    });  
  }

  createReservation(){
    const createdReservation = this.reservationForm.value;
    this.reservationService.createReservation(createdReservation).subscribe({
      next: () => {
        console.log('Reservation creé');
        this.router.navigateByUrl('/profile');
        this.closeModal();
      },
      error: () => {
        console.error('Erreur lors de la création de la réservacion');
      },
    });      
  }

  updateReservation(id: number){
    const updateReservation = this.reservationForm.value;
    this.reservationService.updateReservation(updateReservation, id).subscribe({
      next: () => {
        console.log('Reservation mis à jour');
        alert('Reservation mis à jour avec succès.');
        this.closeModal();
      },
      error: () => {
        console.error('Erreur lors de la mise à jour de la réservacion');
      },
    });     
  }

  deleteReservation(id: number){
    this.reservationService.deleteReservation(id).subscribe({
      next: () => {
        console.log('Reservation suprimée ');
        alert('Reservation suprimée');
        this.closeModal();
      },
      error: (err) => {
        console.log(err)
        console.error('Erreur lors de supprimer la réservacion '+err);
      },
    });  
  }

  updateModal(id: number){
    this.dataReservation = this.reservationList.find(reservation => reservation.idReservation === id)
    this.edit = true;
    this.reservationForm.patchValue(this.dataReservation);        
  }

  closeModal(){
    this.isSaveInProgress.emit(true);
    this.reservationForm.reset();
    this.modal.nativeElement.click();    
  }

}

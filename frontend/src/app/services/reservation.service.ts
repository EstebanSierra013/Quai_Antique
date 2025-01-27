import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Reservation } from '../models/reservation';

@Injectable({
  providedIn: 'root'
})
export class ReservationService {

  private apiUrl = "http://localhost:8080/reservations/"

  constructor(private http:HttpClient) { }

  getAllReservations(): Observable<Reservation[]>{
    return this.http.get<Reservation[]>(this.apiUrl);
  }

  getReservationById(id: number): Observable<Reservation>{
    return this.http.get<Reservation>(`${this.apiUrl}${id}`);
  }

  createReservation(reservation:Reservation): Observable<Reservation>{
    return this.http.post<Reservation>(this.apiUrl, reservation)
  }

  updateReservation(reservation:Reservation, id: number): Observable<Reservation>{
    return this.http.put<Reservation>(`${this.apiUrl}${id}`, reservation)
  }

  deleteReservation(id: number){
    return this.http.delete(`${this.apiUrl}${id}`,{ responseType: 'text' })
  }
}

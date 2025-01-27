import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Restaurant } from '../models/restaurant';

@Injectable({
  providedIn: 'root'
})
export class RestaurantService {

  private apiUrl = "http://localhost:8080/restaurants/"

  constructor(private http:HttpClient) { }

  getAllRestaurants(): Observable<Restaurant[]>{
    return this.http.get<Restaurant[]>(this.apiUrl);
  }

  getRestaurantById(id: number): Observable<Restaurant>{
    return this.http.get<Restaurant>(`${this.apiUrl}${id}`);
  }

  createRestaurant(restaurant:Restaurant): Observable<Restaurant>{
    return this.http.post<Restaurant>(this.apiUrl, restaurant)
  }

  updateRestaurant(restaurant:Restaurant, id: number): Observable<Restaurant>{
    return this.http.put<Restaurant>(`${this.apiUrl}${id}`, restaurant)
  }

  deleteRestaurant(id: number){
    return this.http.delete(`${this.apiUrl}${id}`,{ responseType: 'text' })
  }
}

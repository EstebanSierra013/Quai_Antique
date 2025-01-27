import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Dish } from '../models/dish';

@Injectable({
  providedIn: 'root'
})
export class DishService {
  
  private apiUrl = "http://localhost:8080/dishes/"

  constructor(private http:HttpClient) { }

  getAllDishes(): Observable<Dish[]>{
    return this.http.get<Dish[]>(this.apiUrl);
  }

  getDishById(id: number): Observable<Dish>{
    return this.http.get<Dish>(`${this.apiUrl}${id}`);
  }

  createDish(dish:Dish): Observable<Dish>{
    return this.http.post<Dish>(this.apiUrl, dish)
  }

  updateDish(dish:Dish, id: number): Observable<Dish>{
    return this.http.put<Dish>(`${this.apiUrl}${id}`, dish)
  }

  deleteDish(id: number){
    return this.http.delete(`${this.apiUrl}${id}`,{ responseType: 'text' })
  }

}

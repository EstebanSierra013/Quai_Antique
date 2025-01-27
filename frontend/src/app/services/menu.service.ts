import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Menu } from '../models/menu';

@Injectable({
  providedIn: 'root'
})
export class MenuService {

  private apiUrl = "http://localhost:8080/menus/"

  constructor(private http:HttpClient) { }

  getAllMenus(): Observable<Menu[]>{
    return this.http.get<Menu[]>(this.apiUrl);
  }

  getMenuById(id: number): Observable<Menu>{
    return this.http.get<Menu>(`${this.apiUrl}${id}`);
  }

  createMenu(menu:Menu): Observable<Menu>{
    return this.http.post<Menu>(this.apiUrl, menu)
  }

  updateMenu(menu:Menu, id: number): Observable<Menu>{
    return this.http.put<Menu>(`${this.apiUrl}${id}`, menu)
  }

  deleteMenu(id: number){
    return this.http.delete(`${this.apiUrl}${id}`,{ responseType: 'text' })
  }
}

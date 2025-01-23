import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { User } from '../models/user';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  private apiUrl = "http://localhost:8080/user"

  constructor(private http:HttpClient) { }

  getUsers(): Observable<User[]>{
    return this.http.get<User[]>(this.apiUrl);
  }

  getUserById(id: string): Observable<User>{
    return this.http.get<User>(`${this.apiUrl}/${id}`);
  }

  createUser(user:User): Observable<User>{
    return this.http.post<User>(this.apiUrl, user)
  }

  updateUser(user:User){
    return this.http.put(this.apiUrl, user)
  }

  deleteUser(id: string){
    return this.http.delete(`${this.apiUrl}/${id}`)
  }
}

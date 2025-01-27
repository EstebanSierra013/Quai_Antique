import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { User } from '../models/user';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  private apiUrl = "http://localhost:8080/users/"

  constructor(private http:HttpClient) { }

  getAllUsers(): Observable<User[]>{
    return this.http.get<User[]>(this.apiUrl);
  }

  getUserById(id: string): Observable<User>{
    return this.http.get<User>(`${this.apiUrl}${id}`);
  }

  createUser(user:User): Observable<User>{
    return this.http.post<User>(this.apiUrl, user)
  }

  updateUser(user:User, email: string): Observable<User>{
    return this.http.put<User>(`${this.apiUrl}${email}`, user)
  }

  deleteUser(id: string){
    return this.http.delete(`${this.apiUrl}${id}`,{ responseType: 'text' })
  }
}

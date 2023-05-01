import { Injectable } from '@angular/core';
import { User } from '../../../entidad/User';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Usuario } from '../../../entidad/Usuario';

@Injectable({
  providedIn: 'root'
})
export class AddUserService {
  url: string = "http://localhost:8080/HospitalApi/UserController?tarea=";

  constructor(private http: HttpClient) { }

  inserUser(usuario: Usuario) {
    return this.http.post<User>(`${this.url}ingresarNuevo`, usuario);
  }
  getAllUser(){
    return this.http.get<Usuario[]>(`${this.url}allUsers`);
  }
  getAllUserByUserName(username: String){
    return this.http.get<User>(`${this.url}userUsername&username=${username}`);
  }
  getUserNamePassword(user: Usuario): Observable<Usuario>{
    return this.http.post<Usuario>(this.url+"search", user);
  }
}

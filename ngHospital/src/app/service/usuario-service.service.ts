import { HttpClient } from '@angular/common/http'
import { Observable } from 'rxjs';
import { EventEmitter, Injectable, Output } from '@angular/core';
import { User } from 'src/entidad/User';


@Injectable({
  providedIn: 'root'
})
export class UsuarioServiceService {
  readonly API_URL = "http://localhost:8080/apiRestHospital/UserController?tarea=ingresarNuevo/";

  @Output()
  emisorDeCambios: EventEmitter<User> = new EventEmitter();

  usuairo!: User;

  constructor(private httpClient: HttpClient) { }

  public crearUsuario(user: User): Observable<User> {
    return this.httpClient.post<User>(this.API_URL, user);
  }
}

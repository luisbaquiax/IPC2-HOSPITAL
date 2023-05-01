import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'
import { Usuario } from '../../../entidad/Usuario';
import { EspecialidadesMedico } from '../../../entidad/EspecialidadesMedico';
import { Observable } from 'rxjs';
import { Especialidad } from '../../../entidad/Especialidad';

@Injectable({
  providedIn: 'root'
})
export class ServiceEspecialidadService {

  url: String = "http://localhost:8080/HospitalApi/servletControllerMedicoEspecialidad?tarea=";
  
  constructor(private http: HttpClient) { }

  public getEspecialidades(user: Usuario): Observable<EspecialidadesMedico[]> {
    return this.http.post<EspecialidadesMedico[]>(this.url + "especialidades", user);
  }
  

  public getEspecialidadesDisponibles(): Observable<Especialidad[]> {
    return this.http.get<Especialidad[]>(this.url + "especialidadesDisponibles");
  }
  public insertEspecialidad(especialidades: EspecialidadesMedico[], idmedico: Number): Observable<EspecialidadesMedico[]> {
    return this.http.post<EspecialidadesMedico[]>(this.url + "insert&idMedico="+idmedico, especialidades);
  }
}

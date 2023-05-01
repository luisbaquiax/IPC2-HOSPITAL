import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Usuario } from '../../../entidad/Usuario';
import { ExamenesLaboratorio } from '../../../entidad/ExamenesLaboratorio';
import { Observable } from 'rxjs';
import { TipoExamen } from '../../../entidad/TipoExamen';

@Injectable({
  providedIn: 'root'
})
export class ExamenesLaboratorioService {

  url: String = "http://localhost:8080/HospitalApi/ServletControllerExamenesLaboratorio?tarea=";

  constructor(private http: HttpClient) { }

  public getExamenesByLaboratory(user: Usuario): Observable<ExamenesLaboratorio[]> {
    return this.http.post<ExamenesLaboratorio[]>(this.url + "examenesLab", user);
  }

  public getExamenesDisponibles(): Observable<TipoExamen[]> {
    return this.http.get<TipoExamen[]>(this.url + "examenesDisponibles");
  }

  public insertExamenesLaboratory(especialidades: ExamenesLaboratorio[], idLaboratorio: Number): Observable<ExamenesLaboratorio[]> {
    return this.http.post<ExamenesLaboratorio[]>(this.url + "insert&idLaboratorio=" + idLaboratorio, especialidades);
  }

}

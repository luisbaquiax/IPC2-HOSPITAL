import { Component, OnInit } from '@angular/core';
import { ExamenesLaboratorio } from '../../../../entidad/ExamenesLaboratorio';
import { TipoExamen } from '../../../../entidad/TipoExamen';
import { ExamenesLaboratorioService } from '../../../service/examenesLaboratorio/examenes-laboratorio.service';
import { Usuario } from '../../../../entidad/Usuario';

@Component({
  selector: 'app-lab-add-info',
  templateUrl: './lab-add-info.component.html',
  styleUrls: ['./lab-add-info.component.css']
})
export class LabAddInfoComponent implements OnInit {

  misExamens: ExamenesLaboratorio[] = [];
  examenesDisponibles: TipoExamen[] = [];
  examenNuevo: ExamenesLaboratorio;
  user: Usuario;

  constructor(private serviceExamenes: ExamenesLaboratorioService) {
    this.examenNuevo = new ExamenesLaboratorio();
    this.user = new Usuario();
  }

  ngOnInit(): void {
    this.serviceExamenes.getExamenesDisponibles().subscribe((lista) => { this.examenesDisponibles = lista });
  }
  agregar() {
    let existe: Boolean = false;
    for (let i = 0; i < this.misExamens.length; i++) {
      if (this.misExamens[i].nombre == this.examenNuevo.nombre) {
        existe = true;
        break;
      }
    }
    if (existe == false) {
      if (this.examenNuevo.nombre.length > 0 && this.examenNuevo.precio > 0) {
        this.misExamens.push(this.examenNuevo)
        this.examenNuevo = new ExamenesLaboratorio();
      }
    }

  }
  quitar(examen: string) { }

  guardarCambios() {
    let stringUser = localStorage.getItem('userLogin');
    if (stringUser != null) {
      this.user = JSON.parse(stringUser);
      if (this.misExamens.length > 0) {
        this.serviceExamenes.insertExamenesLaboratory(this.misExamens, this.user.id).subscribe(
          (data) => {
            alert('Se ha guardado la información.');
          }, (error) => {
            console.log('No se pudo guardar la información');
          }
        );
      } else {
        alert('Debes agregar al menos un examen.');
      }
    }
  }
}

import { Component, OnInit } from '@angular/core';
import { Especialidad } from '../../../../entidad/Especialidad';
import { EspecialidadesMedico } from '../../../../entidad/EspecialidadesMedico';
import { ServiceEspecialidadService } from '../../../service/especialidad/service-especialidad.service';
import { Usuario } from '../../../../entidad/Usuario';
import { Router } from '@angular/router';

@Component({
  selector: 'app-add-informacion-medico',
  templateUrl: './add-informacion-medico.component.html',
  styleUrls: ['./add-informacion-medico.component.css']
})
export class AddInformacionMedicoComponent implements OnInit {

  user!: Usuario;
  stringUser!: String;
  diponibles: Especialidad[] = [];
  misEspecialidades: EspecialidadesMedico[] = [];
  nuevaEspecialidad: EspecialidadesMedico;
  constructor(private serviceEspecialidadService: ServiceEspecialidadService, private router: Router) {
    this.nuevaEspecialidad = new EspecialidadesMedico();
  }

  ngOnInit(): void {
    this.serviceEspecialidadService.getEspecialidadesDisponibles().subscribe(
      (lista: Especialidad[]) => {
        this.diponibles = lista;
      }
    );
  }
  agregar() {
    let existe: Boolean = false;
    for (let i = 0; i < this.misEspecialidades.length; i++) {
      if (this.misEspecialidades[i].especialidad == this.nuevaEspecialidad.especialidad) {
        existe = true;
        break;
      }
    }
    if (existe == false) {
      if (this.nuevaEspecialidad.especialidad.length > 0 && this.nuevaEspecialidad.precio > 0) {
        this.misEspecialidades.push(this.nuevaEspecialidad);
        this.nuevaEspecialidad = new EspecialidadesMedico();
      }
    }
  }

  quitar(name: String) {
    this.misEspecialidades.pop();
  }

  guardarCambios() {
    console.log('Guardando cambios en la base de datos.');
    console.log(this.misEspecialidades)
    let stringUser = localStorage.getItem('userLogin');
    if (stringUser != null) {
      this.user = JSON.parse(stringUser);
      if (this.misEspecialidades.length > 0) {
        this.serviceEspecialidadService.insertEspecialidad(this.misEspecialidades, this.user.id).subscribe(
          (data: EspecialidadesMedico[]) => {
            alert('Se guardado los cambios');
            this.router.navigate([('historialPorcentajes')]);
          }, error => {
            console.log('No se pudo guardar la informacón');
          }
        );
      }
    }
  }
}


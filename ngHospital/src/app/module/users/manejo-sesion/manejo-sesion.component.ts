import { Component, OnInit } from '@angular/core';
import { User } from '../../../../entidad/User';
import { Router } from '@angular/router';
import { Usuario } from '../../../../entidad/Usuario';
import { ServiceEspecialidadService } from '../../../service/especialidad/service-especialidad.service';
import { EspecialidadesMedico } from '../../../../entidad/EspecialidadesMedico';
import { ExamenesLaboratorio } from '../../../../entidad/ExamenesLaboratorio';
import { ExamenesLaboratorioService } from '../../../service/examenesLaboratorio/examenes-laboratorio.service';
import { TipoExamen } from '../../../../entidad/TipoExamen';

@Component({
  selector: 'app-manejo-sesion',
  templateUrl: './manejo-sesion.component.html'
})
export class ManejoSesionComponent implements OnInit {

  userLogin: Usuario;
  especialidads: EspecialidadesMedico[] = [];
  examensesLab: ExamenesLaboratorio[] =[];
  constructor(private router: Router, private serviceEspecialidadService: ServiceEspecialidadService,
    private serviceExamens: ExamenesLaboratorioService) {
    //this.userLogin = new User(0, '', '', '', '', '', 0, '', '', '', '');
    this.userLogin = new Usuario();
  }

  ngOnInit(): void {
    //this.router.navigate(['historialPorcentajes']);
    let stringUser = localStorage.getItem('userLogin');
    if (stringUser != null) {
      this.userLogin = JSON.parse(stringUser);
      console.log('userJSON' + stringUser);
      if (this.userLogin != null) {
        console.log('username: ' + this.userLogin.username)
        switch (this.userLogin.tipo) {
          case User.ADMIN:
            this.router.navigate(['historialPorcentajes']);
            break;
          case User.PACIENTE:
            this.router.navigate(['navPaciente']);
            break;
          case User.MEDICO:
            this.serviceEspecialidadService.getEspecialidades(this.userLogin).subscribe(
              (lista: EspecialidadesMedico[]) => {
                this.especialidads = lista;
                console.log('lista: ' + this.especialidads);
                if (this.especialidads.length === 0) {
                  this.router.navigate(['medicoAddInfo']);
                } else {
                  this.router.navigate(['navMedico']);
                }
              }
            );
            break;
          case User.LABORATORIO:
            this.serviceExamens.getExamenesByLaboratory(this.userLogin).subscribe(
              (list: ExamenesLaboratorio[])=>{
                this.examensesLab = list;
              },(error)=>{
                console.log('No se pudeo realizar la consulta.');
              }
            );
            if(this.examensesLab.length===0){
              this.router.navigate(['labAddInfo']);
            }else{
            this.router.navigate(['navLab']);
            }
            break;
        }
      } else {
        this.router.navigate(['login']);
      }
    } else {
      this.router.navigate(['login']);
    }
  }

}

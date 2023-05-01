import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { InicioSesionComponent } from './module/users/inicio-sesion/inicio-sesion.component';
import { NavAdmin } from './module/admin/nav/nav.component';
import { CreateCountComponent } from './module/users/create-count/create-count.component';
import { AddInformacionMedicoComponent } from './module/medico/add-informacion-medico/add-informacion-medico.component';
import { HistorialPorcentajesComponent } from './module/admin/historial-porcentajes/historial-porcentajes.component';
import { NavPacienteComponent } from './module/paciente/nav-paciente/nav-paciente.component';
import { NavLaboratorioComponent } from './module/laboratorio/nav-laboratorio/nav-laboratorio.component';
import { NavMedicoComponent } from './module/medico/nav-medico/nav-medico.component';
import { ManejoSesionComponent } from './module/users/manejo-sesion/manejo-sesion.component';
import { LabAddInfoComponent } from './module/laboratorio/lab-add-info/lab-add-info.component';

const routes: Routes = [
  { path: '', redirectTo: '/login', pathMatch: 'full' },
  {
    path: "login", component: InicioSesionComponent
  },
  {
    path: "nav-admin", component: NavAdmin
  },
  {
    path: "create-count", component: CreateCountComponent
  },
  {
    path: "medicoAddInfo", component: AddInformacionMedicoComponent
  },
  {
    path: "historialPorcentajes", component: HistorialPorcentajesComponent
  },
  {
    path: "navPaciente", component: NavPacienteComponent
  },
  {
    path: "navLab", component: NavLaboratorioComponent
  },
  {
    path: "navMedico", component: NavMedicoComponent
  },
  {
    path: "manejoSesion", component: ManejoSesionComponent
  },
  {
    path: "labAddInfo", component: LabAddInfoComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

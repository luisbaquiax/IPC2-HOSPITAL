import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { InicioSesionComponent } from './module/users/inicio-sesion/inicio-sesion.component';
import { ConsultasComponent } from './module/paciente/consultas/consultas.component';
import { MenuMedicoComponent } from './module/medico/menu-medico/menu-medico.component';
import { AddInformacionMedicoComponent } from './module/medico/add-informacion-medico/add-informacion-medico.component';
import { CreateCountComponent } from './module/users/create-count/create-count.component';
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { NavPacienteComponent } from './module/paciente/nav-paciente/nav-paciente.component';
import { NavLaboratorioComponent } from './module/laboratorio/nav-laboratorio/nav-laboratorio.component';
import { HistorialPorcentajesComponent } from './module/admin/historial-porcentajes/historial-porcentajes.component';
import { MainPageComponent } from './module/admin/main-page/main-page.component';
import { NavAdmin } from './module/admin/nav/nav.component';
import { FileComponent } from './module/file/file.component';
import { NavMedicoComponent } from './module/medico/nav-medico/nav-medico.component';
import { ManejoSesionComponent } from './module/users/manejo-sesion/manejo-sesion.component';
import { LabAddInfoComponent } from './module/laboratorio/lab-add-info/lab-add-info.component';

@NgModule({
  declarations: [
    AppComponent,
    InicioSesionComponent,
    ConsultasComponent,
    MenuMedicoComponent,
    AddInformacionMedicoComponent,
    CreateCountComponent,
    NavPacienteComponent,
    NavLaboratorioComponent,
    HistorialPorcentajesComponent,
    MainPageComponent,
    NavAdmin,
    FileComponent,
    NavMedicoComponent,
    ManejoSesionComponent,
    LabAddInfoComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    NgbModule,
    ReactiveFormsModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

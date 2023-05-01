import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AddUserService } from 'src/app/service/user/add-user.service';
import { Usuario } from '../../../../entidad/Usuario';
import { User } from '../../../../entidad/User';

@Component({
  selector: 'app-inicio-sesion',
  templateUrl: './inicio-sesion.component.html',
  styleUrls: ['./inicio-sesion.component.css']
})
export class InicioSesionComponent implements OnInit {

  user!: Usuario;
  msgLogin!: String;
  constructor(private router: Router, private serviceUser: AddUserService) {
    //this.user = new User(0, '', '', '', '', '', 0, '', '', '', '');
    this.user = new Usuario();
    this.msgLogin = '';
  }

  ngOnInit(): void {
  }
  crearCuenta() {
    this.router.navigate(['create-count']);
  }

  iniciarSesion() {
    console.log(this.user);
    this.serviceUser.getUserNamePassword(this.user).subscribe(
      (user) =>{
        this.user = user;
        console.log('usuario buscado: '+user);
        if(this.user){
          localStorage.setItem('userLogin', JSON.stringify(this.user));
          this.router.navigate(['manejoSesion']);
        }else{
          this.msgLogin = 'Credenciales incorrectas.';          
        }
      }, error=>{
        console.log(error);
        this.msgLogin = 'No pudimos iniciar sesión.';
      }
    );
  }

}

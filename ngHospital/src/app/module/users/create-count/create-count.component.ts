import { Component, OnInit } from '@angular/core';
import { User } from '../../../../entidad/User';
import { Router } from '@angular/router';
import { AddUserService } from '../../../service/user/add-user.service';
import { Usuario } from '../../../../entidad/Usuario';

@Component({
  selector: 'app-create-count',
  templateUrl: './create-count.component.html',
  styleUrls: ['./create-count.component.css']
})
export class CreateCountComponent implements OnInit {

  usuario!: Usuario;
  userTemp !: Usuario;
  users: Usuario[];
  medico!: String;
  paciente!: String;
  lab!: String;
  msgCreatCount!: String;

  url: String = '/login';

  constructor(private router: Router, private userService: AddUserService) {
    this.users = new Array();
    this.medico = User.MEDICO;
    this.lab = User.LABORATORIO;
    this.paciente = User.PACIENTE;
    this.userService.getAllUser().subscribe((lista: Usuario[]) => this.users = lista);
    this.msgCreatCount = '';
    this.usuario = new Usuario();
  }

  ngOnInit(): void {
  }

  onSubmit() {
    console.log(this.usuario);
    console.log(this.userService.getAllUser().subscribe((lista: Usuario[]) => this.users = lista));
    this.userService.getAllUserByUserName(this.usuario.username).subscribe(user => {
      if (!user) {
        this.userService.inserUser(this.usuario)
          .subscribe(data => {
            alert('Cuenta creada exitosamente.');
          });
        this.router.navigate(['login']);
      } else {
        this.msgCreatCount = 'El nombre de usuario no está disponible.';
      }
    }, error => console.log('Error: ' + error));
  }

}

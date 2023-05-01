import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-nav-paciente',
  templateUrl: './nav-paciente.component.html',
  styleUrls: ['./nav-paciente.component.css']
})
export class NavPacienteComponent implements OnInit {

  constructor(private router: Router) { }

  ngOnInit(): void {
  }
  exit(){
    localStorage.removeItem('userLogin');
    this.router.navigate(['login']);
  }
}

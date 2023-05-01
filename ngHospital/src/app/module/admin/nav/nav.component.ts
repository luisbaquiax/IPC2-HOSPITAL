import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-nav-admin',
  templateUrl: './nav.component.html',
  styleUrls: ['./nav.component.css']
})
export class NavAdmin implements OnInit {

  public links: string[];
  constructor() { 
    this.links =["/","/historial-porcentajes","/top-laboratorio", "top-medico"];

  }

  ngOnInit(): void {
  }

}

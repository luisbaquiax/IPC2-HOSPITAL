import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-file',
  templateUrl: './file.component.html',
  styleUrls: ['./file.component.css']
})
export class FileComponent implements OnInit {

  jsonFile: File | undefined;
  url: string = "http://localhost:8080/HospitalApi/servletControllerData";
  menssage: String = '';


  constructor(private http: HttpClient) {

  }
  ngOnInit(): void {
  }
  chooseFile(event: any) {
    this.jsonFile = event.target.files[0];
  }
  sendFile() {
    console.log('hola sendfile');
    if (!this.jsonFile) {
      return;
    }

    const form = new FormData();

    form.append("archivo", this.jsonFile);
    this.http.post(this.url, form).subscribe(
      response => {
        this.menssage = 'Se ha procesado correctamente el archivo.';
        console.log('Se ha enviado el archivo. ', response);
      }
    );

  }

  subirDatos() {
    this.http.get(this.url).subscribe(
      response => {
        console.log('Se ha subido la información.');
      },
      (error) => {
        this.menssage = 'No se ha podido subir la información / Se debe procesar el archivo primero';
        console.log(error)
      }
    );
  }

}
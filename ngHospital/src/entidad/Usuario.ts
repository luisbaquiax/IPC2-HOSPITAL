export class Usuario {

    public static  ADMIN:String = 'ADMIN';
    public static  MEDICO:String = "MEDICO";
    public static  LABORATORIO:String = 'LABORATORIO';
    public static  PACIENTE:String = 'PACIENTE';
     id!: Number;
     nombre!: string;
     username!: string;
     password!: string;
     email!: string;
     fechaNacimiento!: string;
     saldo!: Number;
     tipo!: string;
     direccion!: string;
     telefono!: string;
     cui!: string;
}

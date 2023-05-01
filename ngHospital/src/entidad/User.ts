export class User {

    public static  ADMIN:String = 'ADMIN';
    public static  MEDICO:String = "MEDICO";
    public static  LABORATORIO:String = 'LABORATORIO';
    public static  PACIENTE:String = 'PACIENTE';
    private id: Number;
    private nombre: string;
    private username: string;
    private password: string;
    private email: string;
    private fechaNacimiento: string;
    private saldo: Number;
    private tipo: string;
    private direccion: string;
    private telefono: string;
    private cui: string;


	constructor($id: Number, $nombre: string, $username: string, $password: string, $email: string, $fechaNacimiento: string, 
        $saldo: Number, $tipo: string, $direccion: string, $telefono: string, $cui: string) {
		this.id = $id;
		this.nombre = $nombre;
		this.username = $username;
		this.password = $password;
		this.email = $email;
		this.fechaNacimiento = $fechaNacimiento;
		this.saldo = $saldo;
		this.tipo = $tipo;
		this.direccion = $direccion;
		this.telefono = $telefono;
		this.cui = $cui;
	}

    /**
     * Getter $id
     * @return {Number}
     */
	public get $id(): Number {
		return this.id;
	}

    /**
     * Getter $nombre
     * @return {string}
     */
	public get $nombre(): string {
		return this.nombre;
	}

    /**
     * Getter $username
     * @return {string}
     */
	public get $username(): string {
		return this.username;
	}

    /**
     * Getter $password
     * @return {string}
     */
	public get $password(): string {
		return this.password;
	}

    /**
     * Getter $email
     * @return {string}
     */
	public get $email(): string {
		return this.email;
	}

    /**
     * Getter $fechaNacimiento
     * @return {string}
     */
	public get $fechaNacimiento(): string {
		return this.fechaNacimiento;
	}

    /**
     * Getter $saldo
     * @return {Number}
     */
	public get $saldo(): Number {
		return this.saldo;
	}

    /**
     * Getter $tipo
     * @return {string}
     */
	public get $tipo(): string {
		return this.tipo;
	}

    /**
     * Getter $direccion
     * @return {string}
     */
	public get $direccion(): string {
		return this.direccion;
	}

    /**
     * Getter $telefono
     * @return {string}
     */
	public get $telefono(): string {
		return this.telefono;
	}

    /**
     * Getter $cui
     * @return {string}
     */
	public get $cui(): string {
		return this.cui;
	}

    /**
     * Setter $id
     * @param {Number} value
     */
	public set $id(value: Number) {
		this.id = value;
	}

    /**
     * Setter $nombre
     * @param {string} value
     */
	public set $nombre(value: string) {
		this.nombre = value;
	}

    /**
     * Setter $username
     * @param {string} value
     */
	public set $username(value: string) {
		this.username = value;
	}

    /**
     * Setter $password
     * @param {string} value
     */
	public set $password(value: string) {
		this.password = value;
	}

    /**
     * Setter $email
     * @param {string} value
     */
	public set $email(value: string) {
		this.email = value;
	}

    /**
     * Setter $fechaNacimiento
     * @param {string} value
     */
	public set $fechaNacimiento(value: string) {
		this.fechaNacimiento = value;
	}

    /**
     * Setter $saldo
     * @param {Number} value
     */
	public set $saldo(value: Number) {
		this.saldo = value;
	}

    /**
     * Setter $tipo
     * @param {string} value
     */
	public set $tipo(value: string) {
		this.tipo = value;
	}

    /**
     * Setter $direccion
     * @param {string} value
     */
	public set $direccion(value: string) {
		this.direccion = value;
	}

    /**
     * Setter $telefono
     * @param {string} value
     */
	public set $telefono(value: string) {
		this.telefono = value;
	}

    /**
     * Setter $cui
     * @param {string} value
     */
	public set $cui(value: string) {
		this.cui = value;
	}   
}

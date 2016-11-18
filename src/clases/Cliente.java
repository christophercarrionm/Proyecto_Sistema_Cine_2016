package clases;

public class Cliente {
	int cod_cliente, estado_civil;
	String nombres, ape_paterno, ape_materno, direccion, fec_nac, fec_afiliacion, telef, dni, login, password;
	
	public Cliente(int cod_cliente, int estado_civil, String nombres, String ape_paterno, String ape_materno,String direccion, String fec_nac, String fec_afiliacion, String telef, String dni, String login, String password) {
		this.cod_cliente = cod_cliente;
		this.estado_civil = estado_civil;
		this.nombres = nombres;
		this.ape_paterno = ape_paterno;
		this.ape_materno = ape_materno;
		this.direccion = direccion;
		this.fec_nac = fec_nac;
		this.fec_afiliacion = fec_afiliacion;
		this.telef = telef;
		this.dni = dni;
		this.login = login;
		this.password = password;
	}

	public int getCod_cliente() {
		return cod_cliente;
	}

	public void setCod_cliente(int cod_cliente) {
		this.cod_cliente = cod_cliente;
	}

	public int getEstado_civil() {
		return estado_civil;
	}

	public void setEstado_civil(int estado_civil) {
		this.estado_civil = estado_civil;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApe_paterno() {
		return ape_paterno;
	}

	public void setApe_paterno(String ape_paterno) {
		this.ape_paterno = ape_paterno;
	}

	public String getApe_materno() {
		return ape_materno;
	}

	public void setApe_materno(String ape_materno) {
		this.ape_materno = ape_materno;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getFec_nac() {
		return fec_nac;
	}

	public void setFec_nac(String fec_nac) {
		this.fec_nac = fec_nac;
	}

	public String getFec_afiliacion() {
		return fec_afiliacion;
	}

	public void setFec_afiliacion(String fec_afiliacion) {
		this.fec_afiliacion = fec_afiliacion;
	}

	public String getTelef() {
		return telef;
	}

	public void setTelef(String telef) {
		this.telef = telef;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
}

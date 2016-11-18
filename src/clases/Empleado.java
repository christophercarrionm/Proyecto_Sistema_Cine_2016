package clases;
import maestros.*;

public class Empleado extends General{
	
	int t_empleado;
	String usuario, contraseña;
	
	public Empleado( int codigo, String documento, String nombres, String a_paterno, String a_materno, int t_empleado, String usuario, String contraseña) {
		super(codigo, documento, nombres, a_paterno, a_materno);
		this.t_empleado = t_empleado;
		this.usuario = usuario;
		this.contraseña = contraseña;
	}

	
	public int getT_empleado() {
		return t_empleado;
	}

	public void setT_empleado(int t_empleado) {
		this.t_empleado = t_empleado;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}
	
	
}

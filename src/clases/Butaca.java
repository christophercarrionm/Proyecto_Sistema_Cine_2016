package clases;

public class Butaca {
	
	//Atributos de la clase
	private int codigo;
	private int codigo_sala;
	private int numero_fila ;
	private int numero_columna;
	
	// 0 = reservada , 1 = disponible
	private int estado;
	
	//Constructor de la clase con parametros
	public Butaca(int codigo, int codigo_sala, int numero_fila, int numero_columna, int estado) {
		this.codigo = codigo;
		this.codigo_sala = codigo_sala;
		this.numero_fila = numero_fila;
		this.numero_columna = numero_columna;
		this.estado = estado;
	}

	
	//metodos set y get
	public int getCodigo() {
		return codigo;
	}

	
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public int getCodigo_sala() {
		return codigo_sala;
	}

	public void setCodigo_sala(int codigo_sala) {
		this.codigo_sala = codigo_sala;
	}

	public int getNumero_fila() {
		return numero_fila;
	}

	public void setNumero_fila(int numero_fila) {
		this.numero_fila = numero_fila;
	}

	public int getNumero_columna() {
		return numero_columna;
	}

	public void setNumero_columna(int numero_columna) {
		this.numero_columna = numero_columna;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	} 
	
	

}

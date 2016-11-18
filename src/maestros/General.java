package maestros;

public class General {

	protected int codigo;
	protected String documento, nombres, a_paterno, a_materno;
	
	public General(int codigo, String documento, String nombres, String a_paterno, String a_materno) {
		this.codigo = codigo;
		this.documento = documento;
		this.nombres = nombres;
		this.a_paterno = a_paterno;
		this.a_materno = a_materno;
	}

	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getDocumento() {
		return documento;
	}
	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getA_paterno() {
		return a_paterno;
	}
	public void setA_paterno(String a_paterno) {
		this.a_paterno = a_paterno;
	}

	public String getA_materno() {
		return a_materno;
	}
	public void setA_materno(String a_materno) {
		this.a_materno = a_materno;
	} 


}

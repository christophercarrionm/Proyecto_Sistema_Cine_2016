package clases;

public class Cine {
	
	private int codigo;
	private String nombre;
	private String departamento;
	private String provincia;
	private String distrito;
	private String fec_afi;
	private int tipo_cine;
	
	
	public Cine(int codigo, String nombre, String departamento, String provincia, String distrito, String fec_afi,
			int tipo_cine) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.departamento = departamento;
		this.provincia = provincia;
		this.distrito = distrito;
		this.fec_afi = fec_afi;
		this.tipo_cine = tipo_cine;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDepartamento() {
		return departamento;
	}
	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}
	public String getProvincia() {
		return provincia;
	}
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
	public String getDistrito() {
		return distrito;
	}
	public void setDistrito(String distrito) {
		this.distrito = distrito;
	}
	public String getFec_afi() {
		return fec_afi;
	}
	public void setFec_afi(String fec_afi) {
		this.fec_afi = fec_afi;
	}
	public int getTipo_cine() {
		return tipo_cine;
	}
	public void setTipo_cine(int tipo_cine) {
		this.tipo_cine = tipo_cine;
	}
	
	

}

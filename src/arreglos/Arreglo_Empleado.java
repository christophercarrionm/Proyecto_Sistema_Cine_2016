package arreglos;

import clases.Empleado;
import java.io.*;
import java.util.ArrayList;

public class Arreglo_Empleado {
	/************************************************/
	//Atributos Privados
	private ArrayList <Empleado> emp;
	private String archivo;	
	//Constructor
	public Arreglo_Empleado(String txt) {
		emp = new ArrayList <Empleado> ();
    	archivo = txt;
		cargarEmpleados();		
	}
	
	/************************************************/
	//Operaciones públicas básicas
	public int tamaño(){
		return emp.size();
	}
	public Empleado obtener(int z){
		return emp.get(z);
	}
	public void agregar(Empleado z){
		emp.add(z);
	}
	public void eliminar(Empleado z){
		emp.remove(z);		
	}
	
	/************************************************/
	//Operaciones publicas complementarias
	public Empleado buscar(int z){
		Empleado x;
		for (int i=0; i<tamaño(); i++){
			x = obtener(i);
			if (x.getCodigo() == z){
				return x;
			}
		}
		return null;		
	}
	
	public int codCorrelativo() {
		if (tamaño() == 0)
			return 10001;
		else
			return obtener(tamaño()-1).getCodigo() + 1;		
	}
	
	public void grabarEmpleados() {
		try {
			PrintWriter pw;
			String linea;
			Empleado x;
			pw = new PrintWriter(new FileWriter(archivo));
			for (int i=0; i<tamaño(); i++) {
				x = obtener(i);
					linea = 
						x.getCodigo() + "#" + 
						x.getDocumento() + "#" +
						x.getNombres() + "#" +
						x.getA_paterno() + "#" +
						x.getA_materno() + "#" +
						x.getT_empleado() + "#" +
						x.getUsuario() + "#" +
						x.getContraseña();
				pw.println(linea);
			}
			pw.close();
		}
		catch (Exception e) {
		}
	}
		
	public void cargarEmpleados() {
		File f;
		FileReader lectorArchivo;
		try {
			String s[], linea, documento, nombres, a_paterno, a_materno, usuario, contraseña;
			int codigo, t_empleado;
			f = new File(archivo);
			lectorArchivo = new FileReader(f);
			BufferedReader br = new BufferedReader(lectorArchivo); 
			while ((linea = br.readLine()) != null) {
				s = linea.split("#");
				codigo = Integer.parseInt(s[0].trim());
				documento = s[1].trim();
				nombres = s[2].trim();
				a_paterno = s[3].trim();
				a_materno  = s[4].trim();
				t_empleado = Integer.parseInt(s[5].trim());
				usuario = s[6].trim();
				contraseña  = s[7].trim();
				agregar(new Empleado(codigo, documento, nombres, a_paterno, a_materno, t_empleado, usuario, contraseña));
			}
			br.close();
		}
		catch (Exception e) {
			
		}
	}		

}

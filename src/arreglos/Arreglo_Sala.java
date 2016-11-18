package arreglos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

import clases.Cine;
import clases.Sala;

public class Arreglo_Sala {

	private ArrayList <Sala> sala;
	private String archivo;	
	//Constructor
	public Arreglo_Sala(String txt) {
		sala = new ArrayList <Sala> ();
    	archivo = txt;
		cargarSala();		
	}
	public ArrayList<Sala> getSala() {
		return sala;
	}

	public void setSala(ArrayList<Sala> sala) {
		this.sala = sala;
	}
	
	public void agregar(Sala z){
		sala.add(z);
	}
	public int tamaño(){
		return sala.size();
	}
	public Sala obtener(int z){
		return sala.get(z);
	}
	public void eliminar(Sala z){
		sala.remove(z);		
	}
	
	public Sala buscar(int z){
		Sala x;
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
	
	public void grabarSala() {
		try {
			PrintWriter pw;
			String linea;
			Sala x;
			pw = new PrintWriter(new FileWriter(archivo));
			for (int i=0; i<tamaño(); i++) {
				x = obtener(i);
					linea = x.getCodigo() + ";" + x.getCodigo_cine() + ";" + 
					x.getNumero_sala() + ";" + x.getNumero_filas() + ";" +	x.getNumero_butacas();
					linea = 
							x.getCodigo() + ";" + 
							x.getCodigo_cine() + ";" + 
							x.getNumero_sala() + ";" +
							x.getNumero_filas() + ";" +
							x.getNumero_butacas();
				pw.println(linea);
			}
			pw.close();
		}
		catch (Exception e) {
		}
	}
	void cargarSala(){
		File f;
		FileReader lectorArchivo;
		try {
			//BufferedReader br;
			String s[], linea;
			int codigo, codigo_cine,numero_sala,numero_filas,numero_butacas;
			f = new File(archivo);
			lectorArchivo = new FileReader(f);
			BufferedReader br = new BufferedReader(lectorArchivo); 
			//br = new BufferedReader(new FileReader(f));
			while ((linea = br.readLine()) != null) {
				s = linea.split(";");
				codigo = Integer.parseInt(s[0].trim());
				codigo_cine = Integer.parseInt(s[1].trim());
				numero_sala = Integer.parseInt(s[2].trim());
				numero_filas = Integer.parseInt(s[3].trim());
				numero_butacas  = Integer.parseInt(s[4].trim());
				agregar(new Sala(codigo, codigo_cine, numero_sala, numero_filas, numero_butacas));
			}
			br.close();
		}
		catch (Exception e) {
			
		}
		
	}
}

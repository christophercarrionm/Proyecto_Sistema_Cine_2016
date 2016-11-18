package arreglos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

import clases.*;

public class Arreglo_Butaca {

	//Atributos de la clase
	private ArrayList <Butaca> butaca;
	private String archivo;
	
	
	public Arreglo_Butaca(String txt){
		butaca = new ArrayList <Butaca> ();
    	archivo = txt;
		cargarButaca();
	}
	public ArrayList<Butaca> getbutaca() {
		return butaca;
	}

	public void setbutaca(ArrayList<Butaca> butaca) {
		this.butaca = butaca;
	}
	
	public void agregar(Butaca z){
		butaca.add(z);
	}
	public int tamaño(){
		return butaca.size();
	}
	public Butaca obtener(int z){
		return butaca.get(z);
	}
	public void eliminar(Butaca z){
		butaca.remove(z);		
	}
	
	public Butaca buscar(int z){
		Butaca x;
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
	
	public void grabarButaca() {
		try {
			PrintWriter pw;
			String linea;
			Butaca x;
			pw = new PrintWriter(new FileWriter(archivo));
			for (int i=0; i<tamaño(); i++) {
				x = obtener(i);
					linea = x.getCodigo() + ";" + x.getCodigo_sala() + ";" + 
					x.getNumero_fila() + ";" + x.getNumero_columna() + ";" +	x.getEstado(); 
				pw.println(linea);
			}
			pw.close();
		}
		catch (Exception e) {
		}
	}
	
	public void cargarButaca() {
		File f;
		FileReader lectorArchivo;
		try {
			//BufferedReader br;
			String s[], linea;
			int codigo,codigo_sala,numero_fila,numero_columna,estado;
			f = new File(archivo);
			lectorArchivo = new FileReader(f);
			BufferedReader br = new BufferedReader(lectorArchivo); 
			//br = new BufferedReader(new FileReader(f));
			while ((linea = br.readLine()) != null) {
				s = linea.split(";");
				codigo = Integer.parseInt(s[0].trim());
				codigo_sala = Integer.parseInt(s[1].trim());
				numero_fila = Integer.parseInt(s[2].trim());
				numero_columna = Integer.parseInt(s[3].trim());
			    estado  = Integer.parseInt(s[4].trim());
				agregar(new Butaca(codigo, codigo_sala, numero_fila, numero_columna, estado));
			}
			br.close();
		}
		catch (Exception e) {
			
		}
	}		
}

package clases;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.Date;

import com.toedter.calendar.JDateChooser;

public class Operaciones {

	private static BufferedWriter bw;

	public String obtenerFecha(JDateChooser fecha) {
		int año, mes, dia;
		año = fecha.getCalendar().get(Calendar.YEAR);
		mes = fecha.getCalendar().get(Calendar.MONTH) + 1;
		dia = fecha.getCalendar().get(Calendar.DAY_OF_MONTH);
		String date = dia + "/" + mes + "/" + año;
		return date;
	}

	public static void main(String[] args) {

		Cine c = new Cine(10008, "Cinepolis", "Lima", "Lima", "Lima", "25/11/2016", 0);
		//crear_Archivo("prueba.txt",c);
		// leer_Archivo("prueba.txt");
		escribir_Fichero("prueba.txt", c);
		System.out.println(leer_Archivo("prueba.txt"));

	}

	public static void crear_Archivo(String nombre_Archivo) {

		try {

			bw = new BufferedWriter(new FileWriter(nombre_Archivo));
			/*String nombre, departamento, provincia, distrito, fec_afi;
			int codigo, tipo_cine;
			codigo = c.getCodigo();
			tipo_cine = c.getTipo_cine();
			departamento = c.getDepartamento();
			provincia = c.getProvincia();
			distrito = c.getDistrito();
			fec_afi = c.getFec_afi();
			nombre = c.getNombre();*/
			//String x[] = { "" + codigo + "#", nombre + "#", departamento + "#", provincia + "#", distrito + "#",
				//	fec_afi, "#" + tipo_cine + "@" };
			/*for (int i = 0; i <= 7; i++) {
				try{
					String x1 = x[i];
					bw.append(x1);
					bw.flush();
				}catch(IOException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}*/
			

		}catch(IOException e)
	{
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}

	public BufferedWriter getBw() {
		return bw;
	}

	public static boolean exist(String fichero){
		File archivo = new File(fichero);
		if(archivo.exists()){
			return true;
		}
		return false;
	}
	public static String leer_Archivo(String nombre_Archivo) {
		File archivo = null;
		FileReader fr = null;
		BufferedReader br = null;
		String texto = "";
		int cont = 0;
		try {
			// Apertura del fichero y creacion de BufferedReader para poder
			// hacer una lectura comoda (disponer del metodo readLine())
			archivo = new File(nombre_Archivo);
			fr = new FileReader(archivo);
			br = new BufferedReader(fr);

			// Lectura del fichero
			String linea;
			while ((linea = br.readLine()) != null) {
				//Object c[] = linea.split("#");
				texto +=linea;
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// En el finally cerramos el fichero, para asegurarnos
			// que se cierra tanto si todo va bien como si salta
			// una excepcion.
			try {
				if (null != fr) {
					fr.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return texto;

	}

	public void setBw(BufferedWriter bw) {
		this.bw = bw;
	}

	public static void escribir_Fichero(String nombre_Archivo, Cine c) {
		FileWriter fichero = null;
		PrintWriter pw = null;
		String texto="";
		try {
			if(exist(nombre_Archivo)){
				texto = leer_Archivo(nombre_Archivo);
			}
			fichero = new FileWriter(nombre_Archivo);
			pw = new PrintWriter(fichero);
			texto+=c.getCodigo()+"#"+c.getNombre()+"#"+c.getDepartamento()+"#"+c.getProvincia()+"#"+c.getDistrito()+"#"+c.getFec_afi()+"#"+c.getTipo_cine()+"$";
			for (int i = 0; i < 10; i++)
				pw.println(texto);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				// Nuevamente aprovechamos el finally para
				// asegurarnos que se cierra el fichero.
				if (null != fichero)
					fichero.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

}

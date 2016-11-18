package arreglos;

import java.util.ArrayList;

import clases.Cine;
import clases.Cliente;

public class Arreglo_Cine {
	
	private ArrayList <Cine> cine;
	private Object[] cine_cod;
	
	
	public Arreglo_Cine() {
		cine = new ArrayList<Cine>();
	}

	public ArrayList<Cine> getcine() {
		return cine;
	}

	public void setcine(ArrayList<Cine> cine) {
		this.cine = cine;
	}
	
	public void agregar(Cine z){
		cine.add(z);
	}
	public int tamaño(){
		return cine.size();
	}
	public Cine obtener(int z){
		return cine.get(z);
	}
	public void eliminar(Cine z){
		cine.remove(z);		
	}
	
	public Cine buscar(int z){
		Cine x;
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
	

}

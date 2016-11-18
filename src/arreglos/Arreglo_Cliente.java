package arreglos;

import clases.Cliente;
import java.util.ArrayList;


public class Arreglo_Cliente {
	
	private ArrayList <Cliente> emp;
	
	public Arreglo_Cliente() {
		emp = new ArrayList <Cliente> ();
	}
	
	public void agregar(Cliente z){
		emp.add(z);
	}
	public int tama�o(){
		return emp.size();
	}
	public Cliente obtener(int z){
		return emp.get(z);
	}
	public void eliminar(Cliente z){
		emp.remove(z);		
	}
	public Cliente buscar(int z){
		Cliente x;
		for (int i=0; i<tama�o(); i++){
			x = obtener(i);
			if (x.getCod_cliente() == z){
				return x;
			}
		}
		return null;		
	}
	
	public int codCorrelativo() {
		if (tama�o() == 0)
			return 10001;
		else
			return obtener(tama�o()-1).getCod_cliente() + 1;		
	}
	
}

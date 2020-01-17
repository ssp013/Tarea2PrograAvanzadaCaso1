/**
 * 
 */
package Logica;
import Dominio.*;
/**
 * @author sebastiansanchez
 *
 */
public class ListaEstudiantes {
	private NodoEstudiante first;
	private NodoEstudiante last;
	public ListaEstudiantes() {
		this.first = null;
		this.last = null;
	}
	public boolean isEmpty() {
		return first == null;
	}
	public void insertarPrimer(Estudiante estudiante) {
		NodoEstudiante nuevoEstudiante = new NodoEstudiante(estudiante);
		if(isEmpty()) {
			last=nuevoEstudiante;
		}else {
			first.setPrevio(nuevoEstudiante);
		}
		nuevoEstudiante.setNext(first);
		first = nuevoEstudiante;
	}
	public void insertarUltimo(Estudiante estudiante) {
		NodoEstudiante nuevoEstudiante = new NodoEstudiante(estudiante);
		if(isEmpty()) {
			first = nuevoEstudiante;
		}else {
			last.setNext(nuevoEstudiante);
			nuevoEstudiante.setPrevio(last);
		}
		last = nuevoEstudiante;
	}
	public boolean eliminarPrimer() {
		if(!this.isEmpty()) {
			if(first.getNext()==null) {
				last=null;
			}else {
				first.getNext().setPrevio(null);
			}
			first=first.getNext();
			return true;
		}else {
			return false;
		}
	}
	public boolean eliminarUltimo() {
		if(!this.isEmpty()) {
			if(first.getNext()==null) {
				first=null;
			}else {
				last.getPrevio().setNext(null);
			}
			last=last.getPrevio();
			return true;
		}else {
			return false;
		}
	}
	public boolean insertarDespues(String Rut,Estudiante estudiante) {
		NodoEstudiante current = first;
		while(current!=null && current.getEstudiante().getRut() !=Rut) {
			current = current.getNext();
		}
		if(current!=null) {
			NodoEstudiante nuevoEstudiante = new NodoEstudiante(estudiante);
			if(current == last) {
				nuevoEstudiante.setNext(null);
				last = nuevoEstudiante;
			}else {
				nuevoEstudiante.setNext(current.getNext());
				current.getNext().setPrevio(nuevoEstudiante);	
			}
			nuevoEstudiante.setPrevio(current);
			current.setNext(nuevoEstudiante);
			return true;
		}else {
			return false;
		}
	}
	public boolean eliminarClave(String Rut) {
		NodoEstudiante current = first;
		while(current != null && current.getEstudiante().getRut()!=Rut) {
			current = current.getNext();
		}
		if(current!=null) {
			if(current == first) {
				first=current.getNext();
			}else {
				current.getPrevio().setNext(current.getNext());
			}
			if(current==last) {
				last=current.getPrevio();
			}else {
				current.getNext().setPrevio(current.getPrevio());
			}
			return true;
		}
		else {
			return false;
		}
	}
	public String desplegarListaEstudiantes() {
		String dato="";
		if (ListaEstudiantes.this.first != null) { //Lista no vacía 
			NodoEstudiante current = ListaEstudiantes.this.first.getNext();
			while (current != ListaEstudiantes.this.first) {
				dato=dato+"Rut: "+current.getEstudiante().getRut()
						+" , Nombre: "+current.getEstudiante().getNombre()
						+", Actividad de Titulación: "+current.getEstudiante().getActividad().getTemaActividad()
						+"\n";
				current = current.getNext(); 
			}
			//Falta el último nodo
			dato=dato+"Rut: "+current.getEstudiante().getRut()
					+" , Nombre: "+current.getEstudiante().getNombre()
					+", Actividad de Titulación: "+current.getEstudiante().getActividad().getTemaActividad()
					+"\n";
			return dato;
		}else {
			return "Lista Vacía";
		}
	}
}

/**
 * 
 */
package Logica;
import Dominio.*;
import ucn.*;
/**
 * @author sebastiansanchez
 *
 */
public class ListaEstudiantes {
	private NodoEstudiante first;
	private NodoEstudiante last;
	public ListaEstudiantes() {
		first = null;
		last = null;
	}
	public NodoEstudiante getFirst() {
		return first;
	}
	public NodoEstudiante getLast() {
		return last;
	}
	public boolean isEmpty() {
		return first == null;
	}
	public boolean insertar(Estudiante estudiante){
        NodoEstudiante nodo = new NodoEstudiante(estudiante);
        if(isEmpty()){
            this.first = nodo;
            this.last = nodo;
        }else{
            if( !isEmpty() && first == last){
                if(first.getEstudiante().getRut() > estudiante.getRut() ){
                    nodo.setNext(first);
                    nodo.setPrevio(first);
                    first.setNext(nodo);
                    first.setPrevio(nodo);
                    first = nodo;
                }else{
                    nodo.setNext(first);
                    nodo.setPrevio(first);
                    first.setNext(nodo);
                    first.setPrevio(nodo);
                    last = nodo;
                }
            }else if( !isEmpty() && first != last){
                NodoEstudiante aux = first;
                while(aux.getEstudiante().getRut() < estudiante.getRut()){
                    if(aux == last){
                        break;
                    }
                    aux = aux.getNext();
                }
                if(aux == first){
                    nodo.setNext(aux);
                    nodo.setPrevio(aux.getPrevio());
                    aux.getPrevio().setNext(nodo);
                    aux.setPrevio(nodo);
                    first = nodo;
                    return true;
                }else if(aux == last && estudiante.getRut() > last.getEstudiante().getRut()){
                    nodo.setNext(aux.getNext());
                    nodo.setPrevio(aux);
                    aux.getNext().setPrevio(nodo);
                    aux.setNext(nodo);
                    last = nodo;
                    return true;
                }else{
                    nodo.setNext(aux);
                    nodo.setPrevio(aux.getPrevio());
                    aux.getPrevio().setNext(nodo);
                    aux.setPrevio(nodo);
                    return true;
                }
            }
        }
        return false;
    }
	public void insertarPrimer(Estudiante estudiante) {
		NodoEstudiante nuevoEstudiante = new NodoEstudiante(estudiante);
		if(isEmpty()) {
			first = nuevoEstudiante;
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
	public boolean insertarDespues(int Rut,Estudiante estudiante) {
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
	public boolean eliminarClave(int Rut) {
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
}

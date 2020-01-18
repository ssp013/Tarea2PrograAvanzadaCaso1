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
	
	NodoEstudiante last;
	public ListaEstudiantes() {
		last = null;
	}
	public void ingresar(Estudiante estudiante) {
		NodoEstudiante nuevoNodo = new NodoEstudiante(estudiante); 
	        if(last!=null){
	        	nuevoNodo.setNext(last.getNext());
	        	nuevoNodo.setPrevio(last);
	            last.setNext(nuevoNodo);
	            last = nuevoNodo;
	        }else{
	            last = nuevoNodo;
	            nuevoNodo.setNext(nuevoNodo);
	            nuevoNodo.setPrevio(nuevoNodo);
	        }
	}
	    
	
	public Estudiante buscarEstudiante(String rut){
	    if(last!=null){
	        NodoEstudiante current = last.getNext();
	        while(current!=last){
	            if(rut.equals(current.getEstudiante().getRut())){
	                return current.getEstudiante();
	            }
	            current = current.getNext();
	        }
	        if(rut.equals(last.getEstudiante().getRut())){
	            return current.getEstudiante();
	        }
	    }
	    return null;
	}

    public int contadorEstudiantes(){
        int count = 0;
        if(last!=null){
            NodoEstudiante current = last.getNext();
            while(current!=last){
                count++;
                current = current.getNext();
            }
            count++;
        }
        return count;   
    }
    @Override
    public String toString() {
        String resp = "";
        if(last!=null){
            NodoEstudiante current = last.getNext();
            while(current!=last){
                resp = resp +"Rut: "+current.getEstudiante().getRut() +", Nombre: "+current.getEstudiante().getNombre()+"\n";
                current = current.getNext();
            }
            resp = resp +"Rut: "+current.getEstudiante().getRut() +", Nombre: "+current.getEstudiante().getNombre()+"\n";
        }
        return resp;
    }
}

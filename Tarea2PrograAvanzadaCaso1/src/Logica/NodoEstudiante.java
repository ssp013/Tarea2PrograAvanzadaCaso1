/**
 * 
 */
package Logica;
import Dominio.*;
/**
 * @author sebastiansanchez
 *
 */
public class NodoEstudiante {
	private Estudiante estudiante;
	private NodoEstudiante next;
	private NodoEstudiante previo;
	public NodoEstudiante(Estudiante estudiante) {
		this.estudiante = estudiante;
		this.next=null;
		this.previo = null;
	}
	/**
	 * @return the estudiante
	 */
	public Estudiante getEstudiante() {
		return estudiante;
	}
	/**
	 * @param estudiante the estudiante to set
	 */
	public void setEstudiante(Estudiante estudiante) {
		this.estudiante = estudiante;
	}
	/**
	 * @return the next
	 */
	public NodoEstudiante getNext() {
		return next;
	}
	/**
	 * @param next the next to set
	 */
	public void setNext(NodoEstudiante next) {
		this.next = next;
	}
	/**
	 * @return the previo
	 */
	public NodoEstudiante getPrevio() {
		return previo;
	}
	/**
	 * @param previo the previo to set
	 */
	public void setPrevio(NodoEstudiante previo) {
		this.previo = previo;
	}
	
	
}

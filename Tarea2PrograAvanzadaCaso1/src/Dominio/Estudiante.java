/**
 * 
 */
package Dominio;

/**
 * @author sebastiansanchez
 *
 */
public class Estudiante {
	private String Rut;
	private String Nombre;
	private ActividadTitulacion Actividad;
	public Estudiante(String Rut, String Nombre, ActividadTitulacion Actividad) {
		this.Rut = Rut;
		this.Nombre = Nombre;
		this.Actividad = Actividad;
	}
}

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
	/**
	 * @return the rut
	 */
	public String getRut() {
		return Rut;
	}
	/**
	 * @param rut the rut to set
	 */
	public void setRut(String rut) {
		this.Rut = rut;
	}
	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return Nombre;
	}
	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	/**
	 * @return the actividad
	 */
	public ActividadTitulacion getActividad() {
		return Actividad;
	}
	/**
	 * @param actividad the actividad to set
	 */
	public void setActividad(ActividadTitulacion actividad) {
		Actividad = actividad;
	}
	@Override
	public String toString() {
		return "Estudiante [Rut=" + Rut + ", Nombre=" + Nombre + ", Actividad=" + Actividad + "]";
	}
	
}

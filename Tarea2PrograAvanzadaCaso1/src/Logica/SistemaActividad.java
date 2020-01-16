/**
 * 
 */
package Logica;

/**
 * @author sebastiansanchez
 *
 */
public interface SistemaActividad {
	/**
	* Insertar un estudiante al sistema 
	* @param Rut
	* @param Nombre
	* @param codActividad
	*/
	public void ingresarEstudiante(String Rut, String Nombre, String codActividad);
	/**
	* Obtener información de las actividades de titulación.
	* @return Informacion de la actividad de titulación, junto con los estudiantes que la componen */
	public String ObtenerInformacionActividadTitulacion();
	/**
	 * Obtiene la información de un estudiante
	 * @param Rut
	* @return Información del estudiante */
	public String ObtenerDatosdeEstudiante(String Rut);
	
	/**
	* Obtiene la cantidad de estudiantes que cumplen con la actividad de titulación
	* @return cantidad de estudiantes */
	public String ObtenerCantidadEstudiante();
	/**
	* Obtiene la cantidad de actividades de titulación
	* @return Cantidad de actividades de titulación */
	public String ObteneCantidadActividadesdeTitulacion();

}

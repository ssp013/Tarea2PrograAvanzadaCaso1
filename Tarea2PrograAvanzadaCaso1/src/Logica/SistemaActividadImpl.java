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
public class SistemaActividadImpl implements SistemaActividad {
	private ListaEstudiantes Le;
	/**
	 * 
	 */
	public SistemaActividadImpl() {
		// TODO Auto-generated constructor stub
		this.Le = new ListaEstudiantes();
	}
	@Override
	public void ingresarEstudiante(String Rut, String Nombre, String codActividad) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public String ObtenerInformacionActividadTitulacion() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String ObtenerDatosdeEstudiante(String Rut) {
		// TODO Auto-generated method stub

		return null;
	}
	@Override
	public String ObtenerCantidadEstudiante() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String ObteneCantidadActividadesdeTitulacion() {
		// TODO Auto-generated method stub
		return null;
	}
}

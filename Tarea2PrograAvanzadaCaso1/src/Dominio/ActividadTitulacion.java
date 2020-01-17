/**
 * 
 */
package Dominio;
import Logica.*;
/**
 * @author sebastiansanchez
 *
 */
public class ActividadTitulacion {
	private String CodActividad;
	private String TemaActividad;
	private ListaEstudiantes LE;
	public ActividadTitulacion(String CodActividad,String TemaActividad,ListaEstudiantes LE) {
		this.CodActividad = CodActividad;
		this.TemaActividad = TemaActividad;
		this.LE = LE;
	}
	/**
	 * @return the codActividad
	 */
	public String getCodActividad() {
		return CodActividad;
	}
	/**
	 * @param codActividad the codActividad to set
	 */
	public void setCodActividad(String codActividad) {
		CodActividad = codActividad;
	}
	/**
	 * @return the temaActividad
	 */
	public String getTemaActividad() {
		return TemaActividad;
	}
	/**
	 * @param temaActividad the temaActividad to set
	 */
	public void setTemaActividad(String temaActividad) {
		TemaActividad = temaActividad;
	}
	/**
	 * @return the lE
	 */
	public ListaEstudiantes getLE() {
		return LE;
	}
	/**
	 * @param lE the lE to set
	 */
	public void setLE(ListaEstudiantes lE) {
		LE = lE;
	}
	
}

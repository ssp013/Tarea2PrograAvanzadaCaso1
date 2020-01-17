/**
 * 
 */
package Logica;
import Dominio.*;
import ucn.*;
import java.util.*;

/**
 * @author sebastiansanchez
 *
 */
public class SistemaActividadImpl implements SistemaActividad {
	private ListaEstudiantes Le;
	private List<ActividadTitulacion>ActTitulacion;
	/**
	 * 
	 */
	public SistemaActividadImpl() {
		// TODO Auto-generated constructor stub
		this.Le = new ListaEstudiantes();
		this.ActTitulacion = new ArrayList<ActividadTitulacion>();
	}
	@Override
	public void ingresarActividadTitulacion(String codActividad, String Tema, String Rut,String Nombre) {
		// TODO Auto-generated method stub
		ActividadTitulacion actividad = new ActividadTitulacion(codActividad,Tema);
		if(Contiene(codActividad)==false) {
			ActTitulacion.add(actividad);			
			Estudiante estudiante = new Estudiante(Rut,Nombre, actividad);
			ListaEstudiantes le = actividad.getLE();
			le.insertarUltimo(estudiante);
		}else {
			Estudiante estudiante = new Estudiante(Rut,Nombre, actividad);
			ListaEstudiantes le = actividad.getLE();
			le.insertarUltimo(estudiante);
			StdOut.println("1");
		}
	}
	@Override
	public void ingresarEstudiante(String Rut, String Nombre, String codActividad,String tema) {
		// TODO Auto-generated method stub
		/*ActividadTitulacion actividad = new ActividadTitulacion(codActividad,tema);
		Estudiante estu = Le.buscarEstudiante(Rut);
		if(estu==null) {
			Estudiante estudiante = new Estudiante(Rut,Nombre,actividad);
			Le.insertarUltimo(estudiante);
		}*/
		ActividadTitulacion actividad = new ActividadTitulacion(codActividad,tema);
		Estudiante estudiante = new Estudiante(Rut,Nombre,actividad);
		Le.insertarUltimo(estudiante);
	}
	@Override
	public boolean Contiene(String codigo){
		boolean resp = false;
		if(!this.ActTitulacion.isEmpty()){
			for(ActividadTitulacion actividad: this.ActTitulacion){ 
				if(actividad.getCodActividad().equals(codigo)){		
					resp = true; 
				}
			} 
		}
		return resp;
	}
	@Override
	public String ObtenerInformacionActividadTitulacion() {
		//desplegarAdelante(Le);
		String respuesta ="";
		// TODO Auto-generated method stub
		if(!this.ActTitulacion.isEmpty()){
			for(ActividadTitulacion actividad: this.ActTitulacion){
				respuesta=respuesta + "Código: "+actividad.getCodActividad()+
				 ", Tema : "+actividad.getTemaActividad()+"\n";
				respuesta = respuesta + "*Lista de estudiantes: \n";
				ListaEstudiantes le = actividad.getLE();
				respuesta= respuesta+ desplegarAdelante(le)+"\n";
			}
			return respuesta;
		}
		return "No hay Actividades de titulación";
	}
	
	@Override
	public void desplegarLista(){ 
		Iterator<ActividadTitulacion> it = ActTitulacion.iterator();
		while (it.hasNext()) {
		ActividadTitulacion actividad = (ActividadTitulacion) it.next();
		StdOut.println("Alumno: "+alumno.getNombre());
		} 
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

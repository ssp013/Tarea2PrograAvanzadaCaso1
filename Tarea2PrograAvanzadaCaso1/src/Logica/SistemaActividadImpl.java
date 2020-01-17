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
			le.insertarPrimer(estudiante);
		}else {
			Estudiante estudiante = new Estudiante(Rut,Nombre, actividad);
			ListaEstudiantes le = actividad.getLE();
			le.insertarUltimo(estudiante);
		}
	}
	@Override
	public void ingresarEstudiante(String Rut, String Nombre, String codActividad,String tema) {
		// TODO Auto-generated method stub
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
	public String ObtenerInformacionActividadTitulacion(){ 
		String resp = "";
		Iterator<ActividadTitulacion> it = ActTitulacion.iterator();//Iterador
		while (it.hasNext()) {
			ActividadTitulacion actividad = (ActividadTitulacion) it.next();
			String codigo = actividad.getCodActividad();
			String tema = actividad.getTemaActividad();
			ListaEstudiantes lista = actividad.getLE();
			resp=resp+"Código: "+codigo+" - Tema:"+tema+"\n";
			NodoEstudiante current = lista.first;
			int cont=0;
			while(current!=null) {
				cont++;
				resp=resp+"Estudiante Nº"+cont+" : "+current.getEstudiante().getNombre()+"\n";
				current=current.getNext();
			}
		}
		return resp;
	}	
	
	
	@Override
	public String ObtenerDatosdeEstudiante(String Rut) {
		// TODO Auto-generated method stub
		String resp="";
		if(!Le.isEmpty()) {
			NodoEstudiante nodo = Le.first;
			while(nodo.equals(null)) {
				Estudiante est = nodo.getEstudiante();
				if(est.getRut().equals(Rut)) {
					resp=resp+"Rut: "+est.getRut()+", Nombre: "+est.getNombre()+", Actividad Titulacion"+est.getActividad().getCodActividad()+", Tema: "+est.getActividad().getTemaActividad()+"\n";
					break;
				}
			}
			return resp;
		}else {
			return null;
		}
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

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
    	ActividadTitulacion activity = null; 
        Iterator<ActividadTitulacion> it = ActTitulacion.iterator();//POcupamos Iterador
        while (it.hasNext()) {
            ActividadTitulacion act = (ActividadTitulacion) it.next();
            if(act!=null && act.getCodActividad().equals(codActividad)){
            	activity = act;
                break;
            }
        }
        if(activity==null){
            ActividadTitulacion act2 = new ActividadTitulacion(codActividad, Tema);
            ActTitulacion.add(act2);
        }
    }
	
	@Override
	public void ingresarEstudiante(String Rut, String Nombre, String codActividad,String tema) {
        if(Le.buscarEstudiante(Rut)==null){
            ActividadTitulacion activity = null; 
            Iterator<ActividadTitulacion> it = ActTitulacion.iterator();//Ocupamos iteradores.
            while (it.hasNext()) {
                ActividadTitulacion act = (ActividadTitulacion) it.next();
                
                if(act!=null && act.getCodActividad().equals(codActividad)){
                	activity = act;
                    break;
                }
            }
            
            if(activity!=null){
                Estudiante student = new Estudiante(Rut, Nombre,activity);
                activity.getLE().ingresar(student);
                Le.ingresar(student);
            }
        }	
		// TODO Auto-generated method stub
		ActividadTitulacion actividad = new ActividadTitulacion(codActividad,tema);
		Estudiante estudiante = new Estudiante(Rut,Nombre,actividad);
		Le.ingresar(estudiante);
	}

	@Override
	public String ObtenerInformacionActividadTitulacion(){ 
        String resp = "";
        Iterator<ActividadTitulacion> it = ActTitulacion.iterator();//Iteradores
        while (it.hasNext()) {
            ActividadTitulacion act = (ActividadTitulacion) it.next();
            if(act!=null){
                resp =resp+ act.toString()+"\n";
            }
        }
        if(resp.equals("")){
            return "Lista vacía";
        }
        return resp;
	}
	
	public String ObtenerDatosdeEstudiante(String Rut) {
		// TODO Auto-generated method stub
		String resp="";
		Estudiante estudiante = Le.buscarEstudiante(Rut);
		String rut=estudiante.getRut();
		String nombre = estudiante.getNombre();
		String cod = estudiante.getActividad().getCodActividad();
		String tema = estudiante.getActividad().getTemaActividad();
		resp=resp+"Rut:"+rut+", Nombre:"+nombre+", Cod Actividad:"+cod+", Tema:"+tema;
		return resp;
	}
	@Override
	public String ObtenerCantidadEstudiante() {
		// TODO Auto-generated method stub
        String resp = "";
        
        Iterator<ActividadTitulacion> it = ActTitulacion.iterator();//Iterador!!
        int cont =0;
        while (it.hasNext()) {	
            ActividadTitulacion act1 = (ActividadTitulacion) it.next();
            if( act1!=null){
                cont=cont+act1.getLE().contadorEstudiantes();
            }
        }
		resp=resp+"La Cantidad de estudiantes que están haciendo la actividad de titulación son: "+cont;
		return resp;
	}
	@Override
	public String ObteneCantidadActividadesdeTitulacion() {
		// TODO Auto-generated method stub
		String resp ="";
		int cont =0;
		for(ActividadTitulacion act: ActTitulacion) {
			cont++;
		}
		resp=resp+"La cantidad de actividades de titulación son: "+cont;
		return resp;
	}
}

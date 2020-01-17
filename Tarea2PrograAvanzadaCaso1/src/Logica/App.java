/**
 * 
 */
package Logica;
import Dominio.*;
import java.io.IOException;
import java.util.*;
import ucn.*;
/**
 * @author sebastiansanchez
 *
 */
public class App {
	public static void abrirArchivo(SistemaActividad sistema) throws IOException{
		ArchivoEntrada arch1=new ArchivoEntrada("titulacion.txt");
		while(!arch1.isEndFile()) {
			Registro regEnt = arch1.getRegistro();
			String RutEstudiante = regEnt.getString();
			String NombreEstudiante = regEnt.getString();
			String CodActividad = regEnt.getString();
			String TemaActividad = regEnt.getString();
			sistema.ingresarEstudiante(RutEstudiante, NombreEstudiante, CodActividad,TemaActividad);
			sistema.ingresarActividadTitulacion(CodActividad, TemaActividad, RutEstudiante);
		}
		arch1.close(); 
	}
	public static void DesplegarActividadTitulacion(SistemaActividad sistema) {
		String resp = sistema.ObtenerInformacionActividadTitulacion();
		StdOut.println("*****************************************************************");
		StdOut.println("Información de todas las actividades de titulación");
		StdOut.println("*****************************************************************");
		StdOut.println(resp);
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		SistemaActividad sistema = new SistemaActividadImpl();
		//abrirArchivo(sistema);
		sistema.ingresarEstudiante("19100657", "Seba", "01","hola");
		sistema.ingresarEstudiante("19100658", "Seba2", "02","hola2");
		sistema.ingresarEstudiante("123", "Seba3", "03","hola3");

		
		sistema.ingresarActividadTitulacion("01", "hola", "19100657","Seba");
		sistema.ingresarActividadTitulacion("02", "hola2", "19100658","Seba2");
		sistema.ingresarActividadTitulacion("03", "hola3", "123","Seba3");
	;
		
		DesplegarActividadTitulacion(sistema);
		
	}

}

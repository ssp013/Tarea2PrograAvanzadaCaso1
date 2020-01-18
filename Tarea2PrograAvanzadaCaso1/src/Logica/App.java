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
			sistema.ingresarActividadTitulacion(CodActividad, TemaActividad, RutEstudiante, NombreEstudiante);
			sistema.ingresarEstudiante(RutEstudiante, NombreEstudiante, CodActividad,TemaActividad);
		}
		arch1.close(); 
	}
	public static void DesplegarActividadTitulacion(SistemaActividad sistema) {
		StdOut.println("*****************************************************************");
		StdOut.println("Información de todas las actividades de titulación");
		StdOut.println("*****************************************************************");
		String resp = sistema.ObtenerInformacionActividadTitulacion();
		StdOut.println(resp);
	}
	public static void DesplegarEstudianteBuscado(SistemaActividad sistema) {
		StdOut.println("*****************************************************************");
		StdOut.println("Información de todas las actividades de titulación");
		StdOut.println("*****************************************************************");
		StdOut.println("Ingrese el Rut del estudiante que desea revisar:");
		String rut = StdIn.readString();
		String resp = sistema.ObtenerDatosdeEstudiante(rut);
		if(resp==null) {
			StdOut.println("No se presenta ese rut!");
		}else {
		StdOut.println(resp);
		}
	}
	public static void CantidadEstudiantesActividad(SistemaActividad sistema) {
		StdOut.println("*****************************************************************");
		StdOut.println("Cantidad Estudiantes");
		StdOut.println("*****************************************************************");
		String resp = sistema.ObtenerCantidadEstudiante();
		StdOut.println(resp);
	}
	public static void CantidadActividades(SistemaActividad sistema) {
		StdOut.println("*****************************************************************");
		StdOut.println("Cantidad actividades");
		StdOut.println("*****************************************************************");
		String resp = sistema.ObteneCantidadActividadesdeTitulacion();
		StdOut.println(resp);
	}
	public static void iniciarMenu(SistemaActividad sistema) {
		StdOut.println("Bienvenido al sistema");
		StdOut.println("Ingrese una opción");
		StdOut.println("1) Informacion de actividades titulación");
		StdOut.println("2) Información de estudiante");
		StdOut.println("3) Cantidad de estudiantes");
		StdOut.println("4) Cantidad de actividades de titulación");
		StdOut.println("5) salir");
		int opcion = StdIn.readInt();
		//Iniciamos bucle:
		while(opcion!=5) {
			if(opcion==1) {
				DesplegarActividadTitulacion(sistema);
			}else if(opcion==2) {
				DesplegarEstudianteBuscado(sistema);
			}else if(opcion==3) {
				CantidadEstudiantesActividad(sistema);
			}else if(opcion==4) {
				CantidadActividades(sistema);
			}
			StdOut.println("Ingrese una opción");
			StdOut.println("1) Informacion de actividades titulación");
			StdOut.println("2) Información de estudiante");
			StdOut.println("3) Cantidad de estudiantes");
			StdOut.println("4) Cantidad de actividades de titulación");
			StdOut.println("5) salir");
			opcion = StdIn.readInt();
		}

	}
	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		SistemaActividad sistema = new SistemaActividadImpl();
		abrirArchivo(sistema);
		iniciarMenu(sistema);
	}
}

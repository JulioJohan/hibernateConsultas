package practicauno.sda.principal;

import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import practicauno.sda.dao.EscuelaDao;
import practicauno.sda.dto.AreaAcademica;
import practicauno.sda.dto.programas_educativos;

public class ConsultasHibernate {

	public static void main(String[] args) {
		try {
			
			EscuelaDao escuelaDao = EscuelaDao.getEscuelaDao();
			
			System.out.println("Dao implementado");
			
			List<programas_educativos> listaPrograma = escuelaDao.mostrarProgramaEducativoPorNombreNativeQuery("Mercadoctecnia");

			List<AreaAcademica> listaAreaAcemica = escuelaDao.busquedaAreasAcademicasNativeQuery("Tencologico Informacion");
			
			for(programas_educativos datos:listaPrograma) {
				System.out.println("\n");
				System.out.println("\n");
				System.out.println("mostrarProgramaEducativoPorNombreNativeQuery");
				System.out.println("Nombre Programa: " + datos.getNombrePrograma());
				System.out.println("Id Area: " + datos.getIdArea());
				System.out.println("Id Programa: " + datos.getIdPrograma());
				System.out.println("Fecha Creacion: " + datos.getFechaCreacion());
				
				System.out.println("\n");
				System.out.println("\n");
			}			
			
			for(AreaAcademica datos: listaAreaAcemica) {
				System.out.println("busquedaAreasAcademicasNativeQuery");
				System.out.println("Id Area: " + datos.getIdArea());
				System.out.println("Nombre Area: " + datos.getNombreArea());
				System.out.println("Es Activa: " + datos.getEsActiva());
				
				System.out.println("\n");
				System.out.println("\n");

			}
			
			List<AreaAcademica> listaAreaAcademica = escuelaDao.obtenerAreaAcademicaPorCriteria("Tencologico Informacion");
			for(AreaAcademica datos: listaAreaAcademica) {
				System.out.println("obtenerAreaAcademicaPorCriteria");
				System.out.println("Id Area: " + datos.getIdArea());
				System.out.println("Nombre Area: " + datos.getNombreArea());
				System.out.println("Es Activa: " + datos.getEsActiva());
				
				System.out.println("\n");
				System.out.println("\n");

			}
			
			List<programas_educativos> listaProgramasEducativos = escuelaDao.consultarProgramaEducativoNombrePorCriteria("Mercadoctecnia");
			for(programas_educativos datos:listaProgramasEducativos) {
				System.out.println("consultarProgramaEducativoNombrePorCriteria");
				System.out.println("Nombre Programa: " + datos.getNombrePrograma());
				System.out.println("Id Area: " + datos.getIdArea());
				System.out.println("Id Programa: " + datos.getIdPrograma());
				System.out.println("Fecha Creacion: " + datos.getFechaCreacion());
				
				System.out.println("\n");
				System.out.println("\n");
			}	
			
 
		
			
//			for(programas_educativos programa : listaPrograma) {
//				System.out.println("idPrograma \n" + programa.getIdPrograma() + 
//							"idArea \n" + programa.getIdArea() + "\n Nombre Programa" 
//							+ programa.getNombrePrograma() + "\n FechaCreacion" + programa.getFechaCreacion());
//			}
			
		} catch (Exception e) {

		}
	}

}

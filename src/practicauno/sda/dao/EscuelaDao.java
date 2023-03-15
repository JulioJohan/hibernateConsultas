package practicauno.sda.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.query.Query;
import org.hibernate.Session;

import practicauno.sda.dto.AreaAcademica;
import practicauno.sda.dto.programas_educativos;
import practicauno.sda.hibernate.HibernateSessionFactory;

public class EscuelaDao {
	
	private static EscuelaDao escuelaDao = new EscuelaDao();
	
	public static EscuelaDao getEscuelaDao() {
		return escuelaDao;
	}
	protected static Map<String, Integer> CAMPOS = new LinkedHashMap<>();
	protected static Map<String, Integer> CAMPOS2 = new LinkedHashMap<>();

	
	public static final String  CAMPO_IDPROGRAMA = "idPrograma";
	
	public static final String  CAMPO_IDAREA = "idArea";
	
	public static final String  CAMPO_NOMBREAREA = "nombreArea";




	
	static {
		int idx = 0;
		CAMPOS.put(CAMPO_IDPROGRAMA, idx++);
		CAMPOS.put("idArea", idx++);
		CAMPOS.put("nombrePrograma", idx++);
		CAMPOS.put("fechaCreacion", idx++);		
	}
	
	static {
		int idx2 = 0;
		CAMPOS2.put(CAMPO_IDAREA, idx2++);
		CAMPOS2.put(CAMPO_NOMBREAREA, idx2++);
		CAMPOS2.put("esActiva", idx2++);


	}
	
	public List<programas_educativos> mostrarProgramaEducativoPorNombreNativeQuery(String nombrePrograma) throws Exception{
		List <programas_educativos> listaProgramaEductativo = new ArrayList<programas_educativos>();
		Session session = HibernateSessionFactory.getSession();
		
		try {
			String sql = "SELECT idPrograma, idArea, nombrePrograma, fechaCreacion "
					+ "FROM programas_educativos p WHERE p.nombrePrograma = :nombrePrograma";
			Query query = session.createNativeQuery(sql);
			query.setParameter("nombrePrograma", nombrePrograma);
			
			List<Object[]> result1 = query.getResultList();
			if(!result1.isEmpty()) {
				for(Object[] datos: result1) {
					programas_educativos programas = new programas_educativos();
					programas.setIdPrograma((Integer) datos[CAMPOS.get(CAMPO_IDPROGRAMA)]);
					programas.setFechaCreacion((Date) datos[CAMPOS.get("fechaCreacion")]);
					programas.setIdArea((Integer) datos[CAMPOS.get("idArea")]);
					programas.setNombrePrograma((String)datos[CAMPOS.get("nombrePrograma")]);
					listaProgramaEductativo.add(programas);
				}
			}
			
			System.out.println("query"+ query.getQueryString());
//			listaProgramaEductativo = query.list();

			
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage(),e.getCause());
		}finally {
			session.close();
		}
		
		return listaProgramaEductativo;
		
	}
	
	public List<AreaAcademica> busquedaAreasAcademicasNativeQuery(String nombreArea) throws Exception{
		List <AreaAcademica> listaAreaAcademica = new ArrayList<AreaAcademica>();
		Session session = HibernateSessionFactory.getSession();
		
		try {
			String sql = "SELECT idArea, nombreArea, esActiva "
					+ "FROM areas_academicas a WHERE a.nombreArea = :nombreArea";
			Query query = session.createNativeQuery(sql);
			query.setParameter("nombreArea", nombreArea);
			
			List<Object[]> result1 = query.getResultList();
			if(!result1.isEmpty()) {
				for(Object[] datos: result1) {
					AreaAcademica areaAcademica = new AreaAcademica();
					areaAcademica.setEsActiva((Byte)datos[CAMPOS2.get("esActiva")]);
					areaAcademica.setIdArea((Integer)datos[CAMPOS2.get(CAMPO_IDAREA)]);
					areaAcademica.setNombreArea((String)datos[CAMPOS2.get(CAMPO_NOMBREAREA)]);												
					listaAreaAcademica.add(areaAcademica);
				}
			}
			
			System.out.println("query"+ query.getQueryString());
//			listaProgramaEductativo = query.list();

			
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage(),e.getCause());
		}finally {
			session.close();
		}
		
		return listaAreaAcademica;
		
	}
	
	public List<AreaAcademica> obtenerAreaAcademicaPorCriteria(String nombreArea){
		System.out.println("obtenerAreaAcademicaPorCriteria");
		List<AreaAcademica> listaAreaAcademica = new ArrayList<AreaAcademica>();
		
		Session session = HibernateSessionFactory.getSession();
		
		try {
			CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
			CriteriaQuery<AreaAcademica> queryAreaAcademica = criteriaBuilder.createQuery(AreaAcademica.class);
			Root<AreaAcademica> areaAcademica = queryAreaAcademica.from(AreaAcademica.class);
			queryAreaAcademica.select(areaAcademica);
			queryAreaAcademica.where(criteriaBuilder.equal(areaAcademica.get("nombreArea"),nombreArea));
			
			listaAreaAcademica = session.createQuery(queryAreaAcademica).list();
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			session.close();
		}
		
		return listaAreaAcademica;
		
	}
	
	public List<programas_educativos> consultarProgramaEducativoNombrePorCriteria(String nombrePrograma){
		 List<programas_educativos> listaProgramaEducativo = new ArrayList<programas_educativos>();
		 
		 Session session = HibernateSessionFactory.getSession();
		 
		 try {
			
			 CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
			 CriteriaQuery<programas_educativos> queryProgramaEducativo = criteriaBuilder.createQuery(programas_educativos.class);
			 Root<programas_educativos> programaEducativo = queryProgramaEducativo.from(programas_educativos.class);
			 queryProgramaEducativo.select(programaEducativo);
			 queryProgramaEducativo.where(criteriaBuilder.equal(programaEducativo.get("nombrePrograma"), nombrePrograma));
			 
			 listaProgramaEducativo = session.createQuery(queryProgramaEducativo).list();

		} catch (Exception e) {

		}finally {
			session.close();
		}
		 
		 return listaProgramaEducativo;
			 
	}
}

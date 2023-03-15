package practicauno.sda.principal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;

import practicauno.sda.util.MysqlConnection;

public class ConsultasJdbc {
	
	public static void main(String[] args) {
		mostrarDatosProgramasEducativosJDBC("Mercadoctecnia");
		mostrarDatosAreasResponsablesJDBC("Tencologico Informacion");
	}

	public static void mostrarDatosProgramasEducativosJDBC(String nombrePrograma) {
		try {
			
			MysqlConnection conexion = new MysqlConnection();
			Connection conexion1 = conexion.conexion();
			
			PreparedStatement stmt ;
			
			String sql = "SELECT * FROM programas_educativos WHERE nombrePrograma = ? ";
			stmt = conexion1.prepareStatement(sql);
			stmt.setString(1, nombrePrograma);
			ResultSet resultado = stmt.executeQuery();
			
			Integer idPrograma;
			Integer idArea;
			String nombreProgramaSelect;
			Date fechaCreacion;
			
			while (resultado.next()) {
				idPrograma = resultado.getInt(1);
				idArea = resultado.getInt(2);
				nombreProgramaSelect = resultado.getString(3);
				fechaCreacion = resultado.getDate(4);				
				System.out.println("ID Programa: " + idPrograma +
						"\n idArea: " + idArea + "\n nombrePrograma: " + nombreProgramaSelect
						+ "\n fechaCreacion: " + fechaCreacion);
			}			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void mostrarDatosAreasResponsablesJDBC(String nombreArea) {
		try {
			
			MysqlConnection conexion = new MysqlConnection();
			Connection conexion1 = conexion.conexion();
			
			PreparedStatement stmt ;
			
			String sql = "SELECT * FROM areas_academicas WHERE nombreArea = ? ";
			stmt = conexion1.prepareStatement(sql);
			stmt.setString(1, nombreArea);
			ResultSet resultado = stmt.executeQuery();
			
			Integer esActiva;
			Integer idArea;
			String nombreAreaSelect;
			
			while (resultado.next()) {
				idArea = resultado.getInt(1);
				nombreAreaSelect = resultado.getString(2);
				esActiva = resultado.getInt(3);				
				System.out.println("ID Area: " + idArea +
						"\n Activa: " + esActiva + "\n nombreAreaSelect: " + nombreAreaSelect);
			}			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
}

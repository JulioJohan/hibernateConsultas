package practicauno.sda.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class MysqlConnection {

	public Connection conexion() {
		Connection conexion = null;
//		Version java + 8 
//		Class.forName("com.mysql.jbdc.Driver");
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			conexion = DriverManager.getConnection("jdbc:mysql://localhost:3307/carreras","escuela","escuela2023");
			
			boolean validaConexion = conexion.isValid(50000);
			System.out.println(validaConexion ? "Valida":"Error no se conecta a la base de datos");						

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return conexion;
		
	}
}

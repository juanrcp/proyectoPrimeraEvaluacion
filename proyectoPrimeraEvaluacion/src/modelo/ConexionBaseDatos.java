package modelo;

import java.sql.Connection;
import java.sql.DriverManager;

import util.variablesConexionBaseDatos;

public class ConexionBaseDatos {
	
	//CONSTANTES PARA LA CONEXIÓN
	static variablesConexionBaseDatos vcpsql = new variablesConexionBaseDatos();
	static final String HOST = vcpsql.getHost();
	static final String PORT = vcpsql.getPort();
	static final String DB = vcpsql.getDb();
	static final String USER = vcpsql.getUser();
	static final String PASS = vcpsql.getPass();
		
		//MÉTODOS PARA LA CONEXIÓN

		public Connection generaConexion(final String host, final String port, final String db, final String user, final String pass) {

			System.out.println("[INFORMACIÓN-conexionPostgresql-generaConexion] Entra en generaConexion");
			
	        /*Definimos connection a null y url a vacío para 
	         * asegurarnos de que ambas variables están limpias.
	         */
	        Connection conexion = null;
	        String url = "";            
	        url = "jdbc:postgresql://" + host + ":" + port + "/" + db;
			
	        try {
	        	
	        	/*Class.forName obtiene una instancia de la clase de java especificada.
				*En este caso registra la clase como driver JDBC
				*/
	            try {
	                Class.forName("org.postgresql.Driver");
	            } catch (ClassNotFoundException cnfe) {
	                System.out.println("[ERROR-conexionPostgresql-generaConexion] Error en registro driver PostgreSQL: " + cnfe);
	            }
	      
	            //Conexión y validación de la base de datos
	            conexion = DriverManager.getConnection(url, user, pass);           
	            boolean esValida = conexion.isValid(50000);
	            if(esValida == false) {
	            	conexion = null;
	            }
	            System.out.println(esValida ? "[INFORMACIÓN-conexionPostgresql-generaConexion] Conexión a PostgreSQL válida" : "[ERROR-conexionPostgresql-generaConexion] Conexión a PostgreSQL no válida");
	            return conexion;
	            
	        } catch (java.sql.SQLException jsqle) {
	        	
	            System.out.println("[ERROR-conexionPostgresql-generaConexion] Error en conexión a PostgreSQL (" + url + "): " + jsqle);
	            return conexion;
	            
	        }
		}

}

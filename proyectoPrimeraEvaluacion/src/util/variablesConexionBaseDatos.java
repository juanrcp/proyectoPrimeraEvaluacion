package util;

public class variablesConexionBaseDatos {
	
	//Variables para la conexión con la base de datos en este caso PostgreSQL
	
	static final String USER = "postgres";
	static final String PASS = "fp13DAW";
	static final String PORT = "5432";
	static final String HOST = "localhost";
	static final String DB = "EjemploInicial";	
		
	public static String getUser() {
		return USER;
	}
	public static String getPass() {
		return PASS;
	}
	public static String getPort() {
		return PORT;
	}
	public static String getHost() {
		return HOST;
	}
	public static String getDb() {
		return DB;
	}
	
}

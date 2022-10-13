package controlador;

import java.sql.*;
import java.util.ArrayList;

import modelo.ConexionBaseDatos;
import modelo.Productos_DTOs;
import modelo.dtoaDto;
import util.variablesConexionBaseDatos;

public class controlador {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
		/*Se crea una instancia de la clase en la que estamos para poder generar la conexión a PostgreSQL
		*utilizando el método generaConexion
		*/
		ConexionBaseDatos conexionPostgresql = new ConexionBaseDatos();
		Connection conexionGenerada = conexionPostgresql.generaConexion(variablesConexionBaseDatos.getHost(),variablesConexionBaseDatos.getPort(),variablesConexionBaseDatos.getDb(),variablesConexionBaseDatos.getUser(),variablesConexionBaseDatos.getPass());
		
		System.out.println("[INFORMACIÓN-conexionPostgresql-main] Realiza consulta a PostgreSQL");
		
		ArrayList<Productos_DTOs> listaProductos = new ArrayList<>();
		
		if(conexionGenerada != null) {
			
			listaAlumnos = dtoaDto.consultaAlumnos.selectAllAlumnos(conexionGenerada);

		}

	}

}

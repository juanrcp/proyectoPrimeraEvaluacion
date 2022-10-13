package modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import modelo.Productos_DTOs;
import modelo.dtoaDto;

public class ConsultaProductos {
	
public static ArrayList<Productos_DTOs> selectAllProductos (Connection conexion){
		
		Statement declaracionSQL = null;
		ResultSet resultadoConsulta = null;
		ArrayList<Productos_DTOs> listaAlumnos = null;
		
		try {
			
			//Se abre una declaración
			declaracionSQL = conexion.createStatement();
			//Se define la consulta de la declaración y se ejecuta
			resultadoConsulta = declaracionSQL.executeQuery("SELECT * FROM \"dlk_operacional_productos\".\"opr_cat_productos\"");
		    
			listaAlumnos = dtoaDto.resultadoProducto(resultadoConsulta);

			System.out.println("[INFORMACIÓN-conexionPostgresql-main] Cierre conexión, declaración y resultado");				
		    resultadoConsulta.close();
		    declaracionSQL.close();
		    conexion.close();
			
		} catch (SQLException e) {
			
			System.out.println("[ERROR-conexionPostgresql-main] Error generando la declaracionSQL: " + e);
			return listaAlumnos;
			
		}
		
		return listaAlumnos;
	}

}

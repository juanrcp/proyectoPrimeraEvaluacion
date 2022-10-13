package modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modelo.Productos_DTOs;

public class dtoaDto {
	
public static ArrayList<Productos_DTOs> resultadoProducto (ResultSet resultadoConsulta){
		
		ArrayList<Productos_DTOs> listaProductos = null;
		
		//Leemos el resultado de la consulta hasta que no queden filas
		try {
			while ( resultadoConsulta.next() ) {
					
				  Productos_DTOs producto = new Productos_DTOs(resultadoConsulta.getInt("id_producto"), resultadoConsulta.getString("md_uuid"), resultadoConsulta.getString("md_fch"), resultadoConsulta.getString("cod_producto"), resultadoConsulta.getString("nombre_producto"), resultadoConsulta.getString("tipo_producto_origen"), resultadoConsulta.getString("tipo_producto_clase"), resultadoConsulta.getString("des_producto"), resultadoConsulta.getString("fch_alta_producto"), resultadoConsulta.getString("fhc_baja_producto"));
			      System.out.printf( "Identificador Producto: %s , nombre: %s",
			    		  producto.getId_producto(), producto.getNombre_producto());
			      System.out.println();
			      
			      listaProductos.add(producto);

			}
			
			return listaProductos;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return listaProductos;
		}
	}

}

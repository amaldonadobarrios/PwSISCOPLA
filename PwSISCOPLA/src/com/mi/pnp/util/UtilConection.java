package com.mi.pnp.util;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class UtilConection {

	
	public Connection darConeccion() // conexion a la base de datos
	{
		
		Connection cone = null;
		String USERNAME = "hr";
		String PASSWORD = "audidesax";
		//String INSTANCIABD = "esinpoldesa";
		String SERVIDORBD = "localhost";
		String PUERTO = "1521";
	
		String sUrl =    "jdbc:oracle:thin:@//" + SERVIDORBD + ":"
				+ PUERTO;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {	e.printStackTrace();		}
		try {
			cone = DriverManager.getConnection(sUrl, USERNAME, PASSWORD);
			
			System.out.println(" listo conexion bd ok ");
			
		} catch (SQLException e) { 			e.printStackTrace();		}
		
		
		return cone;
	}
		
}


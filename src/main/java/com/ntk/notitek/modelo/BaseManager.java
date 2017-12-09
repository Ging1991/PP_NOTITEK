package com.ntk.notitek.modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class BaseManager {
	protected String driver = "org.postgresql.Driver";
	protected String cadenaConexion = "jdbc:postgresql://localhost:5432/NTK_NOTITEK"; 
	protected String usuarioBD = "postgres"; 
	protected String passwordBD = "root";
	
	public void ejecutarComandoSQL(String sql) {
		try { 
			Class.forName(driver); 
			Connection conexion = DriverManager.getConnection(cadenaConexion, usuarioBD, passwordBD);
			Statement sentencia = conexion.createStatement ();
			sentencia.executeUpdate(sql);		
			sentencia.close();
			conexion.close();
			
		}catch(Exception e) {
			System.out.println("       ERROR: "+sql);
			e.printStackTrace();
		}
		
	}
	
	
}
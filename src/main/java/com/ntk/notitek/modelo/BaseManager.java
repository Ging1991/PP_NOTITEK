package com.ntk.notitek.modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class BaseManager {
	protected String driver = "org.postgresql.Driver";
	
	// local
//	protected String cadenaConexion = "jdbc:postgresql://localhost:5432/NTK_NOTITEK"; 
//	protected String usuarioBD = "postgres"; 
//	protected String passwordBD = "root";
//	
//	
	// produccion
	  protected String cadenaConexion = "jdbc:postgresql://ec2-54-243-252-91.compute-1.amazonaws.com:5432/d20o8pfi1cn2u5?sslmode=require";
	  protected String usuarioBD = "szpprjpxgzpsyf"; 
	  protected String passwordBD = "141e1a1197578265e25776156e0338124e6233c19daccf67b617458e09577282";
	
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
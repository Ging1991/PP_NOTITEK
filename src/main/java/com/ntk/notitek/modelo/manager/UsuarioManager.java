package com.ntk.notitek.modelo.manager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ntk.notitek.modelo.BaseManager;
import com.ntk.notitek.modelo.entidades.Usuario;

public class UsuarioManager extends BaseManager{
	
	public List<Usuario> getUsuarios(){
		List<Usuario> usuarios = new ArrayList<Usuario>();
		
		try { 
			Class.forName(driver); 
			Connection conexion = DriverManager.getConnection(cadenaConexion, usuarioBD, passwordBD); 
			String comandoSQL = "select * from ntk_usuarios";  
			Statement sentencia = conexion.createStatement ();
			ResultSet resultados = sentencia.executeQuery(comandoSQL);			
			
			while (resultados.next())
				usuarios.add(new Usuario(
						resultados.getInt("ID_USUARIO"),
						resultados.getString("NOMBRE"),
						resultados.getString("EMAIL"),
						resultados.getString("PASS")));
			resultados.close();
			sentencia.close();
			conexion.close();
			
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
			
		return usuarios;
	}
	
	public void agregarUsuario(String nombre, String mail, String pass) {
		//String comandoSQL = "INSERT INTO public.ntk_usuarios(nombre, mail, pass) VALUES ('" + nombre +"','"+mail+"','"+pass+"');";
		String comandoSQL = "INSERT INTO ntk_usuarios(nombre, email, pass) VALUES ('" + nombre +"','"+mail+"','"+pass+"');";
		
		
		
		try { 
			Class.forName(driver); 
			Connection conexion = DriverManager.getConnection(cadenaConexion, usuarioBD, passwordBD);
			Statement sentencia = conexion.createStatement ();
			sentencia.executeUpdate(comandoSQL);		
			sentencia.close();
			conexion.close();
			
		}catch(Exception e) {
			System.out.println("       ERROR: "+comandoSQL);
			e.printStackTrace();
		}
		
	}

	public boolean estaRegistrado() {
		return true;
	}

	
	public Usuario getUsuarioPorInicioDeSesion(String nombre, String mail, String  pass) {
		Usuario usuario = null;
		String comandoSQL = ""
				+ " SELECT * "
				+ " FROM ntk_usuarios "
				+ " WHERE (nombre = '" +nombre+ "' OR email = '" +mail+ "') "
				+ "     AND pass = '"+pass+"'";
		
		try { 
			Class.forName(driver); 
			Connection conexion = DriverManager.getConnection(cadenaConexion, usuarioBD, passwordBD); 
			
			Statement sentencia = conexion.createStatement ();
			ResultSet resultados = sentencia.executeQuery(comandoSQL);
			
			if (resultados.next()) {
				usuario = new Usuario(
					resultados.getInt("ID_USUARIO"),
					resultados.getString("NOMBRE"),
					resultados.getString("EMAIL"),
					resultados.getString("PASS"));
			}
			
			resultados.close();
			sentencia.close();
			conexion.close();
			
		}catch(Exception e) {
			System.out.println(comandoSQL);
			e.printStackTrace();
		}
		
		return usuario;		
	}
	
	
	
	
	
}

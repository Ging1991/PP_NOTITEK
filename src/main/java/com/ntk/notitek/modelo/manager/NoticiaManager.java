package com.ntk.notitek.modelo.manager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.ntk.notitek.modelo.BaseManager;
import com.ntk.notitek.modelo.entidades.Noticia;
import com.ntk.notitek.modelo.entidades.ResumenNoticia;
import com.ntk.notitek.modelo.entidades.Usuario;

public class NoticiaManager extends BaseManager{

	public List<ResumenNoticia> getResumenes(){
		List<ResumenNoticia> resumenes = new ArrayList<ResumenNoticia>();
		
		try { 
			Class.forName(driver); 
			Connection conexion = DriverManager.getConnection(cadenaConexion, usuarioBD, passwordBD); 
			String comandoSQL = "select * from ntk_vi_noticias";  
			Statement sentencia = conexion.createStatement ();
			ResultSet resultados = sentencia.executeQuery(comandoSQL);			
			
			while (resultados.next())
				resumenes.add(new ResumenNoticia(
						resultados.getInt("ID_NOTICIA"),
						resultados.getString("NOMBRE"),
						resultados.getString("TITULO"),
						resultados.getString("RESUMEN"),
						resultados.getDate("FECHA_PUBLICACION")));
			resultados.close();
			sentencia.close();
			conexion.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
			
		return resumenes;
	}

	public void crearNoticia(String titulo, String resumen, String cuerpo, Usuario autor) {
		String comandoSQL = "INSERT INTO ntk_noticias(autor, titulo, resumen, cuerpo, fecha_publicacion) "
				+ "VALUES (" + autor.getID_usuario() +",'"+ titulo +"','"+resumen+"', '"+cuerpo+"', '11/11/1991');";
		
		try { 
			Class.forName(driver); 
			Connection conexion = DriverManager.getConnection(cadenaConexion, usuarioBD, passwordBD); 	
			Statement sentencia = conexion.createStatement();
			sentencia.executeUpdate(comandoSQL);			
			sentencia.close();
			conexion.close();
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println(comandoSQL);
		}
		
	}

	public Noticia getNoticiaPorID(int ID) {
		Noticia ret = null;
		String comandoSQL = "select * from ntk_vi_noticias where ID_noticia = "+ID; 
		
		try { 
			Class.forName(driver); 
			Connection conexion = DriverManager.getConnection(cadenaConexion, usuarioBD, passwordBD); 
			Statement sentencia = conexion.createStatement ();
			ResultSet resultados = sentencia.executeQuery(comandoSQL);
			
			if (resultados.next())
				ret = new Noticia(resultados.getInt("ID_NOTICIA"),
						resultados.getString("NOMBRE"),
						resultados.getString("TITULO"),
						resultados.getString("RESUMEN"),
						resultados.getString("CUERPO"),
						resultados.getDate("FECHA_PUBLICACION"));
			
			resultados.close();
			sentencia.close();
			conexion.close();
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println(comandoSQL);
		}
		
		return ret;
	}
	
}

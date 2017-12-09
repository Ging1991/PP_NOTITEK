package com.ntk.notitek.modelo.entidades;

import java.util.Date;

public class ResumenNoticia {
	private int ID_noticia;
	private String titulo, resumen, autor;
	private Date fechaPublicacion;
	
	public ResumenNoticia(int iD_noticia, String autor, String titulo, String resumen, Date fechaPublicacion) {
		super();
		this.ID_noticia = iD_noticia;
		this.autor = autor;
		this.titulo = titulo;
		this.resumen = resumen;
		this.fechaPublicacion = fechaPublicacion;
	}
	
	public int getID_noticia() {
		return ID_noticia;
	}
	public void setID_noticia(int iD_noticia) {
		ID_noticia = iD_noticia;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getResumen() {
		return resumen;
	}
	public void setResumen(String resumen) {
		this.resumen = resumen;
	}
	public Date getFechaPublicacion() {
		return fechaPublicacion;
	}
	public void setFechaPublicacion(Date fechaPublicacion) {
		this.fechaPublicacion = fechaPublicacion;
	}
}
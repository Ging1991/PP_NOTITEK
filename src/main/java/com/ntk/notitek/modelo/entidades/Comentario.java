package com.ntk.notitek.modelo.entidades;

public class Comentario {
	
	private int ID_comentario, usuario, noticia;
	private String texto;

	public Comentario(int iD_comentario, int usuario, int noticia, String texto) {
		super();
		ID_comentario = iD_comentario;
		this.usuario = usuario;
		this.noticia = noticia;
		this.texto = texto;
	}
	
	public int getID_comentario() {
		return ID_comentario;
	}
	public void setID_comentario(int iD_comentario) {
		ID_comentario = iD_comentario;
	}
	public int getUsuario() {
		return usuario;
	}
	public void setUsuario(int usuario) {
		this.usuario = usuario;
	}
	public int getNoticia() {
		return noticia;
	}
	public void setNoticia(int noticia) {
		this.noticia = noticia;
	}
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
}
package com.ntk.notitek.modelo.entidades;

public class Usuario {
	private int ID_usuario;
	private String nombre, email, pass;
	public Usuario(int iD_usuario, String nombre, String email, String pass) {
		super();
		ID_usuario = iD_usuario;
		this.nombre = nombre;
		this.email = email;
		this.pass = pass;
	}
	public int getID_usuario() {
		return ID_usuario;
	}
	public void setID_usuario(int iD_usuario) {
		ID_usuario = iD_usuario;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
}

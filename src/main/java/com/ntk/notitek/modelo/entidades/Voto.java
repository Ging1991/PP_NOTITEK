package com.ntk.notitek.modelo.entidades;

public class Voto {

	private int ID_voto, noticia, votante;
	private boolean esBueno;
	public Voto(int iD_voto, int noticia, int votante, boolean esBueno) {
		super();
		ID_voto = iD_voto;
		this.noticia = noticia;
		this.votante = votante;
		this.esBueno = esBueno;
	}
	public int getID_voto() {
		return ID_voto;
	}
	public void setID_voto(int iD_voto) {
		ID_voto = iD_voto;
	}
	public int getNoticia() {
		return noticia;
	}
	public void setNoticia(int noticia) {
		this.noticia = noticia;
	}
	public int getVotante() {
		return votante;
	}
	public void setVotante(int votante) {
		this.votante = votante;
	}
	public boolean isEsBueno() {
		return esBueno;
	}
	public void setEsBueno(boolean esBueno) {
		this.esBueno = esBueno;
	}

	
}
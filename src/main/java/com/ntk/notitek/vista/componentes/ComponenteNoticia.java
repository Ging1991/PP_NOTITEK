package com.ntk.notitek.vista.componentes;

import com.ntk.notitek.modelo.entidades.Noticia;
import com.ntk.notitek.modelo.manager.NoticiaManager;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

public class ComponenteNoticia extends VerticalLayout{
	private static final long serialVersionUID = 1L;

	public ComponenteNoticia(int ID_noticia) {
		NoticiaManager nm = new NoticiaManager();
		Noticia noticia = nm.getNoticiaPorID(ID_noticia);
		Label texto;
		
		if (noticia == null)
			addComponent(new Label("Noticia no encontrada"));
		else {
			addComponent(texto = new Label(construirNoticia(noticia), ContentMode.HTML));
			setComponentAlignment(texto, Alignment.MIDDLE_CENTER);
		}
			
		setWidth("80%");
	}
	
	private String construirNoticia(Noticia noticia) {
		String ret = "";
		
		// Fecha alineada a la derecha
		ret = ret + "<p align=\"right\">" + noticia.getFechaPublicacion().toString()+"</p>";
		
		// Titulo en negrita y al centro, un poco mas grande
		ret = ret + "<b><p align=\"center\">" + noticia.getTitulo()+ "</p></b>";
		
		//Resumen en cursiva a la izquierda
		ret = ret + "<i><p align=\"left\">" + noticia.getResumen()+ "</p></i>";
		
		
		// Cuerp en letra normal
		ret = ret + "<p>" + noticia.getCuerpo() + "</p>";
		
		// Autor en negrita
		ret = ret + "<b><p align=\"right\">Por " + noticia.getAutor() + "</p></b>";
						
		return ret;
	}
	
}
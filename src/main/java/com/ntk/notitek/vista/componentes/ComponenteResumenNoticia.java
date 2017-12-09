package com.ntk.notitek.vista.componentes;

import com.ntk.notitek.MyUI;
import com.ntk.notitek.modelo.entidades.Noticia;
import com.ntk.notitek.modelo.entidades.ResumenNoticia;
import com.ntk.notitek.modelo.manager.NoticiaManager;
import com.ntk.notitek.vista.paginas.PaginaNoticia;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

public class ComponenteResumenNoticia extends Panel{
	private static final long serialVersionUID = 1L;

	public ComponenteResumenNoticia(ResumenNoticia resumen) {
		setCaption(resumen.getTitulo());
		addClickListener(e -> {
			NoticiaManager nm = new NoticiaManager();
			Noticia noticia = nm.getNoticiaPorID(resumen.getID_noticia());
			MyUI ui = (MyUI) UI.getCurrent();
			ui.setSesion("noticia", noticia);
			ui.irPagina(PaginaNoticia.NAME);
		});

		VerticalLayout contenido = new VerticalLayout();
		String texto = "";
		
		// Fecha alineada a la derecha
		texto = texto + "<p align=\"right\">" + resumen.getFechaPublicacion().toString()+"</p>";
		
		//Resumen en cursiva a la izquierda
		texto = texto + "<i><p align=\"left\">" + resumen.getResumen()+ "</p></i>";
		
		// Autor en negrita
		texto = texto + "<b><p align=\"right\">Por " + resumen.getAutor() + "</p></b>";
		
		Label label = new Label(texto, ContentMode.HTML);
		contenido.addComponent(label);
		contenido.setComponentAlignment(label, Alignment.MIDDLE_CENTER);
		contenido.setWidth("90%");
		setContent(contenido);
		setSizeFull();
	}

}
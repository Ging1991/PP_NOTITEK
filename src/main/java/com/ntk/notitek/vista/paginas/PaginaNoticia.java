package com.ntk.notitek.vista.paginas;

import com.ntk.notitek.MyUI;
import com.ntk.notitek.modelo.entidades.Noticia;
import com.ntk.notitek.vista.componentes.Cabecera;
import com.ntk.notitek.vista.componentes.ComponenteNoticia;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

public class PaginaNoticia extends VerticalLayout implements View{
	private static final long serialVersionUID = 1L;
	public static String NAME = "PaginaNoticia";
	private Cabecera cabecera;
	private ComponenteNoticia noticiaC;
	
	public PaginaNoticia() {
		addComponent(cabecera = Cabecera.getCabecera());		
		addComponent(noticiaC = new ComponenteNoticia(-1));
		setComponentAlignment(noticiaC, Alignment.TOP_CENTER);
	}
	
	@Override
	public void enter(ViewChangeEvent event) {
		cabecera.actualizarCabecera();
		removeComponent(noticiaC);
		
		MyUI ui = (MyUI) UI.getCurrent();
		Noticia noticia = (Noticia) ui.getSesion("noticia");
		
		if (noticia == null)
			addComponent(noticiaC = new ComponenteNoticia(-1));
		else
			addComponent(noticiaC = new ComponenteNoticia(noticia.getID_noticia()));
		
		setComponentAlignment(noticiaC, Alignment.TOP_CENTER);
		
	}
}

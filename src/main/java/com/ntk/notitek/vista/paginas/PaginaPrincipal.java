package com.ntk.notitek.vista.paginas;

import java.util.List;
import com.ntk.notitek.modelo.entidades.ResumenNoticia;
import com.ntk.notitek.modelo.manager.NoticiaManager;
import com.ntk.notitek.vista.componentes.Cabecera;
import com.ntk.notitek.vista.componentes.ComponenteResumenNoticia;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Panel;
import com.vaadin.ui.VerticalLayout;

public class PaginaPrincipal extends VerticalLayout implements View{
	private static final long serialVersionUID = 1L;
	public static String NAME = "PaginaPrincipal";
	private Cabecera cabecera;
	private Panel resumenes;
	
	public PaginaPrincipal() {
		addComponent(cabecera = Cabecera.getCabecera());
		addComponent(resumenes = getResumenes());
	}
	
	private Panel getResumenes() {
		Panel panel = new Panel();
		VerticalLayout contenido = new VerticalLayout();
		
		NoticiaManager nm = new NoticiaManager();
		List<ResumenNoticia> resumenes = nm.getResumenes();
		
		for(ResumenNoticia resumen: resumenes)
			contenido.addComponent(new ComponenteResumenNoticia(resumen));
		
		panel.setContent(contenido);
		return panel;
	}
	
	@Override
	public void enter(ViewChangeEvent event) {
		cabecera.actualizarCabecera();
		removeComponent(resumenes);
		addComponent(resumenes = getResumenes());
		resumenes.setWidth("80%");
		setComponentAlignment(resumenes, Alignment.MIDDLE_CENTER);
	}
	
}

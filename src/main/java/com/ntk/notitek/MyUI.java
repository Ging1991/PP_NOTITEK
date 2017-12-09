package com.ntk.notitek;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.annotation.WebServlet;

import com.ntk.notitek.vista.ABM;
import com.ntk.notitek.vista.paginas.PaginaCrearNoticia;
import com.ntk.notitek.vista.paginas.PaginaIniciarSesion;
import com.ntk.notitek.vista.paginas.PaginaNoticia;
import com.ntk.notitek.vista.paginas.PaginaPrincipal;
import com.ntk.notitek.vista.paginas.PaginaRegistrarUsuario;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.navigator.Navigator;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.UI;

@Theme("mytheme")
public class MyUI extends UI {
	private static final long serialVersionUID = 1L;
	private Map<String, Object> sesion;
	private Navigator navegador;
		
	@Override
    protected void init(VaadinRequest vaadinRequest) {
		sesion = new HashMap<String, Object> ();
		sesion.put("usuario", null);
			
		navegador = new Navigator(this, this);
		
		navegador.addView(ABM.NAME, new ABM());
		navegador.addView(PaginaPrincipal.NAME, new PaginaPrincipal());
		navegador.addView(PaginaRegistrarUsuario.NAME, new PaginaRegistrarUsuario());
		navegador.addView(PaginaIniciarSesion.NAME, new PaginaIniciarSesion());
		navegador.addView(PaginaCrearNoticia.NAME, new PaginaCrearNoticia());
		navegador.addView(PaginaNoticia.NAME, new PaginaNoticia());
		navegador.navigateTo(PaginaPrincipal.NAME);
    }

	public void irPagina(String pagina) {
		navegador.navigateTo(pagina);
	}	
	
	public void setSesion(String clave, Object valor){
		sesion.put(clave, valor);
	}
	
	public Object getSesion(String clave){
		return sesion.get(clave);
	}

    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
		private static final long serialVersionUID = 1L;
    }
}

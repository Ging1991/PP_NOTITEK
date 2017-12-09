package com.ntk.notitek.vista.componentes;

import com.ntk.notitek.MyUI;
import com.ntk.notitek.modelo.entidades.Usuario;
import com.ntk.notitek.vista.paginas.PaginaCrearNoticia;
import com.ntk.notitek.vista.paginas.PaginaIniciarSesion;
import com.ntk.notitek.vista.paginas.PaginaPrincipal;
import com.ntk.notitek.vista.paginas.PaginaRegistrarUsuario;
import com.vaadin.server.ClassResource;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Image;
import com.vaadin.ui.MenuBar;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

public class Cabecera extends VerticalLayout{
	private static final long serialVersionUID = 1L;
	private Image logo;
	private MenuBar menu;
	
	private Cabecera (){
		menu = crearBarraMenu();
		
		logo = new Image(null, new ClassResource("/cabecera.jpg"));
		logo.addClickListener(e -> {
			MyUI aplicacionUI = (MyUI) UI.getCurrent();
			aplicacionUI.irPagina(PaginaPrincipal.NAME);
		});
		
		addComponent(logo);
		addComponent(menu);

		setComponentAlignment(logo, Alignment.TOP_CENTER);
		setComponentAlignment(menu, Alignment.TOP_CENTER);
		logo.setWidth("80%");
		menu.setWidth("80%");
	}

	private MenuBar crearBarraMenu() {
		MyUI aplicacionUI = (MyUI) UI.getCurrent();
		Usuario usuario = (Usuario) aplicacionUI.getSesion("usuario");
		MenuBar barra = new MenuBar();
		
		if (usuario == null) {
			barra.addItem("Ingresar", e -> {
				aplicacionUI.irPagina(PaginaIniciarSesion.NAME);
				});
		} else {
			barra.addItem("Bienvenido/a: "+usuario.getNombre(), null);
			barra.addItem("Crear noticia", e -> {
				aplicacionUI.irPagina(PaginaCrearNoticia.NAME);
				});
			barra.addItem("Mis noticias", null);
			barra.addItem("Salir", e -> {
				aplicacionUI.setSesion("usuario", null);
				aplicacionUI.irPagina(PaginaPrincipal.NAME);
			});
			
			
			
		}
		
		barra.addItem("Registro", e -> {
			MyUI ui = (MyUI) UI.getCurrent();
			ui.irPagina(PaginaRegistrarUsuario.NAME);
		});
				
		return barra;
	}

	static public Cabecera getCabecera() {
		return new Cabecera();
	}
	
	public void actualizarCabecera() {
		removeComponent(menu);
		addComponent(menu = crearBarraMenu());
		setComponentAlignment(menu, Alignment.TOP_CENTER);
	}
	
	
}

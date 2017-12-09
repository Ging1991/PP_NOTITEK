package com.ntk.notitek.vista;

import java.util.List;

import com.ntk.notitek.modelo.entidades.Usuario;
import com.ntk.notitek.modelo.manager.UsuarioManager;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

public class ABM extends VerticalLayout implements View{
	private static final long serialVersionUID = 1L;
	public static String NAME = "ABM";
	public TextField inNombre, inMail, inPass;
	
	public ABM() {
		refrescar();
	}

	
	private void refrescar(){
		removeAllComponents();
		addComponent(new Label("ABM de usuarios"));
		addComponent(inNombre = new TextField("Nombre"));
		addComponent(inMail= new TextField("Mail"));
		addComponent(inPass = new TextField("Pass"));
		
		Button btnCrear = new Button("Agregar usuario");
		btnCrear.addClickListener(e -> {
			agregarUsuario();
		});
		addComponent(btnCrear);

		
		addComponent(new Label("Usuarios que hay actualmente:"));
		UsuarioManager bm = new UsuarioManager();
		List<Usuario> usuarios = bm.getUsuarios();
		
		for(Usuario usuario:usuarios)
			addComponent(new Label("Nombre: "+usuario.getNombre()));
			
	}
	
	
	private void agregarUsuario() {
		UsuarioManager bm = new UsuarioManager();
		String nombre = inNombre.getValue();
		String mail = inMail.getValue();
		String pass = inPass.getValue();
		bm.agregarUsuario(nombre, mail, pass);
		refrescar();
	}
	
	
	
	@Override
	public void enter(ViewChangeEvent event) {
		
	}

}

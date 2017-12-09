package com.ntk.notitek.vista.paginas;
import com.ntk.notitek.MyUI;
import com.ntk.notitek.modelo.entidades.Usuario;
import com.ntk.notitek.modelo.manager.UsuarioManager;
import com.ntk.notitek.vista.componentes.Cabecera;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Panel;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

public class PaginaIniciarSesion extends VerticalLayout implements View{
	private static final long serialVersionUID = 1L;
	public static String NAME = "PaginaIniciarSesion";
	public TextField inNombre, inMail, inPass;
	public Panel iniciarSesion;
	private Cabecera cabecera;
	
	public PaginaIniciarSesion() {
		setHeight("100%");
		addComponent(cabecera = Cabecera.getCabecera());
		addComponent(iniciarSesion = crearFormulario());
		setComponentAlignment(iniciarSesion, Alignment.MIDDLE_CENTER);
	}
	
	private Panel crearFormulario() {
		Panel panel = new Panel("Ingreso para usuarios registrados");
		
		FormLayout formulario = new FormLayout();
		formulario.addComponent(inNombre = new TextField("Usuario"));
		formulario.addComponent(inPass = new TextField("Password"));
		
		Button btAceptar = new Button("Ingresar notitek");
		btAceptar.addClickListener(e -> {
			iniciarSesion();
		});
		
		formulario.addComponent(btAceptar);		
		panel.setContent(formulario);
		panel.setWidthUndefined();
		return panel;
	}
		

	private void iniciarSesion() {
		UsuarioManager bm = new UsuarioManager();
		String nombre = inNombre.getValue();
		String mail = "1";
		String pass = inPass.getValue();
		
		Usuario usuario = bm.getUsuarioPorInicioDeSesion(nombre, mail, pass);
		
		if (usuario != null) {			
			MyUI ui = (MyUI) UI.getCurrent();
			ui.setSesion("usuario", usuario);
			ui.irPagina(PaginaPrincipal.NAME);
		}else {
			Notification.show("Password incorrecta");
		}
	}
	
	@Override
	public void enter(ViewChangeEvent event) {
		cabecera.actualizarCabecera();
		removeComponent(iniciarSesion);
		addComponent(iniciarSesion = crearFormulario());
		setComponentAlignment(iniciarSesion, Alignment.MIDDLE_CENTER);
	}

}

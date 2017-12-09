package com.ntk.notitek.vista.paginas;
import com.ntk.notitek.MyUI;
import com.ntk.notitek.modelo.entidades.Usuario;
import com.ntk.notitek.modelo.manager.UsuarioManager;
import com.ntk.notitek.vista.componentes.Cabecera;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Button;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

public class PaginaRegistrarUsuario extends VerticalLayout implements View{
	private static final long serialVersionUID = 1L;
	public static String NAME = "PaginaRegistrarUsuario";
	public TextField inNombre, inMail, inPass;
	public VerticalLayout iniciarSesion;
	private Cabecera cabecera;
	
	public PaginaRegistrarUsuario() {
		addComponent(cabecera = Cabecera.getCabecera());
		addComponent(iniciarSesion = crearFormulario());
	}
	
	private VerticalLayout crearFormulario() {
		VerticalLayout v = new VerticalLayout();
		v.addComponent(inNombre = new TextField("Nombre"));
		v.addComponent(inMail= new TextField("Mail"));
		v.addComponent(inPass = new TextField("Pass"));
			
		Button btnRegistrar = new Button("Registrar Usuario");
		btnRegistrar.addClickListener(e -> {
			agregarUsuario();
		});
		v.addComponent(btnRegistrar);
		return v;
	}
			
	private void agregarUsuario() {
		UsuarioManager bm = new UsuarioManager();
		String nombre = inNombre.getValue();
		String mail = inMail.getValue();
		String pass = inPass.getValue();
		bm.agregarUsuario(nombre, mail, pass);
		
		MyUI ui = (MyUI) UI.getCurrent();
		ui.setSesion("usuario", new Usuario(1, nombre, mail, pass));
		ui.irPagina(PaginaPrincipal.NAME);
	}
	
	@Override
	public void enter(ViewChangeEvent event) {
		cabecera.actualizarCabecera();
		removeComponent(iniciarSesion);
		addComponent(iniciarSesion = crearFormulario());
	}

}
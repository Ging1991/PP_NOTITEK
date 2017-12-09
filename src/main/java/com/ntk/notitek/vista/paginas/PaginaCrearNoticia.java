package com.ntk.notitek.vista.paginas;
import com.ntk.notitek.MyUI;
import com.ntk.notitek.modelo.entidades.Usuario;
import com.ntk.notitek.modelo.manager.NoticiaManager;
import com.ntk.notitek.vista.componentes.Cabecera;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

public class PaginaCrearNoticia extends VerticalLayout implements View{
	private static final long serialVersionUID = 1L;
	public static String NAME = "PaginaCrearNoticia";
	private TextField inTitulo, inResume;
	private TextArea inCuerpo;
	private Panel formulario;
	private Cabecera cabecera;
	
	public PaginaCrearNoticia() {
		addComponent(cabecera = Cabecera.getCabecera());
		addComponent(formulario = crearFormulario());
		setComponentAlignment(formulario, Alignment.MIDDLE_CENTER);
	}
	
	private Panel crearFormulario() {
		Panel panel = new Panel("Crear una nueva noticia");
		VerticalLayout contenido = new VerticalLayout();
				
		// Debe haber iniciado sesion para crear una noticia
		MyUI ui = (MyUI) UI.getCurrent();
		Usuario usuario = (Usuario) ui.getSesion("usuario");
		
		if (usuario == null) {
			contenido.addComponent(new Label("Debe iniciar sesion para poder crear una noticia"));

			Button btmIniciar = new Button("Iniciar sesion");
			btmIniciar.addClickListener(e -> {
				ui.irPagina(PaginaIniciarSesion.NAME);
			});
			
			contenido.addComponent(btmIniciar);
			panel.setContent(contenido);
		} else {
			FormLayout formulario = new FormLayout();
			formulario.addComponent(inTitulo= new TextField("Titulo"));
			formulario.addComponent(inResume= new TextField("Resumen"));
			formulario.addComponent(inCuerpo= new TextArea("Cuerpo de la noticia"));
			
			inTitulo.setWidth("100%");
			inResume.setWidth("100%");
			inCuerpo.setWidth("100%");
			
			inTitulo.setMaxLength(20);
			inResume.setMaxLength(100);
			inCuerpo.setMaxLength(500);
			
			Button btmCrear = new Button("Crear noticia");
			btmCrear.addClickListener(e -> {
				crearNoticia();
			});
			formulario.addComponent(btmCrear);
			formulario.setWidth("80%");
			formulario.setComponentAlignment(inCuerpo, Alignment.MIDDLE_CENTER);
			panel.setContent(formulario);
		}
		
		panel.setWidth("80%");
		return panel;
	}
	
	
	private void crearNoticia() {
		NoticiaManager nm = new NoticiaManager();
		
		String titulo = inTitulo.getValue();
		String resumen = inResume.getValue();
		String cuerpo= inCuerpo.getValue();
		
		MyUI ui = (MyUI) UI.getCurrent();
		Usuario usuario = (Usuario) ui.getSesion("usuario");
		
		nm.crearNoticia(titulo, resumen, cuerpo, usuario);
		ui.irPagina(PaginaPrincipal.NAME);
	}
	
	@Override
	public void enter(ViewChangeEvent event) {
		cabecera.actualizarCabecera();
		removeComponent(formulario);
		addComponent(formulario = crearFormulario());
		setComponentAlignment(formulario, Alignment.MIDDLE_CENTER);
	}

}
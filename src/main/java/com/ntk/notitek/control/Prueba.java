package com.ntk.notitek.control;

import java.util.List;

import com.ntk.notitek.modelo.entidades.Usuario;
import com.ntk.notitek.modelo.manager.UsuarioManager;

public class Prueba {

	public static void main(String[] args) {
		
		UsuarioManager bm = new UsuarioManager();
		List<Usuario> usuarios = bm.getUsuarios();
		
		for (Usuario usuario:usuarios)
			System.out.println(usuario.getNombre());
		
	}

}

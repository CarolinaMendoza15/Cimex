package com.cimexstock.cimexstock;


import com.cimexstock.controller.LoguinController;

import java.sql.SQLException;


public class CimexstockApplication {

	public static void main(String[] args) throws SQLException {
		//UsuarioServlet usuarioServlet=new UsuarioServlet();
		//System.out.println(usuarioServlet.consultarUsuario(0));
		//usuarioServlet.addUsuario(new Usuario(2,"Maria", "San Martin 234", "Maria", 85844,"123"));
		//List<Usuario> usuarios=usuarioServlet.listartarUsuario();
		//System.out.println(usuarios);
		//usuarios.get(2).setNombre("Maria Catalina");
		//System.out.println(usuarioServlet.modificarUsuario(usuarios.get(2)));

		 LoguinController servlet = new LoguinController();
		 servlet.Loguin();


	}
}
package com.cimexstock.cimexstock;

import com.cimexstock.controller.UsuarioServlet;
import com.cimexstock.db.ConectDb;
import com.cimexstock.modelo.Producto;
import com.cimexstock.modelo.Proveedor;

import java.sql.SQLException;
import java.sql.Statement;


public class
CimexstockApplication {

	public static void main(String[] args) throws SQLException {

		//System.out.println(UsuarioServlet.consultarUsuario("0"));
		ConectDb c = new ConectDb();
		Statement stmt = c.getC().createStatement();
		Proveedor prov1= new Proveedor(1,"Sancor","Avellaneda 135",232323);

		Producto producto= new Producto(2,"leche",130.00,10,30,50,prov1);
		System.out.println(producto);

	}

}

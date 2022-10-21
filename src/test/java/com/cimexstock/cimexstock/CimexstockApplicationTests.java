package com.cimexstock.cimexstock;

import com.cimexstock.modelo.Producto;
import com.cimexstock.modelo.Proveedor;
import com.cimexstock.modelo.Usuario;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CimexstockApplicationTests {

	@Test
	void contextLoads() {
		Usuario usuario= new Usuario(01,"Natalia","paz 234",249455667,"nati","12343");
		System.out.println(usuario);

		Proveedor prov1= new Proveedor(1,"Sancor","Avellaneda 135",232323);

		Producto producto= new Producto(2,"leche",130.00,10,30,50,prov1);
		System.out.println(producto);

	}

}

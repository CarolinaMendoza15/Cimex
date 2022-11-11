package com.cimexstock.controller;

import com.cimexstock.db.ProductoDb;
import com.cimexstock.db.UsuarioDb;
import com.cimexstock.modelo.Producto;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductoController {
    public ProductoController() {
    }
    public Producto consultarProducto(Integer id) throws SQLException {
        return ProductoDb.getProducto(id);
    }
    public List<Producto> listartarProducto() throws SQLException {
        List<Producto> productos = new ArrayList<Producto>();
        productos=ProductoDb.consultarproductos();
        return productos;
    }
    public List<Producto> listartarProductoAlertaStock() throws SQLException {
        List<Producto> productos = new ArrayList<Producto>();
        productos=ProductoDb.consultarproductosBajoStock();
        return productos;
    }
    public boolean addProducto(Producto producto) throws SQLException {
        return ProductoDb.addProducto(producto);
    }
    public boolean modificarProducto(Producto producto) throws SQLException {
        return ProductoDb.modificarProducto(producto);
    }
    public boolean eliminarProducto(Integer id) throws SQLException {
        return ProductoDb.eliminarProducto(id);
    }
}

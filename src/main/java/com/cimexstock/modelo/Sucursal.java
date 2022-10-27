package com.cimexstock.modelo;

import com.cimexstock.modelo.Producto;
import com.cimexstock.modelo.Usuario;
import java.util.ArrayList;
import java.util.List;

public class Sucursal {
    private  int id;
    private  String nombre;
    private  String direccion;
    private  Integer telefono;
    private List< Usuario > usuarios  ;
    private List< Producto > productos ;


    @Override
    public String toString() {
        return "Sucursal{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", direccion='" + direccion + '\'' +
                ", telefono=" + telefono +
                ", usuarios=" + usuarios +
                ", productos=" + productos +
                '}';
    }

    public Sucursal(int id, String nombre, String direccion, Integer telefono) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.usuarios  = new ArrayList<Usuario>();
        this.productos  =  new ArrayList<Producto>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Integer getTelefono() {
        return telefono;
    }

    public void setTelefono(Integer telefono) {
        this.telefono = telefono;
    }

    public List< Usuario > getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List< Usuario > usuarios) {
        this.usuarios.addAll(usuarios);
    }

    public List< Producto > getProductos() {
        return productos;
    }

    public void setProductos(List< Producto > productos) {
        this.productos.addAll(productos);
    }
}

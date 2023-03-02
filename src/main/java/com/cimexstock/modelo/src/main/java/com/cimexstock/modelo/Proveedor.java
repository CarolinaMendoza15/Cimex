package com.cimexstock.modelo.src.main.java.com.cimexstock.modelo;

public class Proveedor {
    private int id;
    private String nombre;
    private String direccion;
    private Integer telefono;


    public Proveedor(int id, String nombre, String direccion, Integer telefono) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    public Proveedor() {
    }

    @Override
    public String toString() {
        return "Proveedor id=" + id +
                ", \nnombre='" + nombre + '\'' +
                ", \ndireccion='" + direccion + '\'' +
                ", \ntelefono=" + telefono +
                " \n ";
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
}

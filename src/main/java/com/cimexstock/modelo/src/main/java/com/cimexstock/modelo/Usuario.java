package com.cimexstock.modelo.src.main.java.com.cimexstock.modelo;

import java.io.Serializable;

public class Usuario implements Serializable {
    private int id;
    private String nombre;
    private String direccion;
    private Integer telefono;
    private String usser;
    private String passware;

    public Usuario(int id, String nombre, String direccion, Integer telefono, String usser, String passware) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.usser = usser;
        this.passware = passware;
    }

    public Usuario() {
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

    public String getUsser() {
        return usser;
    }

    public void setUsser(String usser) {
        this.usser = usser;
    }

    public String getPassware() {
        return passware;
    }

    public void setPassware(String passware) {
        this.passware = passware;
    }

    @Override
    public String toString() {
        return "\nUsuario id=" + id +
                ",\nnombre= " + nombre +
                ",\ndireccion= " + direccion +
                ",\ntelefono= " + telefono +
                ",\nusser= " + usser +
                ",\npassware= " + passware + '\n';
    }
}

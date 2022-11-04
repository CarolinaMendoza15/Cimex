package com.cimexstock.controller;

import com.cimexstock.db.UsuarioDb;
import com.cimexstock.modelo.Usuario;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioServlet  {
    public UsuarioServlet() {
    }

    public Usuario consultarUsuario(Integer id) throws SQLException {
        return UsuarioDb.getUsuario(id);
    }
    public List<Usuario> listartarUsuario() throws SQLException {
        List<Usuario> usuarios = new ArrayList<Usuario>();
        usuarios=UsuarioDb.consultarUsuarios();
        return usuarios;
    }
    public boolean addUsuario(Usuario usuario) throws SQLException {
        return UsuarioDb.addUsuario(usuario);
    }
    public boolean modificarUsuario(Usuario usuario) throws SQLException {
        return UsuarioDb.modificarUsuario(usuario);
    }
    public boolean eliminarUsuario(Usuario usuario) throws SQLException {
        return UsuarioDb.eliminarUsuario(usuario);
    }
}


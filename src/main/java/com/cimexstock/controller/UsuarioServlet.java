package com.cimexstock.controller;

import com.cimexstock.db.UsuarioDb;
import com.cimexstock.modelo.Usuario;
import java.io.IOException;
import java.sql.SQLException;

public class UsuarioServlet  {

   public static Usuario consultarUsuario(Integer id) throws SQLException {
        Usuario usuario=UsuarioDb.getUsuario(id);
       return usuario;
    }
}

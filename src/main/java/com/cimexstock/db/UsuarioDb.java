package com.cimexstock.db;


import com.cimexstock.modelo.Usuario;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDb {

    public List<Usuario> consultarUsuarios() throws SQLException {
        List<Usuario> usuarios =new ArrayList<>();
        ConectDb c = new ConectDb();
          Statement stmt = c.getC().createStatement();
            ResultSet rs = stmt.executeQuery( "SELECT * FROM USUARIO;" );
            while ( rs.next() ) {
                int id = rs.getInt("id");
                String  nombre = rs.getString("nombre");
                String  usser = rs.getString("usser");
                String  passware = rs.getString("passware");
                String  direccion = rs.getString("direccion");
                Integer  telefono = rs.getInt("telefono");

                Usuario us =new Usuario(id,nombre,direccion,usser,telefono);
                usuarios.add(us);
            }
            rs.close();
            stmt.close();
            return usuarios;
    }
    public static Usuario getUsuario(Integer id) throws SQLException {
        Usuario usuario=null;
        ConectDb c = new ConectDb();
        Statement stmt = c.getC().createStatement();
        ResultSet rs = stmt.executeQuery( "SELECT * FROM usuario WERE usuario.id=" + id+";" );
        while ( rs.next() ) {
            String  nom = rs.getString("nombre");
            String  usser = rs.getString("usser");
            String  passware = rs.getString("passware");
            String  direccion = rs.getString("direccion");
            Integer  telefono = rs.getInt("telefono");

            usuario =new Usuario(id,nom,direccion,usser,telefono);

        }
        rs.close();
        stmt.close();
        return usuario;
    }
}

package com.cimexstock.db;


import com.cimexstock.modelo.Usuario;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDb {

    public static List<Usuario> consultarUsuarios() throws SQLException {
        List<Usuario> usuarios =new ArrayList<Usuario>();
        ConectDb c = new ConectDb();
        Statement stmt = c.getC().createStatement();
        ResultSet rs = stmt.executeQuery( "SELECT * FROM USUARIO;" );
        while ( rs.next() ) {
            int id = rs.getInt("id");
            String  nombre = rs.getString("nombre");
            String  usser = rs.getString("usuario");
            String  contrasenia = rs.getString("contrasenia");
            String  direccion = rs.getString("direccion");
            Integer  telefono = rs.getInt("telefono");
            Usuario us =new Usuario(id,nombre,usser,contrasenia,direccion,telefono);
            usuarios.add(us);
        }
        rs.close();
        stmt.close();
        return usuarios;
    }
    public static Usuario getUsuario(Integer id) throws SQLException {
        ConectDb c = new ConectDb();
        Statement stmt = c.getC().createStatement();
        Usuario usuario;
        try{
            PreparedStatement pstmt = c.getC().prepareStatement("SELECT * FROM usuario WHERE id=?;");
            pstmt.setInt(1, 0);
            //los parametros tienen un index 1 id porque es el primero y lleva ?para identifivcar que es un parametro que espera valor
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                Integer  identitif = rs.getInt("id");
                String nombre = rs.getString("nombre");
                String  usser = rs.getString("usser");
                String  contrasenia = rs.getString("contrasenia");
                String  direccion = rs.getString("direccion");
                Integer  telefono = rs.getInt("telefono");

                return(new Usuario(id,nombre,usser,contrasenia,direccion,telefono));

            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static Boolean addUsuario(Usuario usuario) throws SQLException {
        ConectDb c = new ConectDb();
        Statement stmt = c.getC().createStatement();

        try{
            PreparedStatement pstmt = c.getC().prepareStatement("INSERT INTO usuario VALUES (?,?,?,?,?,?)");
            pstmt.setInt(1, usuario.getId());
            pstmt.setString(2, usuario.getUsser());
            pstmt.setString(3, usuario.getContrasenia());
            pstmt.setString(4, usuario.getNombre());
            pstmt.setString(5, usuario.getDireccion());
            pstmt.setInt(6, usuario.getTelefono());
            //los parametros tienen un index 1 id porque es el primero y lleva ?para identifivcar que es un parametro que espera valor
            ResultSet rs = pstmt.executeQuery();
            return rs.next();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    public static Boolean modificarUsuario(Usuario usuario) throws SQLException {
        ConectDb c = new ConectDb();
        Statement stmt = c.getC().createStatement();

        try{
            PreparedStatement pstmt = c.getC().prepareStatement("UPDATE  usuario " +
                    "SET usser = ?, contrasenia=?,nombre=?,direccion=?,telefono=?" +
                    "WHERE id= ?;");
            pstmt.setString(1, usuario.getUsser());
            pstmt.setString(2, usuario.getContrasenia());
            pstmt.setString(3, usuario.getNombre());
            pstmt.setString(4, usuario.getDireccion());
            pstmt.setInt(5, usuario.getTelefono());
            pstmt.setInt(6, usuario.getId());
            //los parametros tienen un index 1 id porque es el primero y lleva ?para identifivcar que es un parametro que espera valor
            int rs = pstmt.executeUpdate();
            return (rs>0);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    public static Boolean eliminarUsuario(Usuario usuario) throws SQLException {
        ConectDb c = new ConectDb();
        Statement stmt = c.getC().createStatement();

        try{
            PreparedStatement pstmt = c.getC().prepareStatement("DELETE FROM   usuario  WHERE id= ?;");
            pstmt.setInt(1, usuario.getId());
            //los parametros tienen un index 1 id porque es el primero y lleva ?para identifivcar que es un parametro que espera valor
            int rs = pstmt.executeUpdate();
            //retorna la cantidad de registros afectados
            return (rs>0);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
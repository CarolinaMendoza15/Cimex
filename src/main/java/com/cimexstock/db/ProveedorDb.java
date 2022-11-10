package com.cimexstock.db;

import com.cimexstock.modelo.Producto;
import com.cimexstock.modelo.Proveedor;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ProveedorDb {
    public static Proveedor getProveedor(Integer id) throws SQLException {
        ConectDb c = new ConectDb();
        Statement stmt = c.getC().createStatement();
        Proveedor proveedor;
        try{
            PreparedStatement pstmt = c.getC().prepareStatement("SELECT * FROM proveedor WHERE id=?;");
            pstmt.setInt(1, id);
            //los parametros tienen un index 1 id porque es el primero y lleva ?para identifivcar que es un parametro que espera valor
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                Integer  identitif = rs.getInt("id");
                String nombre = rs.getString("nombre");
                String  direccion = rs.getString("direccion");
                Integer telefono = rs.getInt("telefono");

                return(new Proveedor(identitif,nombre,direccion,telefono));
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}

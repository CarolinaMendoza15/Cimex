package com.cimexstock.db;


import com.cimexstock.modelo.Producto;
import com.cimexstock.modelo.Proveedor;

import javax.swing.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProductoDb {

    public static List<Producto> consultarproductos() throws SQLException {
        List<Producto> productos =new ArrayList<Producto>();
        ConectDb c = new ConectDb();
        Statement stmt = c.getC().createStatement();
        ResultSet rs = stmt.executeQuery( "SELECT * FROM PRODUCTO;" );
        while ( rs.next() ) {
            int id = rs.getInt("id");
            String  nombre = rs.getString("nombre");
            Integer stock = rs.getInt("stock");
            Double  valorunitario = rs.getDouble("valorunitario");
            Integer stockMinimo = rs.getInt("stock_minimo");
            Integer  stockrecomendado = rs.getInt("stock_recomendado");
            String codigo = rs.getString("codigo");
            Integer proveedor_id = rs.getInt("proveedor_id");
            Proveedor proveedor1= ProveedorDb.getProveedor(proveedor_id);
            Producto us =new Producto(id,nombre,valorunitario,stock,stockMinimo,stockrecomendado,proveedor1);
            productos.add(us);
        }
        rs.close();
        stmt.close();
        return productos;
    }
    public static List<Producto> consultarproductosBajoStock() throws SQLException {
        List<Producto> productos =new ArrayList<Producto>();
        ConectDb c = new ConectDb();
        Statement stmt = c.getC().createStatement();
        ResultSet rs = stmt.executeQuery( "SELECT * FROM PRODUCTO WHERE stock<stock_minimo;" );
        while ( rs.next() ) {
            int id = rs.getInt("id");
            String  nombre = rs.getString("nombre");
            Integer stock = rs.getInt("stock");
            Double  valorunitario = rs.getDouble("valorunitario");
            Integer stockMinimo = rs.getInt("stock_minimo");
            Integer  stockrecomendado = rs.getInt("stock_recomendado");
            String codigo = rs.getString("codigo");
            Integer proveedor_id = rs.getInt("proveedor_id");
            Proveedor proveedor1= ProveedorDb.getProveedor(proveedor_id);
            Producto us =new Producto(id,nombre,valorunitario,stock,stockMinimo,stockrecomendado,proveedor1);
            productos.add(us);
        }
        rs.close();
        stmt.close();
        return productos;
    }
    public static Producto getProducto(Integer id) throws SQLException {

        ConectDb c = new ConectDb();
        Statement stmt = c.getC().createStatement();
        Producto productos;
        try{
            PreparedStatement pstmt = c.getC().prepareStatement("SELECT * FROM producto WHERE id=?;");
            pstmt.setInt(1, id);
            //los parametros tienen un index 1 id porque es el primero y lleva ?para identifivcar que es un parametro que espera valor
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                Integer  identitif = rs.getInt("id");
                String nombre = rs.getString("nombre");
                Integer  stock = rs.getInt("stock");
                Double  valorunitario = rs.getDouble("valorunitario");
                Integer stockMinimo = rs.getInt("stock_minimo");
                Integer  stockRecomendado = rs.getInt("stock_recomendado");
                String codigo = rs.getString("codigo");
                Integer proveedor_id = rs.getInt("proveedor_id");
                Proveedor proveedor1 = ProveedorDb.getProveedor(proveedor_id);
                return(new Producto(identitif,nombre,valorunitario,stock,stockMinimo,stockRecomendado,proveedor1));

            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static Boolean addProducto(Producto productos) throws SQLException {
        ConectDb c = new ConectDb();
        Statement stmt = c.getC().createStatement();

        try{
            PreparedStatement pstmt = c.getC().prepareStatement("INSERT INTO producto VALUES (?,?,?,?,?,?,?,?)");
            pstmt.setInt(1, productos.getId());
            pstmt.setString(2, productos.getNombre());
            pstmt.setString(3,productos.getCodigo());
            pstmt.setInt(4, productos.getStock());
            pstmt.setDouble(5, productos.getValorUnitario());
            pstmt.setInt(6, productos.getStockMinimo());
            pstmt.setInt(7, productos.getStockRecomendado());
            pstmt.setInt(8, productos.getProveedor().getId());
            //los parametros tienen un index 1 id porque es el primero y lleva ?para identifivcar que es un parametro que espera valor
             int rs = pstmt.executeUpdate();
            return (rs>0);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    public static Boolean modificarProducto(Producto productos) throws SQLException {
        ConectDb c = new ConectDb();
        Statement stmt = c.getC().createStatement();

        try{
            PreparedStatement pstmt = c.getC().prepareStatement("UPDATE  producto " +
                    "SET nombre = ?, stock=?, valorunitario=?,stockminimo=?,stock_recomendado=?,coodigo=?,proveedor=?" +
                    "WHERE id= ?;");
            pstmt.setInt(1, productos.getId());;
            pstmt.setString(2, productos.getNombre());
            pstmt.setInt(3, productos.getStock());
            pstmt.setDouble(4, productos.getValorUnitario());
            pstmt.setInt(5, productos.getStockMinimo());
            pstmt.setInt(6, productos.getStockRecomendado());
            pstmt.setString(7, productos.getCodigo());
            pstmt.setInt(8, productos.getProveedor().getId());
            //los parametros tienen un index 1 id porque es el primero y lleva ?para identifivcar que es un parametro que espera valor
            int rs = pstmt.executeUpdate();
            return (rs>0);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    public static Boolean eliminarProducto(Integer id) throws SQLException {
        ConectDb c = new ConectDb();
        Statement stmt = c.getC().createStatement();

        try{
            PreparedStatement pstmt = c.getC().prepareStatement("DELETE FROM   producto  WHERE id= ?;");
            pstmt.setInt(1, id);
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
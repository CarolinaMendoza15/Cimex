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
            String  sucursal = rs.getString("sucursal_id");
            Integer  stockrecomendado = rs.getInt("stock_recomendado");
            String codigo = rs.getString("codigo");
            Integer proveedor = rs.getInt("proveedor_id");
           // Proveedor proveedor1=  db traer proveedor por id
            Proveedor proveedor1=new Proveedor();
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
            pstmt.setInt(1, 0);
            //los parametros tienen un index 1 id porque es el primero y lleva ?para identifivcar que es un parametro que espera valor
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                Integer  identitif = rs.getInt("id");
                String nombre = rs.getString("nombre");
                Integer  stock = rs.getInt("stock");
                Double  valorunitario = rs.getDouble("valorunitario");
                Integer stockMinimo = rs.getInt("stock_minimo");
                String  sucursal = rs.getString("sucursal_id");
                Integer  stockRecomendado = rs.getInt("stock_recomendado");
                String codigo = rs.getString("codigo");
                Integer proveedor = rs.getInt("proveedor_id");

                Producto us =new Producto(identitif,nombre,valorunitario,stock,stockMinimo,stockRecomendado,new Proveedor());

                return(new Producto(identitif,nombre,valorunitario,stock,stockMinimo,stockRecomendado,new Proveedor()));

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
            PreparedStatement pstmt = c.getC().prepareStatement("INSERT INTO producto VALUES (?,?,?,?,?,?)");
            pstmt.setInt(1, productos.getId());;
            pstmt.setString(2, productos.getNombre());
            pstmt.setInt(3, productos.getStock());
            pstmt.setDouble(4, productos.getValorUnitario());
            pstmt.setInt(5, productos.getStockMinimo());
            //pstmt.setString(6,productos.getSucursal());
            pstmt.setInt(7, productos.getStockRecomendado());
           // pstmt.setString(8, productos.getCodigo());
            pstmt.setInt(9, productos.getProveedor().getId());
            //los parametros tienen un index 1 id porque es el primero y lleva ?para identifivcar que es un parametro que espera valor
            ResultSet rs = pstmt.executeQuery();
            return rs.next();
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
                    "SET nombre = ?, stock=?, valorunitario=?,stockminimo=?,sucursal_id=?,stock_recomendado=?,coodigo=?,proveedor=?" +
                    "WHERE id= ?;");
            pstmt.setInt(1, productos.getId());;
            pstmt.setString(2, productos.getNombre());
            pstmt.setInt(3, productos.getStock());
            pstmt.setDouble(4, productos.getValorUnitario());
            pstmt.setInt(5, productos.getStockMinimo());
           // pstmt.setString(6,productos.getSucursal());
            pstmt.setInt(7, productos.getStockRecomendado());
            //pstmt.setString(8, productos.getCodigo());
            pstmt.setInt(9, productos.getProveedor().getId());
            //los parametros tienen un index 1 id porque es el primero y lleva ?para identifivcar que es un parametro que espera valor
            int rs = pstmt.executeUpdate();
            return (rs>0);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    public static Boolean eliminarProducto(Producto producto) throws SQLException {
        ConectDb c = new ConectDb();
        Statement stmt = c.getC().createStatement();

        try{
            PreparedStatement pstmt = c.getC().prepareStatement("DELETE FROM   producto  WHERE id= ?;");
            pstmt.setInt(1, producto.getId());
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
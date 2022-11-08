package com.cimexstock.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConectDb {
        private Connection c = null; // Objeto de tipo coneccion donde se guardaran los datos de coneccion
        private Statement stmt = null; // Objeto de tipo sentencia SQL
        private ResultSet rs = null; // Objeto de tipo resultado Query SQL
        private String url="jdbc:postgresql://localhost:5433/postgres";
        private String usuario="postgres";
        private String passware="caro15";
        // CONSTRUCTOR
        public ConectDb() throws SQLException {
            try {
                Class.forName("org.postgresql.Driver");
                c = DriverManager.getConnection(url, usuario, passware);
                c.setAutoCommit(true);
               } catch (Exception e) {
                System.err.println(e.getClass().getName() + ": " + e.getMessage());
                c.close();
            }
        }


        /**
         * Cierra la coneccion con la BD
         */
        public void cerrarDatabase() throws SQLException {
            if(rs != null) rs.close();
            if(stmt != null) stmt.close();
            // Se cierra conexion a la BD
            c.close();
        }

    public Connection getC() {
        return c;
    }

    public void setC(Connection c) {
        this.c = c;
    }
}

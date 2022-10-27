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

        // CONSTRUCTOR
        public ConectDb() throws SQLException {
            try {
                Class.forName("org.postgresql.Driver");
                c = DriverManager.getConnection("postgres://qjuftihi:MeZRS6tOIkQoqVAumMV8k7VMmGYyNYCm@peanut.db.elephantsql.com/qjuftihi", "qjuftihi", "MeZRS6tOIkQoqVAumMV8k7VMmGYyNYCm");
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

}

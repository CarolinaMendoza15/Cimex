package com.cimexstock.modelo.src.main.java.com.cimexstock.controller;


import com.cimexstock.modelo.src.main.java.com.cimexstock.db.ProveedorDb;
import com.cimexstock.modelo.src.main.java.com.cimexstock.modelo.Proveedor;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProveedorController {
    public List< Proveedor > listartarProveedor() throws SQLException {
        List< Proveedor > prs = new ArrayList< Proveedor >();
        prs = ProveedorDb.ListarProveedor();
        return prs;
    }
}

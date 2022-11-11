package com.cimexstock.controller;


import com.cimexstock.db.ProveedorDb;
import com.cimexstock.modelo.Proveedor;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProveedorController {
    public List< Proveedor > listartarProveedor() throws SQLException {
        List<Proveedor> prs = new ArrayList<Proveedor>();
        prs= ProveedorDb.ListarProveedor();
        return prs;
    }
}

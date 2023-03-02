package com.cimexstock.modelo.src.main.java.com.cimexstock.controller;

import java.sql.SQLException;
import java.util.Scanner;

public class LoguinController {
    public LoguinController() {
    }

    public void Loguin() throws SQLException {
        UsuarioController usuarioServlet = new UsuarioController();
        CimexController cimexController = new CimexController();

        boolean log = true;
        do {
            Scanner scan = new Scanner(System.in);
            System.out.println("****************CIMEX***************\n");
            System.out.println("****************LOGUIN***************\n");
            System.out.println("USUARIO = ");
            String usser = scan.next();
            System.out.println("CONTRACEÑA = ");
            String contrasenia = scan.next();
            log = usuarioServlet.existeUsuario(usser, contrasenia);
        } while (!log);
        cimexController.Menu();
    }
}

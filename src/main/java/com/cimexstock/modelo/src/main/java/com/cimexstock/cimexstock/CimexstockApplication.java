package com.cimexstock.modelo.src.main.java.com.cimexstock.cimexstock;


import com.cimexstock.modelo.src.main.java.com.cimexstock.controller.LoguinController;

import java.sql.SQLException;


public class CimexstockApplication {

    public static void main(String[] args) throws SQLException {
        LoguinController servlet = new LoguinController();
        servlet.Loguin();


    }
}
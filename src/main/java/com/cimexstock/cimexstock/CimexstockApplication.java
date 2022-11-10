package com.cimexstock.cimexstock;


import com.cimexstock.controller.LoguinController;

import java.sql.SQLException;


public class CimexstockApplication {

	public static void main(String[] args) throws SQLException {

		 LoguinController servlet = new LoguinController();
		 servlet.Loguin();


	}
}
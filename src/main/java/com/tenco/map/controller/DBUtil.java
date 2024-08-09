package com.tenco.map.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {

	private static final String dbDriver = "org.postgresql.Driver";
	private static final String dbUrl = "jdbc:postgresql://jinnymo.iptime.org:5432/postgres";
	private static final String dbUser = "postgres";
	private static final String dbPassword = "kimbbar3!@";


	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName(dbDriver);
		return DriverManager.getConnection(dbUrl, dbUser, dbPassword);
	}

}

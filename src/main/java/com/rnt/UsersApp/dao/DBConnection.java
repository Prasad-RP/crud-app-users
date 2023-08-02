package com.rnt.UsersApp.dao;

import java.sql.Connection;
import java.sql.DriverManager;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class DBConnection {
	private static final Logger log = LogManager.getLogger(DBConnection.class);
	private Connection con;

	public Connection getConnect() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mvc", "root", "root");
		} catch (Exception e) {
			log.error("got a exception in getConnect DBConnection"+e);
			System.out.println(e);
		}
		return con;
	}

}

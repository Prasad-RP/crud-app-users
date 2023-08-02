package com.rnt.UsersApp.dao;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.CommonDataSource;
import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class DaoConfig {

	public static DataSource dataSource = null;

	public static CommonDataSource getDataSource() throws PropertyVetoException {
		ComboPooledDataSource cpds = new ComboPooledDataSource();
		cpds.setDriverClass("com.mysql.cj.jdbc.Driver");
		cpds.setJdbcUrl("jdbc:mysql://localhost:3306/mvc?useSSL=false");
		cpds.setUser("root");
		cpds.setPassword("root");

		// Optional Settings
		cpds.setInitialPoolSize(10);
		cpds.setMinPoolSize(5);
		cpds.setAcquireIncrement(5);
		cpds.setMaxPoolSize(20);
		cpds.setMaxStatements(100);
		cpds.setMaxIdleTime(2);
		dataSource = cpds;
		return cpds;
	}

	public static Connection getConnection() throws SQLException, PropertyVetoException {
		if (dataSource == null) {
			dataSource = (ComboPooledDataSource) DaoConfig.getDataSource();
		}
		Connection connection = dataSource.getConnection();
		connection.setAutoCommit(true);
		return connection;
	}

}

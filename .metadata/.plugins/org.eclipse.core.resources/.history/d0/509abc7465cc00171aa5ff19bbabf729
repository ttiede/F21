package br.com.caelum.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	// private static final String DB_DRIVER = "com.mysql.jdbc.Driver";
	private static final String DB_CONNECTION = "jdbc:mysql://localhost/fj21";
	private static final String DB_USER = "root";
	private static final String DB_PASSWORD = "caelum";

	public static Connection getConnection() throws SQLException {
		DriverManager.registerDriver(new com.mysql.jdbc.Driver());

		return DriverManager.getConnection(DB_CONNECTION, DB_USER, DB_PASSWORD);
	}
}

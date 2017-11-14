package br.com.caelum.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	private static final String DB_DRIVER = "om.mysql.jdbc.Driver";
	private static final String DB_CONNECTION = "jdbc:mysql://localhost/fj21";
	private static final String DB_USER = "root";
	private static final String DB_PASSWORD = "toor";

	public static Connection getConnection() throws SQLException {

		try {
			Class.forName(DB_DRIVER);
		} catch (ClassNotFoundException e) {
			throw new SQLException(e);
		}

		return DriverManager.getConnection(DB_CONNECTION, DB_USER, DB_PASSWORD);
	}
}

package br.com.syonet.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	static String url = "jdbc:postgresql://localhost:5432/newsletter";
	static String username = "bruno";
	static String password = "syonet";

	public static Connection getConnecion() throws SQLException {
		return DriverManager.getConnection(url,username,password);
		
	}
}

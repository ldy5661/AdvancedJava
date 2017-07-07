package net.antra.deptemp.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCUtility {
	private static final String DB_URL = "jdbc:mysql://localhost/dept_emp_proj";
	private static final String USER = "tomcat";
	private static final String PWD = "1234";
	
	public static Connection getConnection() throws SQLException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		Connection conn = DriverManager.getConnection(DB_URL, USER, PWD);
		return conn;
	}
	
}

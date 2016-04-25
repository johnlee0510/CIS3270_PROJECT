package project;

import java.sql.Connection;
import java.sql.DriverManager;
//import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectTestDB {
	public static Connection conn = null;
	public static Statement stmt = null;
	
	public static void DBconnect() {

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.print("ClassNOtFoundException: ");

		}
		try {
			// url
			System.out.println("Connecting Database");
			String jdbcUrl = "jdbc:mysql://localhost:3306/java_project?useSSL=false";
			String userId = "root";
			String userPass = "java";

			// Connection
			conn = DriverManager.getConnection(jdbcUrl, userId, userPass);
			System.out.println("Database Connected!");
		} catch (SQLException ex) {
			System.out.println("Error");
		}
	}

}
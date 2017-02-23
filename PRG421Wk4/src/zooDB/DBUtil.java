package zooDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil { //  class to store user name, password, connection URL

	private static final String USERNAME = "dbuser";
	private static final String PASSWORD = "dbpassword";
	private static final String H_CONN_STRING =
			"jdbc:hsqldb:data/zoo";
	private static final String M_CONN_STRING =
			"jdbc:mysql://localhost/zoo";

	public static Connection getConnection(DBType dbType) throws SQLException {
		
		switch (dbType) { // switch-case statement to select appropriate driver depending
		                  // on they type of connection, MYSQL or HSQLDB
		case MYSQL:
			return DriverManager.getConnection(M_CONN_STRING, USERNAME, PASSWORD);
		case HSQLDB:
			return DriverManager.getConnection(H_CONN_STRING, USERNAME, PASSWORD);
		default:
			return null;
		} // end of switch-case statement
		
	} // end of getConnection method
	
	public static void processException(SQLException e) { // method to print exception info
		System.err.println("Error message: " + e.getMessage());
		System.err.println("Error code: " + e.getErrorCode());
		System.err.println("SQL state: " + e.getSQLState());
	}
	
} // end of DBUtil class
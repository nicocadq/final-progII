package persistence;

import java.sql.*;

public class Conn {

	public final String DIRVER = "com.mysql.jdbc.Driver";

	public final String DATABASE = "endProject";

	public final String HOSTNAME = "localhost";

	public final String PORT = "3306";

	public final String URL = "jdbc:mysql://" + HOSTNAME + ":" + PORT + "/" + DATABASE+ "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

	public final String USER = "root";

	public final String PSW = "";

	protected Connection conn = null;

	public void MySQLconnection() throws Exception {

		try {
			Class.forName(DIRVER);
			System.out.println("Trying connection.");
			conn = DriverManager.getConnection(URL, USER, PSW);
			System.out.println("We have a connection.");

		} catch (ClassNotFoundException | SQLException ex) {
			throw ex;
		}

	}

	public void coloseConecction() throws Exception {
		if (conn != null) {
			if (!conn.isClosed()) {
				conn.close();
			}
		}
	}

}

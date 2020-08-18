package persistence;

import java.sql.*;

public class Conn {

	public final String DIRVER = "com.mysql.cj.jdbc.Driver";

	public final String DATEBASE = "prueba";

	public final String HOSTNAME = "localhost";

	public final String PORT = "3306";

	public final String URL = "jdbc:mysql://" + HOSTNAME + ":" + PORT + "/" + DATEBASE
			+ "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

	public final String USER = "root";

	public final String PSW = "";

	public Connection MySQLconnection() {
		
		Connection conn = null;
		
		try {
			Class.forName(DIRVER);
			conn = DriverManager.getConnection(URL, USER, PSW);
		} catch( ClassNotFoundException | SQLException ex) {
			ex.printStackTrace();
		}
		
		return conn;
	}

}

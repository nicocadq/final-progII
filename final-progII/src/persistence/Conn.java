package persistence;

import java.sql.*;

public class Conn {

	public final String DIRVER = "com.mysql.cj.jdbc.Driver";

	public final String DATEBASE = "bvjgnfuu9kxfxaxhqsjt";

	public final String HOSTNAME = "bvjgnfuu9kxfxaxhqsjt-mysql.services.clever-cloud.com";

	public final String PORT = "3306";

	public final String URL = "jdbc:mysql://uxigoe9la5ne0tau:5Im5QVjR6qqCtvPSLyCy@bvjgnfuu9kxfxaxhqsjt-mysql.services.clever-cloud.com:3306/bvjgnfuu9kxfxaxhqsjt";

	public final String USER = "uxigoe9la5ne0tau";

	public final String PSW = "5Im5QVjR6qqCtvPSLyCy";
	
	protected Connection conn = null;

	public void MySQLconnection() throws Exception{

		try {
			Class.forName(DIRVER);
			conn = DriverManager.getConnection(URL, USER, PSW);
			
		} catch (ClassNotFoundException | SQLException ex) {
			throw ex;
		}

	}
	
	public void coloseConecction() throws Exception{
		if(conn != null) {
			if(!conn.isClosed()) {
				conn.close();
			}
		}
	}

}

package jdbc.postgress;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBOperations {

	private final String url = "jdbc:postgresql://ibndev004208.bpc.broadcom.net:5432/ao_platform";
	private final String user = "aopuser";
	private final String password = "interOP@123";

	/**
	 * Connect to the PostgreSQL database
	 *
	 * @return a Connection object
	 */
	public Connection connect() {
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement stmt = null;
		try {
			conn = DriverManager.getConnection(url, user, password);
			System.out.println("Connected to the PostgreSQL server successfully.");
			
			stmt = conn.prepareStatement("select * from doi_tenant_alarm_filter");
			rs = stmt.executeQuery();
			
			if(stmt != null) stmt.close();
			
			while(rs.next()) {
				System.out.println(rs.getString("tenantid"));
				System.out.println(rs.getString("filter_name"));
			}
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
				if(stmt != null) stmt.close();
			} catch(SQLException ex) {
				System.out.println("Failed to close connections..");
			}
		}

		return conn;
	}

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		DBOperations app = new DBOperations();
		app.connect();
	}
}


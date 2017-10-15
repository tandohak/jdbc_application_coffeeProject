package jdbc_application_coffeeProject.jdbc;

import java.sql.Connection;
import java.sql.SQLException;


public class JdbcUtill {

	public static void close(Connection con){
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

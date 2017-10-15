package jdbc_application_coffeeProject;

import java.sql.Connection;

import jdbc_application_coffeeProject.jdbc.DBCon;
import jdbc_application_coffeeProject.jdbc.JdbcUtill;

public class testMain {

	public static void main(String[] args) {
		Connection con = DBCon.getInstance().getConnection();
		System.out.println(con);
		
		JdbcUtill.close(con);
	}

}

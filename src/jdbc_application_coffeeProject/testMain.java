package jdbc_application_coffeeProject;

import java.sql.Connection;
import java.sql.SQLException;

import jdbc_application_coffeeProject.jdbc.DBCon;
import jdbc_application_coffeeProject.jdbc.JdbcUtill;
import jdbc_application_coffeeProject.service.ProdcutCodeService;

public class testMain {

	public static void main(String[] args) {
		Connection con = DBCon.getInstance().getConnection();
		System.out.println(con);
		ProdcutCodeService proService;
		
		
		
		JdbcUtill.close(con);
	}

}

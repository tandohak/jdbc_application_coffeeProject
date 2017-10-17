package jdbc_application_coffeeProject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jdbc_application_coffeeProject.dao.CoffeeReportRankDao;
import jdbc_application_coffeeProject.dao.ProductCodeDao;
import jdbc_application_coffeeProject.dto.ProductCode;
import jdbc_application_coffeeProject.jdbc.DBCon;
import jdbc_application_coffeeProject.jdbc.JdbcUtill;

public class testMain {

	public static void main(String[] args) {
		Connection con = DBCon.getInstance().getConnection();
		System.out.println(con);
		
		try {
			System.out.println(CoffeeReportRankDao.getInstance().selectItemByNo(new ProductCode("A001"), true));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		JdbcUtill.close(con);
	}

}

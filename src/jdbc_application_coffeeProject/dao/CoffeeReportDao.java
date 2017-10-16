package jdbc_application_coffeeProject.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jdbc_application_coffeeProject.dto.CoffeeReport;
import jdbc_application_coffeeProject.dto.Product;
import jdbc_application_coffeeProject.dto.ProductCode;
import jdbc_application_coffeeProject.jdbc.DBCon;

public class CoffeeReportDao implements SqlDao<CoffeeReport> {

	@Override
	public void insertItem(CoffeeReport item) throws SQLException {}

	@Override
	public void updateItem(CoffeeReport item) throws SQLException {}

	@Override
	public void deleteItem(CoffeeReport item) throws SQLException {}

	@Override
	public CoffeeReport selectItemByNo(CoffeeReport item) throws SQLException {
		String sql = "SELECT * FROM coffeeReport WHERE proCode = ?";
		CoffeeReport coffeeReport = null;
		
		try(PreparedStatement pstmt = DBCon.getInstance().getConnection().prepareStatement(sql)){
			pstmt.setString(1, item.getProCode().getProducCode());
			
			try(ResultSet rs = pstmt.executeQuery()){
				if(rs.next()){
					coffeeReport = getCoffeeReport(rs);
				}
			}			
			
		}
		
		return coffeeReport;
	}

	private CoffeeReport getCoffeeReport(ResultSet rs) throws SQLException {
		ProductCode proCode = new ProductCode(rs.getString("proCode"));
		int priceSum = rs.getInt("priceSum");
		int surtax = rs.getInt("surtax");
		int supply = rs.getInt("supply");
		int marginPrice = rs.getInt("marginPrice");
		
		return new CoffeeReport(proCode, priceSum, surtax, supply, marginPrice);
	}

	@Override
	public List<CoffeeReport> selectItemByAll() throws SQLException {
		List<CoffeeReport> lists = new ArrayList<>();
		String sql = "SELECT * FROM coffeeReport";
		
		try (PreparedStatement pstmt = DBCon.getInstance().getConnection().prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();) {
			while (rs.next()) {
				lists.add(getCoffeeReport(rs));
			}
		}
		
		return lists;
	}

}

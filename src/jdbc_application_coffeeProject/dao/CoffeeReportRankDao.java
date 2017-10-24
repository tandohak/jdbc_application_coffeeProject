package jdbc_application_coffeeProject.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jdbc_application_coffeeProject.dto.CoffeeReportRank;
import jdbc_application_coffeeProject.dto.ProductCode;
import jdbc_application_coffeeProject.jdbc.DBCon;

public class CoffeeReportRankDao implements SqlDao<CoffeeReportRank> {
	private static final CoffeeReportRankDao instance = new CoffeeReportRankDao();

	private CoffeeReportRankDao() {
	}

	public static CoffeeReportRankDao getInstance() {
		return instance;
	}

	@Override
	public void insertItem(CoffeeReportRank item) throws SQLException {
	}

	@Override
	public void updateItem(CoffeeReportRank item) throws SQLException {
	}

	@Override
	public void deleteItem(CoffeeReportRank item) throws SQLException {
	}

	@Override
	public List<CoffeeReportRank> selectItemByAll() throws SQLException {
		return null;
	}

	@Override
	public CoffeeReportRank selectItemByNo(CoffeeReportRank item) throws SQLException {
		return null;
	}

	public List<CoffeeReportRank> selectItemByAll(boolean isType) throws SQLException {
		// isType true면 마진액순 정렬
		// false면 총판매액 순 정렬
		String sql = "SELECT * FROM " + getTableName(isType);
			   sql += " union ";
		       sql += "select '합계','','','','',sum(priceSum),sum(surtax),sum(supply),'',sum(marginPrice) from coffeereport";
		       sql += " order by rank";
		List<CoffeeReportRank> lists = new ArrayList<>();

		try (PreparedStatement pstmt = DBCon.getInstance().getConnection().prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery()) {
			while (rs.next()) {
				lists.add(getCoffeeReportRank(rs));
			}
		}

		return lists;
	}

	public CoffeeReportRank selectItemByNo(ProductCode item, boolean isType) throws SQLException {
		String sql = "SELECT * FROM " + getTableName(isType) + " WHERE proCode = ?";
			  

		CoffeeReportRank coffeeReportRank = null;

		try (PreparedStatement pstmt = DBCon.getInstance().getConnection().prepareStatement(sql)) {
			pstmt.setString(1, item.getProducCode());

			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs.next()) {
					coffeeReportRank = getCoffeeReportRank(rs);
				}
			}

		}

		return coffeeReportRank;
	}

	private String getTableName(boolean isType) {
		String tableName;
		if (isType) {
			tableName = "coffee_rank_marginPrice_AllSum";
		} else {
			tableName = "coffee_rank_priceSum_AllSum";
		}
		return tableName;
	}

	private CoffeeReportRank getCoffeeReportRank(ResultSet rs) throws SQLException {
		String rank = rs.getString("rank");

		if (rs.getString("rank").equals("합계")) {
			ProductCode proCode = new ProductCode(rs.getString("proCode"));
			String priceSum = String.format("%,d", rs.getInt("priceSum"));
			String surtax = String.format("%,d", rs.getInt("surtax"));
			String supply = String.format("%,d", rs.getInt("supply"));
			String marginPrice = String.format("%,d", rs.getInt("marginPrice"));
			return new CoffeeReportRank(rank, proCode, "", "", "", priceSum, surtax, supply, "", marginPrice);
		}

		ProductCode proCode = new ProductCode(rs.getString("proCode"));
		String proName = rs.getString("producName");
		String price = String.format("%,d", rs.getInt("price"));
		String sale = String.format("%,d", rs.getInt("sale"));
		String priceSum = String.format("%,d", rs.getInt("priceSum"));
		String surtax = String.format("%,d", rs.getInt("surtax"));
		String supply = String.format("%,d", rs.getInt("supply"));
		String margin = String.format("%,d", rs.getInt("margin"));
		String marginPrice = String.format("%,d", rs.getInt("marginPrice"));

		return new CoffeeReportRank(rank, proCode, proName, price, sale, priceSum, surtax, supply, margin, marginPrice);
	}

}

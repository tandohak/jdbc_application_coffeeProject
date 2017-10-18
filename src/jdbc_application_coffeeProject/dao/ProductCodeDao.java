package jdbc_application_coffeeProject.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jdbc_application_coffeeProject.dto.ProductCode;
import jdbc_application_coffeeProject.jdbc.DBCon;

public class ProductCodeDao implements SqlDao<ProductCode> {
	private static final ProductCodeDao intance = new ProductCodeDao();
	
	public static ProductCodeDao getIntance() {
		return intance;
	}

	private ProductCodeDao() {}

	@Override
	public void insertItem(ProductCode item) throws SQLException {
		String sql = "insert into productcode values( ? , ?)";
		
		try(PreparedStatement pstmt = DBCon.getInstance().getConnection().prepareStatement(sql)){
			pstmt.setString(1, item.getProducCode());
			pstmt.setString(2, item.getProducName());
			pstmt.executeUpdate();
		}
		
	}

	@Override
	public void updateItem(ProductCode item) throws SQLException {
		String sql = "UPDATE productcode SET producName = ? WHERE producCode = ? ";
		
		try(PreparedStatement pstmt = DBCon.getInstance().getConnection().prepareStatement(sql)){
			pstmt.setString(1, item.getProducName());
			pstmt.setString(2, item.getProducCode());
			pstmt.executeUpdate();
		}
	}

	@Override
	public void deleteItem(ProductCode item) throws SQLException {
		String sql = "DELETE FROM productCode WHERE producCode = ?";
		
		try(PreparedStatement pstmt = DBCon.getInstance().getConnection().prepareStatement(sql)){
			pstmt.setString(1, item.getProducCode());
		}
	}

	@Override
	public ProductCode selectItemByNo(ProductCode item) throws SQLException {
		String sql = "SELECT * FROM productCode WHERE productCode = ?";
		ProductCode productCode = null;
		
		try(PreparedStatement pstmt = DBCon.getInstance().getConnection().prepareStatement(sql)){
			pstmt.setString(1, item.getProducCode());
			
			try(ResultSet rs = pstmt.executeQuery()){
				if(rs.next()){
					productCode = getProductCode(rs);
				}
			}
			
			
		}
		
		return productCode;
	}
	
	@Override
	public List<ProductCode> selectItemByAll() throws SQLException {
		String sql = "SELECT * FROM productCode";
		List<ProductCode> lists = new ArrayList<>();
		
		try (PreparedStatement pstmt = DBCon.getInstance().getConnection().prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();) {
			while (rs.next()) {
				lists.add(getProductCode(rs));
			}
		}
		
		return lists;
	}	
	
	private ProductCode getProductCode(ResultSet rs) throws SQLException {
		return new ProductCode(rs.getString(1), rs.getString(2));
	}

	
	
}

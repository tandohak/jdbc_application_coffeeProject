package jdbc_application_coffeeProject.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jdbc_application_coffeeProject.dto.Product;
import jdbc_application_coffeeProject.dto.ProductCode;
import jdbc_application_coffeeProject.jdbc.DBCon;

public class ProductDao implements SqlDao<Product>{
	private static final ProductDao instance = new ProductDao();
	
	public static ProductDao getInstance() {
		return instance;
	}

	private ProductDao() {}

	@Override
	public void insertItem(Product item) throws SQLException {
		String sql = "INSERT INTO product VALUE( ? , ? , ? , ? )";
		
		try(PreparedStatement pstmt = DBCon.getInstance().getConnection().prepareStatement(sql)){
			pstmt.setString(1, item.getProCode().getProducCode());
			pstmt.setInt(2, item.getPrice());
			pstmt.setInt(3, item.getSale());
			pstmt.setInt(4, item.getMargin());
			pstmt.executeUpdate();
		}
		
	}

	@Override
	public void updateItem(Product item) throws SQLException {
		String sql = "UPDATE product SET price = ? , sale = ? , margin = ? WHERE proCode = ?";
		
		try(PreparedStatement pstmt = DBCon.getInstance().getConnection().prepareStatement(sql)){
			pstmt.setInt(1, item.getPrice());
			pstmt.setInt(2, item.getSale());
			pstmt.setInt(3, item.getMargin());
			pstmt.setString(4, item.getProCode().getProducCode());
			pstmt.executeUpdate();
		}
	}

	@Override
	public void deleteItem(Product item) throws SQLException {
		String sql = "DELTE FROM product WHERE proCode = ?";
		
		try(PreparedStatement pstmt = DBCon.getInstance().getConnection().prepareStatement(sql)){
			pstmt.setString(1, item.getProCode().getProducCode());
			pstmt.executeUpdate();
		}
	}

	@Override
	public Product selectItemByNo(Product item) throws SQLException {
		String sql = "SELECT * FROM productCode WHERE productCode = ?";
		Product product = null;
		
		try(PreparedStatement pstmt = DBCon.getInstance().getConnection().prepareStatement(sql)){
			pstmt.setString(1, item.getProCode().getProducCode());
			
			try(ResultSet rs = pstmt.executeQuery()){
				if(rs.next()){
					product = getProduct(rs);
				}
			}			
			
		}
		
		return product;
	}

	

	@Override
	public List<Product> selectItemByAll() throws SQLException {
		List<Product> lists = new ArrayList<>();
		String sql = "SELECT * FROM productCode";
		
		try (PreparedStatement pstmt = DBCon.getInstance().getConnection().prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();) {
			while (rs.next()) {
				lists.add(getProduct(rs));
			}
		}
		
		return lists;
	}
	
	private Product getProduct(ResultSet rs) throws SQLException {
		return new Product(new ProductCode(rs.getString(1)), rs.getInt(2), rs.getInt(3), rs.getInt(4));
	}


	
}

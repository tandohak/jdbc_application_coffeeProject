package jdbc_application_coffeeProject.service;

import java.sql.SQLException;
import java.util.List;

import javax.swing.JOptionPane;

import jdbc_application_coffeeProject.dao.ProductCodeDao;
import jdbc_application_coffeeProject.dao.SqlDao;
import jdbc_application_coffeeProject.dto.ProductCode;

public class ProdcutCodeService {
	private SqlDao<ProductCode> proCodeDao;

	private ProdcutCodeService() {
		proCodeDao = ProductCodeDao.getIntance();
	}
	
	public void insertContent(ProductCode item){
		try {
			proCodeDao.insertItem(item);
			showMessage("추가 완료");
		} catch (SQLException e) {
			showMessage(e.getMessage());
			e.printStackTrace();
		}
	}
	
	public void updateContent(ProductCode item){
		try {
			proCodeDao.updateItem(item);
			showMessage("수정 완료");
		} catch (SQLException e) {
			showMessage(e.getMessage());
			e.printStackTrace();
		}
	}
	
	public void deleteContent(ProductCode item){
		try {
			proCodeDao.deleteItem(item);
			showMessage("삭제 완료");
		} catch (SQLException e) {
			showMessage(e.getMessage());
			e.printStackTrace();
		}
	}

	public ProductCode selectContentByNo(ProductCode item){
		try {
			return proCodeDao.selectItemByNo(item);
		} catch (SQLException e) {
			showMessage(e.getMessage());
			e.printStackTrace();
		}
		return null;
	}
	
	public List<ProductCode> selectContentByNo(){
		try {
			return proCodeDao.selectItemByAll();
		} catch (SQLException e) {
			showMessage(e.getMessage());
			e.printStackTrace();
		}
		return null;
	}
	
	private void showMessage(String message) {
		JOptionPane.showMessageDialog(null, message);
	}
	
}

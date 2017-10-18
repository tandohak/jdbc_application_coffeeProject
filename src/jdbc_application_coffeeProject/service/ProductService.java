package jdbc_application_coffeeProject.service;

import java.util.List;

import javax.swing.JOptionPane;

import jdbc_application_coffeeProject.dao.ProductDao;
import jdbc_application_coffeeProject.dao.SqlDao;
import jdbc_application_coffeeProject.dto.Product;

public class ProductService {
	private SqlDao<Product> producDao;

	public ProductService() {
		producDao = ProductDao.getInstance();
	}
	
	public void insertContent(Product item){
		try{
			producDao.insertItem(item);
			showMessage("추가 완료");
		}catch (Exception e) {
			showMessage(e.getMessage());
			e.printStackTrace();
		}
	}
	
	public void updateContent(Product item){
		try{
			producDao.updateItem(item);
			showMessage("수정 완료");
		}catch (Exception e) {
			showMessage(e.getMessage());
			e.printStackTrace();
		}
	}

	public void deleteContent(Product item){
		try{
			producDao.deleteItem(item);
			showMessage("삭제 완료");
		}catch (Exception e) {
			showMessage(e.getMessage());
			e.printStackTrace();
		}
	}
	
	public Product selectContentByNo(Product item){
		try{
			return producDao.selectItemByNo(item);
		}catch (Exception e) {
			showMessage(e.getMessage());
			e.printStackTrace();
		}
		return null;
	}
	
	public List<Product> selectContentByAll(){
		try{
			return producDao.selectItemByAll();
		}catch (Exception e) {
			showMessage(e.getMessage());
			e.printStackTrace();
		}
		return null;
	}
	

	private void showMessage(String message) {
		JOptionPane.showMessageDialog(null, message);		
	}
	
}

package jdbc_application_coffeeProject.service;

import java.util.List;

import javax.swing.JOptionPane;

import jdbc_application_coffeeProject.dao.CoffeeReportRankDao;
import jdbc_application_coffeeProject.dto.CoffeeReportRank;
import jdbc_application_coffeeProject.dto.Product;
import jdbc_application_coffeeProject.dto.ProductCode;

public class CoffeeReportRankService {
	private CoffeeReportRankDao coffeeRankDao;

	public CoffeeReportRankService() {
		coffeeRankDao = CoffeeReportRankDao.getInstance();
	}
	
	
	public CoffeeReportRank selectContentByNo(ProductCode item,boolean isType){
		try{				
			return coffeeRankDao.selectItemByNo(item, isType);
		}catch (Exception e) {
			showMessage(e.getMessage());
			e.printStackTrace();
		}
		return null;
	}
	
	public List<CoffeeReportRank> selectContentByAll(boolean isType){
		try{
			return coffeeRankDao.selectItemByAll(isType);
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

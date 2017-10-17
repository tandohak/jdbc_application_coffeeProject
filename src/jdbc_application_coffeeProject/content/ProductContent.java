package jdbc_application_coffeeProject.content;

import java.awt.GridLayout;

import javax.swing.JPanel;

import jdbc_application_coffeeProject.common.TextFiledComponent;
import jdbc_application_coffeeProject.dto.Product;
import jdbc_application_coffeeProject.dto.ProductCode;

public class ProductContent extends JPanel {

	private TextFiledComponent pProCode;
	private TextFiledComponent pProName;
	private TextFiledComponent pPrice;
	private TextFiledComponent pSale;
	private TextFiledComponent pMargin;

	public ProductContent() {
		setLayout(new GridLayout(0, 1, 0, 0));
		
		pProCode = new TextFiledComponent("제품코드");
		add(pProCode);
		
		pProName = new TextFiledComponent("제품명");
		add(pProName);
		
		pPrice = new TextFiledComponent("제품단가");
		add(pPrice);
		
		pSale = new TextFiledComponent("판수량");
		add(pSale);
		
		pMargin = new TextFiledComponent("마진율");
		add(pMargin);
	}
	
	public Product getContent(){
		ProductCode proCode = new ProductCode(pProCode.getTextValue());
		int price = Integer.parseInt(pPrice.getTextValue());
		int sale = Integer.parseInt(pSale.getTextValue());
		int margin = Integer.parseInt(pMargin.getTextValue());
		return new Product(proCode, price, sale, margin);
	}
	
	public void setContent(Product item){
		pProCode.setTextValue(item.getProCode().getProducCode());
		pPrice.setTextValue(item.getPrice() + "");
		pSale.setTextValue(item.getSale() + "");
		pMargin.setTextValue(item.getMargin() + "");
	}
	
	public void clear(){
		pProCode.setTextValue("");
		pPrice.setTextValue("");
		pSale.setTextValue("");
		pMargin.setTextValue("");
	}
	
	public void isEmptyCheck() throws Exception{
		pProCode.isEmptyCheck();
		pPrice.isEmptyCheck();
		pSale.isEmptyCheck();
		pMargin.isEmptyCheck();
	}

}

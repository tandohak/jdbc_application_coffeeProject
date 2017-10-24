package jdbc_application_coffeeProject.content;

import java.awt.GridLayout;
import java.util.List;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.ComboBoxModel;

import jdbc_application_coffeeProject.common.ComboBoxComponent;
import jdbc_application_coffeeProject.common.TextFiledComponent;
import jdbc_application_coffeeProject.dto.Product;
import jdbc_application_coffeeProject.dto.ProductCode;
import jdbc_application_coffeeProject.service.ProductCodeService;

public class ProductContent extends AbstractContent<Product>{
	private TextFiledComponent pProName;
	private TextFiledComponent pPrice;
	private TextFiledComponent pSale;
	private TextFiledComponent pMargin;
	private ProductCodeService proCodeService;
	private ComboBoxComponent<ProductCode> pProCode;
	private ComboBoxModel<ProductCode> model;
	
	public ProductContent() {
		proCodeService = new ProductCodeService();
		setLayout(new GridLayout(0, 1, 0, 0));
		
		pProCode = new ComboBoxComponent("제품코드");
		add(pProCode);
		
		List<ProductCode> lists = proCodeService.selectContentByAll();
		Vector<ProductCode> item = new Vector<>(lists);
		pProCode.setComboBoxModel(item);
		
		pPrice = new TextFiledComponent("제품단가");
		add(pPrice);
		
		pSale = new TextFiledComponent("판수량");
		add(pSale);
		
		pMargin = new TextFiledComponent("마진율");
		add(pMargin);		
	}
	
	
	
	
	public Product getContent(){
		ProductCode proCode = pProCode.getSelectedItem();
		int price = Integer.parseInt(pPrice.getTextValue());
		int sale = Integer.parseInt(pSale.getTextValue());
		int margin = Integer.parseInt(pMargin.getTextValue());
		return new Product(proCode, price, sale, margin);
	}
	
	public void setContent(Product item){
		pProCode.setSelectedItem(item.getProCode());
		pPrice.setTextValue(item.getPrice() + "");
		pSale.setTextValue(item.getSale() + "");
		pMargin.setTextValue(item.getMargin() + "");
	}
	
	public void clear(){
		pProCode.setSelectedIndex(0);
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
	
	public void confirmItem() throws Exception{
		Pattern p = Pattern.compile("^[1-9][0-9]{0,7}$");
		Matcher m = p.matcher(pPrice.getTextValue());
		
		pPrice.confirmItem(m,"8자리 이내의 정수로 입력하세요");
		
		m = p.matcher(pSale.getTextValue());
		pSale.confirmItem(m,"8자리 이내의 정수로 입력하세요");		
		
		p = Pattern.compile("^[1-9][0-9]{0,1}$");
		m = p.matcher(pMargin.getTextValue());
		pMargin.confirmItem(m,"2자리 이내의 정수로 입력하세요");		
	}
	
	public void load(){
		List<ProductCode> lists = proCodeService.selectContentByAll();
		Vector<ProductCode> item = new Vector<>(lists);
		pProCode.setComboBoxModel(item);
	}




	@Override
	public void setEnabled(boolean isOk) {
		if(!isOk){
			pProCode.setEnabled(false);
			pPrice.setEnabled(false);
			pSale.setEnabled(false);
			pMargin.setEnabled(false);
		}
		pProCode.setEnabled(true);
		pPrice.setEnabled(true);
		pSale.setEnabled(true);
		pMargin.setEnabled(true);
	}
}

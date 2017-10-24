package jdbc_application_coffeeProject.content;

import java.awt.GridLayout;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import jdbc_application_coffeeProject.common.TextFiledComponent;
import jdbc_application_coffeeProject.dto.ProductCode;
import jdbc_application_coffeeProject.service.ProductCodeService;

public class ProductCodeContent extends AbstractContent<ProductCode>{
	private ProductCodeService service;
	private TextFiledComponent pProCode;
	private TextFiledComponent pProName;
	
	public ProductCodeContent() {
		service = new ProductCodeService();		
		
		setLayout(new GridLayout(0, 1, 0, 0));
		
		pProCode = new TextFiledComponent("코드번호");
		add(pProCode);
		
		pProName = new TextFiledComponent("제품명");
		add(pProName);
		
	}

	@Override
	public ProductCode getContent() {
		String producCode = pProCode.getTextValue();
		String producName = pProName.getTextValue();
		return new ProductCode(producCode, producName);
	}
	
	public ProductCode getCodeContent() {
		String producCode = pProCode.getTextValue();
		return new ProductCode(producCode);
	}
	
	@Override
	public void setContent(ProductCode item) {
		pProCode.setTextValue(item.getProducCode());
		pProName.setTextValue(item.getProducName());		
	}

	@Override
	public void clear() {
		pProCode.setTextValue("");
		pProName.setTextValue("");
	}

	@Override
	public void isEmptyCheck() throws Exception {
		pProCode.isEmptyCheck();
		pProName.isEmptyCheck();
	}

	@Override
	public void setEnabled(boolean isOk) {
		
		if(!isOk){
			pProCode.getTextField().setEnabled(false);
			return;
		}
		pProCode.getTextField().setEnabled(true);		
	}

	@Override
	public void confirmItem() throws Exception {
		Pattern p = Pattern.compile("^[가-힣a-zA-Z0-9]{1,10}$");
		Matcher m = p.matcher(pProName.getTextValue());
		
		pProName.confirmItem(m, "10자리 이내의 글자로 입력하세요");	
	}
	

}

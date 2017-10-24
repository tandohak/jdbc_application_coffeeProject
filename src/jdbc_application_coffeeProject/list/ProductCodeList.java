package jdbc_application_coffeeProject.list;

import java.util.List;

import javax.swing.SwingConstants;

import jdbc_application_coffeeProject.dto.ProductCode;
import jdbc_application_coffeeProject.service.ProductCodeService;

public class ProductCodeList extends AbstractList {
	private ProductCodeService service;
	
	public ProductCodeList(ProductCodeService service) {
		this.service = service;
	}

	@Override
	protected String[] getColumnNames() {
		return new String[]{"코드번호","제품명"};
	}

	public Object getSelectedItem() {
		int row = table.getSelectedRow();
		String producCode =(String) table.getValueAt(row, 0);	
		return service.selectContentByNo(new ProductCode(producCode));
	}
	
	@Override
	protected Object[][] getDatas() {
		List<ProductCode> lists = service.selectContentByAll();
		Object[][] datas = new Object[lists.size()][];
		
		for(int i=0; i<datas.length; i++){
			datas[i] = lists.get(i).toArray();
		}
		
		return datas;
	}

	@Override
	protected void setAlignWidth() {
		setCellWidth(150,150);
		setAlign(SwingConstants.CENTER,0,1);
	}

}

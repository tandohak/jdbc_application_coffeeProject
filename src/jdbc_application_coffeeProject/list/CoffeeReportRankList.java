package jdbc_application_coffeeProject.list;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import jdbc_application_coffeeProject.dto.CoffeeReportRank;
import jdbc_application_coffeeProject.service.CoffeeReportRankService;

public class CoffeeReportRankList extends JPanel {
	private JTable table;
	CoffeeReportRankService service = new CoffeeReportRankService();
	
	public CoffeeReportRankList(boolean isType) {
		setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		DefaultTableModel model = new DefaultTableModel(getDatas(isType), getColumnNames());
		table.setModel(model);
	}

	private String[] getColumnNames() {
		return new String[]{"순위","제품코드","제품명","제품단가","판매수량","판매금액","부가세액","공급가액","마진율","마진액"};
	}

	private Object[][] getDatas(boolean isType) {
		List<CoffeeReportRank> lists = service.selectContentByAll(isType);
		Object[][] data = new Object[lists.size()][];
		
		for(int i=0; i<lists.size(); i++){
			data[i] = lists.get(i).toArray();
		}
		
		return data;
	}	
	
	public void loadData(boolean isType) {
		DefaultTableModel model = new DefaultTableModel(getDatas(isType), getColumnNames());
		table.setModel(model);
	}
	
	

}

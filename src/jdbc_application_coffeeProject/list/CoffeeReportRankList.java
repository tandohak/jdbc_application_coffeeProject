package jdbc_application_coffeeProject.list;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

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
		
		setAlignWidth();
	}
	
	protected void setAlignWidth(){
		setCellWidth(50,100,150,110,110,150,150,150,80,150);
		setAlign(SwingConstants.CENTER, 0,1,2,3,4,8);
		setAlign(SwingConstants.RIGHT, 5,6,7,9);
	};

	protected void setCellWidth(int...witdh) {
		TableColumnModel cModel = table.getColumnModel();
		
		for(int i=0; i<witdh.length; i++){
			cModel.getColumn(i).setPreferredWidth(witdh[i]);
		}
	}

	protected void setAlign(int align, int ...idx ) {
		//0번 컬럼을 정렬(Left, Right, Center)
		DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
		dtcr.setHorizontalAlignment(align);
		
		TableColumnModel cModel = table.getColumnModel();
		
		for(int i=0; i<idx.length; i++){
			cModel.getColumn(idx[i]).setCellRenderer(dtcr);
		}	
	}
	

}

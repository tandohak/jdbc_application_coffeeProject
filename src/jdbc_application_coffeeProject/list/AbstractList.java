package jdbc_application_coffeeProject.list;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

public abstract class AbstractList extends JPanel {
	protected JTable table;

	public AbstractList() {
		setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);

		table = new JTable();
		scrollPane.setViewportView(table);

		
	}
	
	public void setPopupMenu(JPopupMenu popupMenu){
		table.setComponentPopupMenu(popupMenu);
	}
	
	protected abstract String[] getColumnNames();

	protected abstract Object[][] getDatas();

	protected abstract void setAlignWidth();

	protected void setCellWidth(int... witdh) {
		TableColumnModel cModel = table.getColumnModel();

		for (int i = 0; i < witdh.length; i++) {
			cModel.getColumn(i).setPreferredWidth(witdh[i]);
		}
	}

	

	public void loadData() {
		DefaultTableModel model = new DefaultTableModel(getDatas(), getColumnNames());
		table.setModel(model);

		setAlignWidth();
	}

	protected void setAlign(int align, int... idx) {
		// 0번 컬럼을 정렬(Left, Right, Center)
		DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
		dtcr.setHorizontalAlignment(align);

		TableColumnModel cModel = table.getColumnModel();

		for (int i = 0; i < idx.length; i++) {
			cModel.getColumn(idx[i]).setCellRenderer(dtcr);
		}
	}
}

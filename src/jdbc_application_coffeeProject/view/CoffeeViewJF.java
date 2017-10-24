package jdbc_application_coffeeProject.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;

import jdbc_application_coffeeProject.content.ProductCodeContent;
import jdbc_application_coffeeProject.content.ProductContent;
import jdbc_application_coffeeProject.dto.ProductCode;
import jdbc_application_coffeeProject.list.ProductCodeList;
import jdbc_application_coffeeProject.service.ProductCodeService;
import jdbc_application_coffeeProject.service.ProductService;

public class CoffeeViewJF extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JButton btnSaleRank;
	private JButton btnInsert;
	private JButton btnMarginRank;
	private SaleRankFrame frame = null;
	private MaringRankFrame marginframe = null;
	private ProductService proService;
	private ProductCodeService proCodeService;
	private ProductContent pProduct;
	private JPanel pCmBtn;
	private JPanel pCoffeeManager;
	private JTabbedPane tabbedPane;
	private JPanel pProductManager;
	private ProductCodeContent pProductCode;
	private JPanel pPmBtn;
	private JButton btnAdd;
	private ProductCodeList pProductList;
	private JPopupMenu popupMenu;
	private JMenuItem btnPopDel;
	private JMenuItem btnPopUpdate;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CoffeeViewJF frame = new CoffeeViewJF();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public CoffeeViewJF() {
		proService = new ProductService();
		proCodeService = new ProductCodeService();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 462, 454);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, BorderLayout.CENTER);

		pCoffeeManager = new JPanel();
		tabbedPane.addTab("판매 관리", null, pCoffeeManager, null);
		pCoffeeManager.setLayout(new BorderLayout(0, 0));

		pProduct = new ProductContent();
		pCoffeeManager.add(pProduct, BorderLayout.CENTER);

		pCmBtn = new JPanel();
		pCoffeeManager.add(pCmBtn, BorderLayout.SOUTH);
		pCmBtn.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		btnInsert = new JButton("입력");
		btnInsert.addActionListener(this);
		pCmBtn.add(btnInsert);

		btnSaleRank = new JButton("판매금액순위");
		btnSaleRank.addActionListener(this);
		pCmBtn.add(btnSaleRank);

		btnMarginRank = new JButton("마진금액순위");
		btnMarginRank.addActionListener(this);
		pCmBtn.add(btnMarginRank);

		pProductManager = new JPanel();
		tabbedPane.addTab("제품 관리", null, pProductManager, null);
		pProductManager.setLayout(new BorderLayout(0, 0));

		pProductCode = new ProductCodeContent();
		pProductManager.add(pProductCode, BorderLayout.NORTH);
		pProductCode.setLayout(new GridLayout(0, 1, 0, 0));

		pPmBtn = new JPanel();
		pProductManager.add(pPmBtn, BorderLayout.SOUTH);

		btnAdd = new JButton("추가");
		btnAdd.addActionListener(this);
		pPmBtn.add(btnAdd);
		
		pProductList = new ProductCodeList(proCodeService);
		pProductManager.add(pProductList, BorderLayout.CENTER);
		pProductList.loadData();
		
		popupMenu = new JPopupMenu();
		btnPopDel = new JMenuItem("삭제");
		btnPopUpdate = new JMenuItem("수정");
		btnPopDel.addActionListener(this);
		btnPopUpdate.addActionListener(this);
		popupMenu.add(btnPopDel);
		popupMenu.add(btnPopUpdate);
		pProductList.setPopupMenu(popupMenu);
	}

	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == btnPopDel){
			proCodeService.deleteContent((ProductCode)pProductList.getSelectedItem());
			pProductList.loadData();
			pProduct.load();
		}
		if(e.getSource() == btnPopUpdate){
			ProductCode item = (ProductCode)pProductList.getSelectedItem();
			pProductCode.setEnabled(false);
			pProductCode.setContent(item);
			btnAdd.setText("수정");
		}
		if (e.getSource() == btnAdd) {
			if(e.getActionCommand() == "추가"){
				try {
					pProductCode.isEmptyCheck();
					pProductCode.confirmItem();
					pProductCode.requestFocus();
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
					return;
				}
				proCodeService.insertContent(pProductCode.getContent());
				pProductCode.clear();
				pProductList.loadData();
				pProduct.load();
			}
			
			if(e.getActionCommand() == "수정"){
				try {
					pProductCode.requestFocus();
					pProductCode.isEmptyCheck();
					pProductCode.confirmItem();
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
					return;
				}
				proCodeService.updateContent(pProductCode.getContent());
				pProductCode.setEnabled(true);
				pProductCode.clear();
				pProductList.loadData();
				pProduct.load();
				btnAdd.setText("추가");
			}
			
		}
		if (e.getSource() == btnMarginRank) {

			if (marginframe == null) {
				marginframe = new MaringRankFrame();
			}
			marginframe.loadData();
			marginframe.setVisible(true);
		}
		if (e.getSource() == btnInsert) {

			try {
				pProduct.isEmptyCheck();
				pProduct.confirmItem();
				pProduct.requestFocus();
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, e1.getMessage());
				return;
			}

			proService.insertContent(pProduct.getContent());

			pProduct.clear();
		}
		if (e.getSource() == btnSaleRank) {

			if (frame == null) {
				frame = new SaleRankFrame();
			}
			frame.loadData();
			frame.setVisible(true);
		}
	}

	
	
}

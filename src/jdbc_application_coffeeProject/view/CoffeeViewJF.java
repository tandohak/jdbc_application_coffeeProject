package jdbc_application_coffeeProject.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import jdbc_application_coffeeProject.content.ProductContent;
import jdbc_application_coffeeProject.dto.ProductCode;
import jdbc_application_coffeeProject.service.ProdcutCodeService;
import jdbc_application_coffeeProject.service.ProductService;

public class CoffeeViewJF extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JButton btnSaleRank;
	private JButton btnInsert;
	private JButton btnMarginRank;
	private SaleRankFrame frame = null;
	private MaringRankFrame marginframe =null;
	private ProductService proService;
	private ProdcutCodeService proCodeService;
	private ProductContent pTextField;
	private JPanel pBtn;

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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 462, 454);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		pTextField = new ProductContent();
		contentPane.add(pTextField, BorderLayout.CENTER);
	
		pBtn = new JPanel();
		contentPane.add(pBtn, BorderLayout.SOUTH);
		pBtn.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		btnInsert = new JButton("입력");
		btnInsert.addActionListener(this);
		pBtn.add(btnInsert);
		
		btnSaleRank = new JButton("판매금액순위");
		btnSaleRank.addActionListener(this);
		pBtn.add(btnSaleRank);
		
		btnMarginRank = new JButton("마진금액순위");
		btnMarginRank.addActionListener(this);
		pBtn.add(btnMarginRank);
		
		proService = new ProductService();
		proCodeService = new ProdcutCodeService();
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnMarginRank) {
			
			if(marginframe==null){
				marginframe = new MaringRankFrame();
			}
			marginframe.loadData();
			marginframe.setVisible(true);
		}
		if (e.getSource() == btnInsert) {
			
			try {
				pTextField.isEmptyCheck();
				pTextField.confirmItem();
				pTextField.requestFocus();
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, e1.getMessage());
				return;
			}
			
			
			proService.insertContent(pTextField.getContent());
			
			pTextField.clear();
		}
		if (e.getSource() == btnSaleRank) {
			
			if(frame==null){
				frame = new SaleRankFrame();	
			}
			frame.loadData();
			frame.setVisible(true);
		}
	}
	
}

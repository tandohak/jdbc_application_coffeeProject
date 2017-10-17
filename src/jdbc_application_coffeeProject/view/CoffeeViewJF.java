package jdbc_application_coffeeProject.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import jdbc_application_coffeeProject.content.ProductContent;

public class CoffeeViewJF extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JButton btnSaleRank;
	private JButton btnInsert;
	private JButton btnMarginRank;
	private SaleRankFrame frame = null;
	private MaringRankFrame marginframe =null;


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
		
		ProductContent panel = new ProductContent();
		contentPane.add(panel, BorderLayout.CENTER);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.SOUTH);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		btnInsert = new JButton("입력");
		btnInsert.addActionListener(this);
		panel_1.add(btnInsert);
		
		btnSaleRank = new JButton("판매금액순위");
		btnSaleRank.addActionListener(this);
		panel_1.add(btnSaleRank);
		
		btnMarginRank = new JButton("마진금액순위");
		btnMarginRank.addActionListener(this);
		panel_1.add(btnMarginRank);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnMarginRank) {
			
			if(marginframe==null){
				marginframe = new MaringRankFrame();
			}
			marginframe.setVisible(true);
		}
		if (e.getSource() == btnInsert) {
			
		}
		if (e.getSource() == btnSaleRank) {
			
			if(frame==null){
				frame = new SaleRankFrame();			
			}
			frame.setVisible(true);
		}
	}
	
}

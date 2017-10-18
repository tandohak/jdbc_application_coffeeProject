package jdbc_application_coffeeProject.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import jdbc_application_coffeeProject.list.CoffeeReportRankList;
import javax.swing.JLabel;

public class SaleRankFrame extends JFrame {

	private JPanel contentPane;
	private CoffeeReportRankList pRank;

	public SaleRankFrame() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 678, 424);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		
		JLabel label = new JLabel("판 매 금 액 순 위");
		panel.add(label);
		
		pRank = new CoffeeReportRankList(false);
		contentPane.add(pRank, BorderLayout.CENTER);
		
		
	}
	
	public void loadData(){
		pRank.loadData(false);
	}
}

package jdbc_application_coffeeProject.common;

import java.awt.GridLayout;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class TextFiledComponent extends JPanel {
	private JTextField textField;

	public TextFiledComponent(String title) {
		setLayout(new GridLayout(1, 0, 10, 0));
		
		JLabel lblTitle = new JLabel(title);
		lblTitle.setHorizontalAlignment(SwingConstants.RIGHT);
		add(lblTitle);
		
		textField = new JTextField();
		add(textField);
		textField.setColumns(10);
	}
	
	public String getTextValue(){		
		return textField.getText();
	}
	
	public void setTextValue(String value){
		textField.setText(value);
	}

	public JTextField getTextField() {
		return textField;
	}
	
	public void isEmptyCheck() throws Exception{
		if(getTextValue().equals("")){
			textField.requestFocus();
			throw new Exception("공백 존재");
		}
	}

	public void confirmItem(Matcher m,int length) throws Exception{
		if(!m.find()){
			textField.requestFocus();
			throw new Exception(length + "자리 이내의 정수로 입력하세요.");
		}
	}

}

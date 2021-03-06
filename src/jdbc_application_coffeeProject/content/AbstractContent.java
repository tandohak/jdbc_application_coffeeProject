package jdbc_application_coffeeProject.content;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public abstract class AbstractContent<T> extends JPanel{
	
	
	public abstract T getContent();
	
	public abstract void setContent(T item);
	
	public abstract void clear();
	
	public abstract void isEmptyCheck() throws Exception;
	
	public abstract void setEnabled(boolean isOk);
	
	public abstract void confirmItem() throws Exception;
}

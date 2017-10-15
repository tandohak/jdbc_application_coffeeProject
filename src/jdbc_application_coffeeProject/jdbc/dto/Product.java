package jdbc_application_coffeeProject.jdbc.dto;

public class Product {
	private ProductCode proCode;
	private int price;
	private int sale;
	private int margin;
	
	
	
	public Product(ProductCode proCode) {
		this.proCode = proCode;
	}

	public Product(ProductCode proCode, int price, int sale, int margin) {
		super();
		this.proCode = proCode;
		this.price = price;
		this.sale = sale;
		this.margin = margin;
	}
	
	public ProductCode getProCode() {
		return proCode;
	}
	public void setProCode(ProductCode proCode) {
		this.proCode = proCode;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getSale() {
		return sale;
	}
	public void setSale(int sale) {
		this.sale = sale;
	}
	public int getMargin() {
		return margin;
	}
	public void setMargin(int margin) {
		this.margin = margin;
	}

	@Override
	public String toString() {
		return String.format("%s,%s, %s, %s]", proCode, price, sale, margin);
	}
	
	
}

package jdbc_application_coffeeProject.dto;

public class CoffeeReport {
	private ProductCode proCode;
	private int priceSum; 	//총판매액
	private int surtax;		//부가세액
	private int supply;		//공급가액
	private int marginPrice;//마진액 
	
	
	
	public CoffeeReport(ProductCode proCode) {
		this.proCode = proCode;
	}
	
	public CoffeeReport(ProductCode proCode, int priceSum, int surtax, int supply, int marginPrice) {
		this.proCode = proCode;
		this.priceSum = priceSum;
		this.surtax = surtax;
		this.supply = supply;
		this.marginPrice = marginPrice;
	}

	public ProductCode getProCode() {
		return proCode;
	}

	public void setProCode(ProductCode proCode) {
		this.proCode = proCode;
	}

	public int getPriceSum() {
		return priceSum;
	}

	public void setPriceSum(int priceSum) {
		this.priceSum = priceSum;
	}

	public int getSurtax() {
		return surtax;
	}

	public void setSurtax(int surtax) {
		this.surtax = surtax;
	}

	public int getSupply() {
		return supply;
	}

	public void setSupply(int supply) {
		this.supply = supply;
	}

	public int getMarginPrice() {
		return marginPrice;
	}

	public void setMarginPrice(int marginPrice) {
		this.marginPrice = marginPrice;
	}

	@Override
	public String toString() {
		return String.format("%s,%s, %s, %s, %s]", proCode,
				priceSum, surtax, supply, marginPrice);
	}
	
	
	
}

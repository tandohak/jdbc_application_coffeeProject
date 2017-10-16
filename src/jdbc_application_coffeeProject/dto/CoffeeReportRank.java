package jdbc_application_coffeeProject.dto;

public class CoffeeReportRank {
	private int rank;
	private ProductCode proCode;
	private String proName;
	private int price;
	private int sale;
	private int priceSum;
	private int surtax;
	private int supply;
	private int marginPrice;

	public CoffeeReportRank(int rank, ProductCode proCode, String proName, int price, int sale, int priceSum,
			int surtax, int supply, int marginPrice) {
		this.rank = rank;
		this.proCode = proCode;
		this.proName = proName;
		this.price = price;
		this.sale = sale;
		this.priceSum = priceSum;
		this.surtax = surtax;
		this.supply = supply;
		this.marginPrice = marginPrice;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public ProductCode getProCode() {
		return proCode;
	}

	public void setProCode(ProductCode proCode) {
		this.proCode = proCode;
	}

	public String getProName() {
		return proName;
	}

	public void setProName(String proName) {
		this.proName = proName;
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

	
}

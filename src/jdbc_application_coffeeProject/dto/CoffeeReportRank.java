package jdbc_application_coffeeProject.dto;

public class CoffeeReportRank {
	private String rank;
	private ProductCode proCode;
	private String proName;
	private String price;
	private String sale;
	private String priceSum;
	private String surtax;
	private String supply;
	private String margin;
	private String marginPrice;

	
	public CoffeeReportRank(String rank, ProductCode proCode, String proName, String price, String sale,
			String priceSum, String surtax, String supply, String margin, String marginPrice) {
		this.rank = rank;
		this.proCode = proCode;
		this.proName = proName;
		this.price = price;
		this.sale = sale;
		this.priceSum = priceSum;
		this.surtax = surtax;
		this.supply = supply;
		this.margin = margin;
		this.marginPrice = marginPrice;
	}

	
	
	public final String getRank() {
		return rank;
	}



	public final void setRank(String rank) {
		this.rank = rank;
	}



	public final ProductCode getProCode() {
		return proCode;
	}



	public final void setProCode(ProductCode proCode) {
		this.proCode = proCode;
	}



	public final String getProName() {
		return proName;
	}



	public final void setProName(String proName) {
		this.proName = proName;
	}



	public final String getPrice() {
		return price;
	}



	public final void setPrice(String price) {
		this.price = price;
	}



	public final String getSale() {
		return sale;
	}



	public final void setSale(String sale) {
		this.sale = sale;
	}



	public final String getPriceSum() {
		return priceSum;
	}



	public final void setPriceSum(String priceSum) {
		this.priceSum = priceSum;
	}



	public final String getSurtax() {
		return surtax;
	}



	public final void setSurtax(String surtax) {
		this.surtax = surtax;
	}



	public final String getSupply() {
		return supply;
	}



	public final void setSupply(String supply) {
		this.supply = supply;
	}



	public final String getMargin() {
		return margin;
	}



	public final void setMargin(String margin) {
		this.margin = margin;
	}



	public final String getMarginPrice() {
		return marginPrice;
	}



	public final void setMarginPrice(String marginPrice) {
		this.marginPrice = marginPrice;
	}



	public Object[] toArray(){
		return new Object[]{rank, proCode.getProducCode(), proName, price, sale, priceSum, surtax, supply, margin, marginPrice};
	}
	
	@Override
	public String toString() {
		return String.format(
				"%s,%s,%s, %s,%s, %s, %s, %s, %s %s",
				rank, proCode.getProducCode(), proName, price, sale, priceSum, surtax, supply,margin, marginPrice);
	}	

	
}

package jdbc_application_coffeeProject.dto;

public class ProductCode {
	private String producCode;
	private String producName;
	
	public ProductCode(String producCode) {
		this.producCode = producCode;
	}

	public ProductCode(String producCode, String producName) {
		this.producCode = producCode;
		this.producName = producName;
	}
	
	public String getProducCode() {
		return producCode;
	}
	public void setProducCode(String producCode) {
		this.producCode = producCode;
	}
	public String getProducName() {
		return producName;
	}
	public void setProducName(String producName) {
		this.producName = producName;
	}

	@Override
	public String toString() {
		return String.format("%s(%s)",  producName,producCode);
	}	
	
	public Object[] toArray(){
		return new Object[]{producCode,producName};
	}
	
	
}

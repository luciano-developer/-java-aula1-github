package heranca2Entities;

public class ImportedProduct extends Product {

	private Double customFee;
	
	public Double getCustomFee() {
		return customFee;
	}

	public void setCustomFee(Double customFee) {
		this.customFee = customFee;
	}

	public ImportedProduct() {
		// TODO Auto-generated constructor stub
	}

	public ImportedProduct(String name, Double price, Double customFee) {
		super(name, price);
		this.customFee = customFee;
	}

	@Override
	public String priceTag() {
		return name.toUpperCase() + " " + String.format("%.2f",totalPrice()) + " Taxa: " + String.format("%,2f",customFee);
	}

	public Double totalPrice() {
		return price + customFee;
	}
}

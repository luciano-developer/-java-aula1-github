package orderEntities;

public class OrderItem {
	private Integer quantity;
	private Double price;

	private Product product = new Product();
	
	public OrderItem() {

	}

	public OrderItem(Integer quantity, Double price, Product product) {
		this.quantity = quantity;
		this.price = price;
		this.product = product;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
	
	public Product getProduct() {
		return product;
	}

	public Double subTotal() {
		return price * quantity;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(getProduct().toString());
		builder.append(",");
		builder.append(String.format("%.2f",price));
		builder.append(",");
		builder.append(quantity);
		builder.append(",");
		builder.append("Subtotal: ");
		builder.append(String.format("%.2f", subTotal()));
		return builder.toString();
	}
	
	
}
package heranca2Entities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class UsedProduct extends Product {

	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	private Date manufacturedDate;
	
	public Date getManufacturedDate() {
		return manufacturedDate;
	}

	public void setManufacturedDate(Date manufacturedDate) {
		this.manufacturedDate = manufacturedDate;
	}

	public UsedProduct() {
		// TODO Auto-generated constructor stub
	}

	public UsedProduct(String name, Double price, Date manufacturedDate) {
		super(name, price);
		this.manufacturedDate = manufacturedDate;
	}

	@Override
	public String priceTag() {
		return name.toUpperCase() + " (used) " + String.format("%.2f", price) + "(Data de fabricacao: "+sdf.format(manufacturedDate)+")";
	}
	
}

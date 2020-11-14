package heranca3Entities;

import heranca3Entities.enums.Color;

public class Retangle extends Shape {

	private Double width;
	private Double heigth;
	
	public Retangle() {
		super();
	}

	public Double getWidth() {
		return width;
	}

	public void setWidth(Double width) {
		this.width = width;
	}

	public Double getHeigth() {
		return heigth;
	}

	public void setHeigth(Double heigth) {
		this.heigth = heigth;
	}

	public Retangle(Color color, Double width, Double heigth) {
		super(color);
		this.width = width;
		this.heigth = heigth;
	}

	@Override
	public Double area() {
		return width * heigth;
	}

}

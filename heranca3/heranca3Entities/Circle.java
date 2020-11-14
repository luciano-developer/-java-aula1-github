package heranca3Entities;

import heranca3Entities.enums.Color;

public class Circle extends Shape {

	private Double radius;
	
	public Double getRadius() {
		return radius;
	}

	public void setRadius(Double radius) {
		this.radius = radius;
	}

	public Circle(Color color, Double radius) {
		super(color);
		this.radius = radius;
	}

	public Circle() {
		super();
	}

	@Override
	public Double area() {
		return Math.PI * radius * radius;
	}

}

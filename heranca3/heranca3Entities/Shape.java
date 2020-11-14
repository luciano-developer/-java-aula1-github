package heranca3Entities;

import heranca3Entities.enums.Color;

public abstract class Shape {
	private Color color;

	public Shape() {
		
	}
	
	public Shape(Color color) {
		this.color = color;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public abstract Double area();
}

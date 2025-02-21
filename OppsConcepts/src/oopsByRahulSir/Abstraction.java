package oopsByRahulSir;

abstract class Shape {

	 String color;

	// thease are abstract method
	abstract double area();

	public abstract String toString();

	// abstract class can have the constructor

	public Shape(String color) {
		System.out.println("shape constructor called ");
		this.color = color;
	}

	// this is concrete method
	public String getColor() {
		return color;
	}

}

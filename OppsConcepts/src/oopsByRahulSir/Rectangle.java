package oopsByRahulSir;

public class Rectangle extends Shawpe {

	double length;
	 double width;

	 public Rectangle(String color, double length,double width)
	 {
	     // calling Rectangle constructor
	     super(color);
	     System.out.println("Rectangle constructor called");
	     this.length = length;
	     this.width = width;
	 }

	 @Override 
	 double area() {
		 return length * width;
		 }

	 @Override
	 public String toString()
	 {
	     return "Rectangle color is " + super.getColor()
	         + "and area is : " + area();
	 }

}

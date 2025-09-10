package application;
import java.text.DecimalFormat;
import javafx.scene.Node;
/*
 * Elizabeth Bloss
 * UMGC CMSC 335: Object Oriented and Concurrent Programming
 * November 2024
 * Project 2
 * 
 * This class defines a circle.  It extends two dimensional, which extends shape.
 * Methods to calculate the area and display the area are included
 * There is also a method to return the shape display as a node.
 */
public class Circle extends TwoDimensional {
	
	private double radius;
	
	//constructor for a circle with designated radius
	public Circle(double radius) {
		this.radius = radius;
	}
	
	//method to calculate the area of a circle
	public double calculateArea() {
		// Area = PI r^2
		area = Math.PI * Math.pow(radius, 2);
		return area;
	}
	
	// method to display information to console
	// result will be formatted to two decimal places
	public String displayInfo() {
		double result = calculateArea();
		DecimalFormat df = new DecimalFormat("#.##");
		return (super.displayInfo() + "circle is " + (df.format(result)));		
	}
	
	@Override 
	public String toString() {
		return "circle";
	}
	
	// method to draw the circle as a node
	@Override
	public Node showShape() {
		javafx.scene.shape.Circle circle = 
				new javafx.scene.shape.Circle(radius);
		shapeImage = circle;
		return shapeImage;
	}
}

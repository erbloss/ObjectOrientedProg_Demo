package application;
import java.text.DecimalFormat;
import javafx.scene.Node;
/*
 * Elizabeth Bloss
 * UMGC CMSC 335: Object Oriented and Concurrent Programming
 * November 2024
 * Project 2
 * 
 * This class defines a rectangle.  It extends two dimensional, which extends shape.
 * Methods to calculate the area and display the area are included
 * There is also a method to return the shape display as a node.
 */
public class Rectangle extends TwoDimensional {
	
	private double base;
	private double height;
	
	//constructor for a rectangle with designated base and height 
	public Rectangle(double base, double height) {
		this.base = base;
		this.height = height;
	}
		
	//method to calculate the area of a rectangle
	public double calculateArea() {
		// Area = b * h
		area = base * height;
		return area;
	}
		
	// method to display information to console
	// result will be formatted to two decimal places
	public String displayInfo() {
		double result = calculateArea();
		DecimalFormat df = new DecimalFormat("#.##");
		return (super.displayInfo() + "rectangle is " + (df.format(result)));		
	}
	
	@Override 
	public String toString() {
		return "rectangle";
	}
	@Override
	public Node showShape() {
		javafx.scene.shape.Rectangle rectangle = 
				new javafx.scene.shape.Rectangle(base, height);
		shapeImage = rectangle;
		return shapeImage;
	}
}

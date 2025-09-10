package application;
import java.text.DecimalFormat;
import javafx.scene.Node;
/*
 * Elizabeth Bloss
 * UMGC CMSC 335: Object Oriented and Concurrent Programming
 * November 2024
 * Project 2
 * 
 * This class defines a squar.  It extends two dimensional, which extends shape.
 * Methods to calculate the area and display the area are included
 * There is also a method to return the shape display as a node.
 */
public class Square extends TwoDimensional {

	private double side;
	
	//constructor for a square with designated side length
	public Square(double side) {
		this.side = side;
	}
		
	//method to calculate the area of a square
	public double calculateArea() {
		// Area = side^2
		area = Math.pow(side, 2) ;
		return area;
	}
		
	// method to display information to console
	// result will be formatted to two decimal places
	public String displayInfo() {
		double result = calculateArea();
		DecimalFormat df = new DecimalFormat("#.##");
		return (super.displayInfo() + "square is " + (df.format(result)));		
	}
	
	@Override 
	public String toString() {
		return "square";
	}
	@Override
	public Node showShape() {
		javafx.scene.shape.Rectangle square = 
				new javafx.scene.shape.Rectangle(side, side);
		shapeImage = square;
		return shapeImage;
	}
}

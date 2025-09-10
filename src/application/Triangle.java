package application;

import javafx.scene.shape.Polygon;
import java.text.DecimalFormat;
import javafx.scene.Node;

/*
 * Elizabeth Bloss
 * UMGC CMSC 335: Object Oriented and Concurrent Programming
 * November 2024
 * Project 2
 * 
 * This class defines a triangle.  It extends two dimensional, which extends shape.
 * Methods to calculate the area and display the area are included
 * There is also a method to return the shape display as a node.
 */

public class Triangle extends TwoDimensional {
	
	private double base;
	private double height;
	
	// constructor for a triangle with designated base and height
	public Triangle(double base, double height) {
		this.base = base;
		this.height = height;
	}
	//method to calculate the area of a triangle
	public double calculateArea() {
		// Area = 1/2 b * h
		area = (base * height)/2;
		return area;
	}
			
	// method to display information to console
	// result will be formatted to two decimal places
	public String displayInfo() {
		double result = calculateArea();
		DecimalFormat df = new DecimalFormat("#.##");
		return (super.displayInfo() + "triangle is " + (df.format(result)));		
	}
	@Override 
	public String toString() {
		return "triangle";
	}
	@Override
	public Node showShape() {
		Polygon triangle = new Polygon(base/2, 0, 0, height, base, height);
		// displays an isosceles triangle based on height and base info
		shapeImage = triangle;
		return shapeImage;
		
	}
}

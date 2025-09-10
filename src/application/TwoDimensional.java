package application;
/*
 * Elizabeth Bloss
 * UMGC CMSC 335: Object Oriented and Concurrent Programming
 * November 2024
 * Project 2
 * 
 * This class defines a two dimensional shape. It extends the shape class.
 * A two dimensional shape is defined by its area.
 */

import javafx.scene.Node;

public class TwoDimensional extends Shape {

	double area;

	public TwoDimensional() {
		super.numDimensions = 2;
	}
	
	public double calculateArea() {
		return area;
	}
	
	public String displayInfo() {
		return ("The area of the ");
	}

	@Override
	public Node showShape() {
		return shapeImage;
	}
}

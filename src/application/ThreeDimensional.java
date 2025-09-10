package application;

import javafx.scene.Node;

/*
 * Elizabeth Bloss
 * UMGC CMSC 335: Object Oriented and Concurrent Programming
 * November 2024
 * Project 2
 * 
 * This class defines a three dimensional shape. It extends the shape class.
 * A three dimensional shape is defined by its volume.
 */

public class ThreeDimensional extends Shape {

	double volume;
	
	public ThreeDimensional() {
		super.numDimensions = 3;
	}
	
	public double calculateVolume() {
		return volume;
	}
	
	public String displayInfo() {
		return ("The volume of the ");
	}

	@Override
	public Node showShape() {
		return shapeImage;
	}
		
}

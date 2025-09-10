package application;

import javafx.scene.Node;

/*
 * Elizabeth Bloss
 * UMGC CMSC 335: Object Oriented and Concurrent Programming
 * November 2024
 * Project 2
 * 
 * This class defines a shape.  It is an abstract class with the abstract method to 
 * display the information associated with a shape.
 */

public abstract class Shape {
	int numDimensions;
	Node shapeImage; 
	
	/** prints the shape's information to console */
	abstract String displayInfo();
	
	/** creates node of the shape to add to a pane */
	abstract Node showShape();	

}

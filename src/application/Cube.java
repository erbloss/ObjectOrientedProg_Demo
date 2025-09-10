package application;

import java.text.DecimalFormat;

import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
/*
 * Elizabeth Bloss
 * UMGC CMSC 335: Object Oriented and Concurrent Programming
 * November 2024
 * Project 2
 * 
 * This class defines a cube.  It extends three dimensional, which extends shape.
 * Methods to calculate the area and display the area are included
 * There is also a method to return the shape's image from the
 * included icon_images folder as a node.
 */
public class Cube extends ThreeDimensional {
	
	private double sideLength;
	
	//constructor for cube with sideLength parameter
	public Cube(double sideLength) {
		this.sideLength = sideLength;
		
	}
	
	//method to calculate the volume of a cube
	public double calculateVolume() {
		// Volume = sideLength ^3
		volume = Math.pow(sideLength, 3);
		return volume;
	}
	
	// method to display information to console
	// result will be formatted to two decimal places
	public String displayInfo() {
		double result = calculateVolume();
		DecimalFormat df = new DecimalFormat("#.##");
		return (super.displayInfo() + "cube is " + (df.format(result)));		
	}
	@Override 
	public String toString() {
		return "cube";
	}
	@Override
	public Node showShape() {
		// set shapeImage to be the image torus.jpg
		Image img = new Image("cube.png");
		ImageView iv = new ImageView(img);
		iv.setScaleX(3);
		iv.setScaleY(3);
		shapeImage = iv;
		return shapeImage;
	}
}
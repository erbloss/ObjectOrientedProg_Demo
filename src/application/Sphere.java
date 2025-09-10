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
 * This class defines a sphere.  It extends three dimensional, which extends shape.
 * Methods to calculate the area and display the area are included
 * There is also a method to return the shape's image from the
 * included icon_images folder as a node.
 */

public class Sphere extends ThreeDimensional {

	private double radius;
	
	//constructor for sphere with radius parameter
	public Sphere(double radius) {
		this.radius = radius;
		
	}
	
	//method to calculate the volume of a sphere
	public double calculateVolume() {
		// volume = 4/3 PI r ^3
		volume = (4* Math.PI * Math.pow(radius, 3))/3;
		return volume;
	}
	
	// method to display information to console
	// result will be formatted to two decimal places
	public String displayInfo() {
		double result = calculateVolume();
		DecimalFormat df = new DecimalFormat("#.##");
		return (super.displayInfo() + "sphere is " + (df.format(result)));		
	}
	
	@Override 
	public String toString() {
		return "sphere";
	}
	@Override
	public Node showShape() {
		// set shapeImage to be the image torus.jpg
		Image img = new Image("sphere.jpg");
		ImageView iv = new ImageView(img);
		iv.setScaleX(3);
		iv.setScaleY(3);
		shapeImage = iv;
		return shapeImage;
	}
	
	
}

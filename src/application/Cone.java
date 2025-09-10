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
 * This class defines a cone.  It extends three dimensional, which extends shape.
 * Methods to calculate the area and display the area are included
 * There is also a method to return the shape's image from the
 * included icon_images folder as a node.
 */

public class Cone extends ThreeDimensional {
	
	private double radius;
	private double height;
	
	//constructor for cone with radius and height parameters
	public Cone(double radius, double height) {
		this.radius = radius;
		this.height = height;
	}
		
	//method to calculate the volume of a cone
	public double calculateVolume() {
		// Volume = 1/3 PI r^2 h
		volume = (Math.PI * Math.pow(radius, 2) *  height)/3;
		return volume;
	}
		
	// method to display information to console
	// result will be formatted to two decimal places
	public String displayInfo() {
		double result = calculateVolume();
		DecimalFormat df = new DecimalFormat("#.##");
		return (super.displayInfo() + "cone is " + (df.format(result)));		
	}
	
	@Override 
	public String toString() {
		return "cone";
	}
	@Override
	public Node showShape() {
		// set shapeImage to be the image torus.jpg
		Image img = new Image("cone.jpg");
		ImageView iv = new ImageView(img);
		iv.setScaleX(3);
		iv.setScaleY(3);
		shapeImage = iv;
		return shapeImage;
	}


}

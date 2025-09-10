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
 * This class defines a torus.  It extends three dimensional, which extends shape.
 * Methods to calculate the area and display the area are included
 * There is also a method to return the shape's image from the
 * included icon_images folder as a node.
 */

public class Torus extends ThreeDimensional {
	
	private double minorRadius;
	private double majorRadius;
	
	//public constructor using major and minor radius parameters
	public Torus(double majorRadius, double minorRadius) {
		this.minorRadius = minorRadius;
		this.majorRadius = majorRadius;
	}
	
	//method to calculate the volume of a torus
	public double calculateVolume() {
		// Volume = (pi r^2)(2 pi R)
		volume = (Math.PI) * (Math.pow(minorRadius, 2))*(2 * Math.PI) * majorRadius;
		return volume;
	}
		
	// method to display information to console
	// result will be formatted to two decimal places
	public String displayInfo() {
		double result = calculateVolume();
		DecimalFormat df = new DecimalFormat("#.##");
		return (super.displayInfo() + "torus is " + (df.format(result)));		
	}

	@Override 
	public String toString() {
		return "torus";
	}
	@Override
	public Node showShape() {
		// set shapeImage to be the image torus.jpg
		Image img = new Image("torus.jpg");
		ImageView iv = new ImageView(img);
		iv.setScaleX(3);
		iv.setScaleY(3);
		shapeImage = iv;
		return shapeImage;
	}
}

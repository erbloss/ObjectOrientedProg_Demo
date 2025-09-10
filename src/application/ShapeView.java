package application;
import javafx.scene.Group;
import javafx.scene.layout.BorderPane;
/*
 * Elizabeth Bloss
 * UMGC CMSC 335: Object Oriented and Concurrent Programming
 * November 2024
 * Project 2
 * 
 * This class defines ShapeView which extends BorderPane.  It has a constructor
 * to create a pane with a shape object image at the center.
 */
public class ShapeView extends BorderPane {
	private Shape shape;
	private Group group = new Group();
	
	public ShapeView(Shape shape) {
		this.shape = shape;
		this.setCenter(group);
		addShapeToPane(); // invoke method to draw shape 
	}
	
	private void addShapeToPane() {
		group.getChildren().clear(); // clear group for new shape
						// showShape implemented within each specific shape
		group.getChildren().add(shape.showShape());
	}
	
}

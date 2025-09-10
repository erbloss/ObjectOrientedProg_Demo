package application;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
/*
 * Elizabeth Bloss
 * UMGC CMSC 335: Object Oriented and Concurrent Programming
 * November 2024
 * Project 2
 * 
 * This class defines the main GUI application. It displays a window
 * that prompts the user to select a shape from a group of images. 
 * It then prompts the user for appropriate dimensions so that a shape
 * will be displayed in a new window accordingly.  There are checks in
 * place so that the user must enter only numeric data for values, and 
 * that there must be a shape selected in order to display a new window.
 */

public class Main extends Application {
	
	final TextField input1 = new TextField();
	final TextField input2 = new TextField();
	
	@Override
	public void start(Stage primaryStage) {
		try {
			primaryStage.setTitle("Shape Application");
			
			// create grid pane layout for GUI
			GridPane grid = new GridPane();
			grid.setAlignment(Pos.CENTER);
			grid.setHgap(10);
			grid.setVgap(10);
			grid.setPadding(new Insets(15,15,15,15));
			Scene scene1 = new Scene(grid, 550, 375);
			grid.setStyle("-fx-background-color: white;");
			
			// add text to prompt/guide user
			Text headerPrompt = new Text("Select a shape to display:");			
			Text reqPrompt = new Text("Enter appropriate dimensions (If N/A, please enter 0): ");
			Text reqValues = new Text();   // to display required value types
			Text result = new Text();	   // to display any error message or what shape is successfully created
			Font font = Font.font("Arial", FontWeight.BOLD, 14);
			// set text styles 
			headerPrompt.setFont(font);
			reqPrompt.setFont(font);
			result.setFont(font);
			headerPrompt.setFill(Color.CORNFLOWERBLUE);
			reqPrompt.setFill(Color.CORNFLOWERBLUE);
			result.setFill(Color.CRIMSON);
			// add text to grid
			grid.add(headerPrompt, 0, 0);  
			grid.add(reqPrompt, 0, 4);
			grid.add(reqValues, 0, 5);
			grid.add(result, 0, 9);
			
			//add radio buttons for shape options
			RadioButton circleRB = new RadioButton();
			RadioButton squareRB = new RadioButton();
			RadioButton triangleRB = new RadioButton();
			RadioButton rectangleRB = new RadioButton();
			RadioButton sphereRB = new RadioButton();
			RadioButton cubeRB = new RadioButton();
			RadioButton coneRB = new RadioButton();
			RadioButton cylinderRB = new RadioButton();
			RadioButton torusRB = new RadioButton();
			
			// set images for radio buttons
			circleRB.setGraphic(new ImageView(new Image("circle.png")));
			squareRB.setGraphic(new ImageView(new Image("square.png")));
			triangleRB.setGraphic(new ImageView(new Image("triangle.jpg")));
			rectangleRB.setGraphic(new ImageView(new Image("rectangle.png")));
			sphereRB.setGraphic(new ImageView(new Image("sphere.jpg")));
			cubeRB.setGraphic(new ImageView(new Image("cube.png")));
			coneRB.setGraphic(new ImageView(new Image("cone.jpg")));
			cylinderRB.setGraphic(new ImageView(new Image("cylinder.jpg")));
			torusRB.setGraphic(new ImageView(new Image("torus.jpg")));
			
		
			// add all shapes as toggle group so only 1 may be selected
			final ToggleGroup shapeGroup = new ToggleGroup();
			circleRB.setToggleGroup(shapeGroup);
			squareRB.setToggleGroup(shapeGroup);
			triangleRB.setToggleGroup(shapeGroup);
			rectangleRB.setToggleGroup(shapeGroup);
			sphereRB.setToggleGroup(shapeGroup);
			cubeRB.setToggleGroup(shapeGroup);
			coneRB.setToggleGroup(shapeGroup);
			cylinderRB.setToggleGroup(shapeGroup);
			torusRB.setToggleGroup(shapeGroup);
			
			// set user data so that toggle selection may be easily determined
			circleRB.setUserData("circle");
			squareRB.setUserData("square");
			triangleRB.setUserData("triangle");
			rectangleRB.setUserData("rectangle");
			sphereRB.setUserData("sphere");
			cubeRB.setUserData("cube");
			coneRB.setUserData("cone");
			cylinderRB.setUserData("cylinder");
			torusRB.setUserData("torus");
			
			// add two-dimensional radio buttons in hbox
			HBox hb2D = new HBox(30);
			hb2D.setAlignment(Pos.TOP_CENTER);
			hb2D.getChildren().addAll(circleRB, squareRB, triangleRB, rectangleRB);
			grid.add(hb2D, 0, 1);
			
			// add three-dimensional radio buttons in another hbox
			HBox hb3D = new HBox(20);
			hb3D.setAlignment(Pos.TOP_CENTER);
			hb3D.getChildren().addAll(sphereRB, cubeRB, coneRB, cylinderRB, torusRB);
			grid.add(hb3D, 0, 2);
			
			// add button to display shape
			Button displayButton = new Button("Display Shape");
			displayButton.setDisable(true);  // initially disables the button
			displayButton.setPrefWidth(400);
			grid.add(displayButton, 0, 8);	
			
			// user input text field 1 setup and validation
			Text label1 = new Text("Value 1: ");
			input1.setTooltip(new Tooltip("Enter numeric value here"));
			input1.setAlignment(Pos.BASELINE_RIGHT);
			input1.setMaxWidth(100);
			input1.focusedProperty().addListener((arg0, oldValue, newValue) ->{
				if(!newValue) {
					// check for valid numeric input
					if(!input1.getText().matches("\\d+(\\.\\d+)?")) { 
						input1.setText("");
					}
					// check that field has value to enable display button
				} checkToEnable(input1, input2, displayButton);
			});
			// user input text field 2 setup and validation
			Text label2 = new Text("Value 2: ");
			input2.setTooltip(new Tooltip("Enter numeric value here"));
			input2.setAlignment(Pos.BASELINE_RIGHT);
			input2.setMaxWidth(100);
			input2.focusedProperty().addListener((arg0, oldValue, newValue) ->{
				if(!newValue) {
					// check for valid numeric input
					if(!input2.getText().matches("\\d+(\\.\\d+)?")) {
						input2.setText("");
					}
					// check that field has value to enable display button
				} checkToEnable(input1, input2, displayButton);
			});
			
			// add drop down fields for input type selection
			final ObservableList<String> options = FXCollections.observableArrayList(
					"Base", 			
					"Height",			
					"Radius",			
					"Side",				
					"Major Radius",		
					"Minor Radius",
					"N/A");	
			final ComboBox<String> cb1 = new ComboBox<String>(options);
			cb1.setTooltip(new Tooltip("Select first value type"));
				
			final ComboBox<String> cb2 = new ComboBox<String>(options);
			cb2.setTooltip(new Tooltip("Select second value type"));
			
			// create h boxes for input field and data type option
			HBox hb1 = new HBox(10);
			hb1.setAlignment(Pos.CENTER);
			hb1.getChildren().addAll(label1, input1, cb1);
			HBox hb2 = new HBox(10);
			hb2.setAlignment(Pos.CENTER);
			hb2.getChildren().addAll(label2, input2, cb2);
			grid.add(hb1, 0, 6);
			grid.add(hb2, 0, 7);
			
			// change value type in combo boxes based on radio button 
			// selected and the requirements for that shape
			// displays error message on GUI if wrong input
			circleRB.setOnAction(e ->{
				valueTypeError(reqValues, cb1, cb2, "Radius", "N/A");
			});
			squareRB.setOnAction(e ->{
				valueTypeError(reqValues, cb1, cb2, "Side", "N/A");
			});
			triangleRB.setOnAction(e ->{
				valueTypeError(reqValues, cb1, cb2, "Base", "Height");
			});
			rectangleRB.setOnAction(e ->{
				valueTypeError(reqValues, cb1, cb2, "Base", "Height");
			});
			sphereRB.setOnAction(e ->{
				valueTypeError(reqValues, cb1, cb2, "Radius", "N/A");
			});
			cubeRB.setOnAction(e ->{
				valueTypeError(reqValues, cb1, cb2, "Side", "N/A");
			});
			coneRB.setOnAction(e ->{
				valueTypeError(reqValues, cb1, cb2, "Radius", "Height");
			});
			cylinderRB.setOnAction(e ->{
				valueTypeError(reqValues, cb1, cb2, "Radius", "Height");
			});
			torusRB.setOnAction(e ->{
				valueTypeError(reqValues, cb1, cb2, "Major Radius", "Minor Radius");
			});
						
			// handle button event
			displayButton.setOnAction(e -> {
				// read in user input for data values and value types
				double userInput1 = Double.parseDouble(input1.getText());
				double userInput2 = Double.parseDouble(input2.getText());
				String valueType1 = cb1.getValue();
				String valueType2 = cb2.getValue();
				
				try{
					// get which shape has been selected from toggle group
					RadioButton selectedRB = (RadioButton) shapeGroup.getSelectedToggle(); 
					String selectedShape = selectedRB.getUserData().toString();
					
					// switch cases depending on which toggle was clicked for shape selection
					switch(selectedShape) {
					case "circle":	 	
						if(valueType1 == "Radius" && valueType2 == "N/A") { // check for required input
							Circle circleObj = new Circle(userInput1);		// create shape object
							displayShapeWindow(circleObj, result);			// show new window with shape object
						} else {
							result.setText("Check your selected value types");
						} break;
					case "square":		
						if(valueType1 == "Side" && valueType2 == "N/A") {
							Rectangle squareObj = new Rectangle(userInput1, userInput1);
							displayShapeWindow(squareObj, result);
						} else { 
							result.setText("Check your selected value types");
						} break;
					case "rectangle":  	
						if(valueType1 == "Base" && valueType2 == "Height") {
							Rectangle rectangleObj = new Rectangle(userInput1, userInput2);
							displayShapeWindow(rectangleObj, result);
						} else {
							result.setText("Check your selected value types");
						} break;
					case "triangle":	
						if(valueType1 == "Base" && valueType2 == "Height"){
							Triangle triangleObj = new Triangle(userInput1, userInput2);
							displayShapeWindow(triangleObj, result);
						} else {
							result.setText("Check your selected value types");
						} break;
					case "sphere":		
						if(valueType1 == "Radius" && valueType2 == "N/A") {
							Sphere sphereObj = new Sphere(userInput1);
							displayShapeWindow(sphereObj, result);
						} else {
							result.setText("Check your selected value types");
						} break;
					case "cube":		
						if(valueType1 == "Side" && valueType2 == "N/A") {
							Cube cubeObj = new Cube(userInput1);
							displayShapeWindow(cubeObj, result);
						} else {
							result.setText("Check your selected value types");
						} break;
					case "cone":		
						if(valueType1 == "Radius" && valueType2 == "Height"){
							Cone coneObj = new Cone(userInput1, userInput2);
							displayShapeWindow(coneObj, result);
						} break;
					case "cylinder":	
						if(valueType1 == "Radius" && valueType2 == "Height") {
							Cylinder cylinderObj = new Cylinder(userInput1, userInput2);
							displayShapeWindow(cylinderObj, result);
						} else {
							result.setText("Check your selected value types");
						} break;
					case "torus":		
						if(valueType1 == "Major Radius" && valueType2 == "Minor Radius"){
							if(userInput1 > userInput2) { // valid, major larger than minor
								Torus torusObj = new Torus(userInput1, userInput2);
								displayShapeWindow(torusObj, result);
							}
							else { // invalid, major must be larger than minor radius
								result.setFill(Color.CRIMSON);
								result.setText("Major Radius must be larger than minor radius");
							}
						} break;
					default: 
						result.setText("Please Make a Shape Selection");
						break;
					} // END SWITCH
				} catch (NullPointerException npe){
					// no shape has been selected from toggle group
					result.setText("Please Make a Shape Selection");
				}
			});
			// show main GUI
			primaryStage.setScene(scene1);
			primaryStage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	// main method 
	public static void main(String[] args) {
		launch(args);
	}
	
	//***********************************************************************
	// ADDITIONAL METHODS
	
	/* method to display shape in new window using ShapeView class 
	 * @param Shape shape: shape object to be shown
	 * @param Text text: the text area of the GUI to be modified based on result
	 */	
	private void displayShapeWindow(Shape shape, Text text) {
		// show resulting shape name on GUI
		text.setText("You have created a " + shape.toString()); 
		text.setFill(Color.CORNFLOWERBLUE);
		Stage shapeStage = new Stage();		  // set new stage for shape display
		shapeStage.setTitle("Your " + shape.toString());
		ShapeView sv = new ShapeView(shape);  // extends BorderPane
		Scene shapeScene = new Scene(sv, 600, 600);
		shapeStage.setScene(shapeScene);
		shapeStage.show();
	}
	
	/* method to activate a button once two text fields have values entered
	 * @param TextField tf1, TextField tf2: the text fields that are required to be filled
	 * @param Button button: the button that will be activated/deactivated accordingly 
	 */
	private void checkToEnable(TextField tf1, TextField tf2, Button button) {
		if(!tf1.getText().isEmpty() && !tf2.getText().isEmpty()) {
			button.setDisable(false); // activate button
		} else {
			button.setDisable(true); // button disabled when either text field empty
 		}
	}
	
	/* method to display which value types are required for the shape selected
	 * modifies the value in the combo boxes to represent the desired value
	 */
	private void valueTypeError(Text text, ComboBox<String> cb1, 
			ComboBox<String> cb2, String a, String b) {
		text.setText("This shape requires "
				+ "\t\tVALUE 1 = " + a.toUpperCase()+ "    VALUE 2 = " +b.toUpperCase());
		cb1.setValue(a);
		cb2.setValue(b);
	}
}

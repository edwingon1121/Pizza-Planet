/**
 * 
 */
package View;

import Controller.MainController;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;


/**
 * @author Edwin Gonzalez
 * ITP 368, Fall 2018
 * Final Project
 * edwingon@usc.edu
 */
public class StartView  {
	
	private MainController controller;
	private Scene scene;

	//UI Elements with the start scene
	private BorderPane root;
	private ImageView logo;
	private HBox hbox;
	private Button instructions;
	private Button start;
	private Button leaderboard;
	
	public StartView(MainController controller) {
		this.controller = controller;
		
		root = new BorderPane();
		logo = new ImageView();
		hbox = new HBox(100);
		instructions = new Button("INSTRUCTIONS");
		start = new Button("START");
		leaderboard = new Button("LEADERBOARD");
		
		setUpPane();
		styleElements();
		setUpEvents();
		
		scene = new Scene(root, 1000, 570);
	}
	
	//Initializing UI components  
	public void setUpPane() {
		
		Image img = new Image("assets/pizzaPlanetLogo.png");
		Image bg = new Image("assets/backgroundImages/alienCapture.jpg");
		
		logo.setImage(img);

		hbox.getChildren().addAll(instructions, start, leaderboard);		
		root.setTop(logo);
	    root.setStyle("-fx-background-image:  url('"+ bg.getUrl() +"');");
	   
	}
	
	//Styling  UI elements
	public void styleElements() {
		
		hbox.setPadding(new Insets(0,0,32,0));
		start.setStyle("-fx-color: Red; -fx-font-size: 32px"); 
		instructions.setStyle("-fx-color: Red; -fx-font-size: 32px");
		leaderboard.setStyle("-fx-color: Red; -fx-font-size: 32px");
		
		 root.setBottom(hbox);
		 hbox.setAlignment(Pos.CENTER);
	}
	
	//Set up action listeners
	public void setUpEvents() {
			
		//Add listeners to handle toggling between scenes (using lambda expression)
		instructions.setOnAction(ae -> controller.showInstruction());
		start.setOnAction(ae -> controller.showGameScene());		
		leaderboard.setOnAction(ae -> controller.showLeaderBoardScene());

	  
	}
		
	 public Scene getScene() {
		 return scene;
	 }
	
}

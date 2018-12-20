/**
 * 
 */
package View;

import Controller.MainController;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

/**
 * @author Edwin Gonzalez
 * ITP 368, Fall 2018
 * Final Project
 * edwingon@usc.edu
 */
public class InstructionView {
	
	private MainController controller;
	private Scene scene;
	
	//Create layout for the Scene
	private BorderPane root;
	private HBox hbox;
	private Button back;
	private VBox vbox;
	private Label info;
	private Text title;
	
	private HBox arrowBox;
	private ImageView arrowL;
	private Label lT;
	private ImageView arrowR;
	private Label rT;
	private ImageView arrowD;
	private Label dT;
	
	public InstructionView(MainController controller) {
		this.controller = controller;
		
		root = new BorderPane();
		scene = new Scene(root,1000,570);
		hbox = new HBox();
		back = new Button("Back");
		vbox = new VBox(24);
		info = new Label();
		title = new Text("Objective:");
		
		setUpPane();
		styleElements();
		setUpEvents();
		
	}
	
	public void setUpPane() {
		
		Image bg = new Image("assets/backgroundImages/alienCaptureDark.jpg");
		 root.setStyle("-fx-background-image:  url('"+ bg.getUrl() +"');"); 
	

		info.setText("You are on a mission to collect the aliens before the allotted time runs out!\n\n "
				+ "The claw has come to rescue them from the world inside the claw machine.\n "+ 
		"Beware of timer objects since they can either provide extra time or remove\n time.\n\n"
		+ "Note: Use the multiplier to increase your overall score.\n\n" +
				
		"Best of luck!");
		
		arrowBox = new HBox(8);
		arrowL = new ImageView();
		arrowL.setImage(new Image("assets/left_arrow.png"));
		lT = new Label("Move to the Left");
		arrowR = new ImageView();
		arrowR.setImage(new Image("assets/right_arrow.png"));
		rT = new Label("Move to the Right");
		arrowD = new ImageView();
		arrowD.setImage(new Image("assets/down_arrow.png"));
		dT = new Label("Grab object underneath");
		
		
		arrowBox.getChildren().addAll(arrowL, lT, arrowR, rT, arrowD,dT);
			
		vbox.getChildren().addAll(title,info, arrowBox, back);
		hbox.getChildren().add(vbox);
		
	}
	
	public void styleElements() {
		
		title.setFill(Color.RED);
		title.setFont(new Font("Arial Black",40));
		info.setTextFill(Color.WHITE);
		
		info.setStyle("-fx-font-size: 26px;");
		lT.setTextFill(Color.WHITE);
		lT.setStyle("-fx-font-size: 18px;");
		rT.setTextFill(Color.WHITE);
		rT.setStyle("-fx-font-size: 18px;");
		dT.setTextFill(Color.WHITE);
		dT.setStyle("-fx-font-size: 18px;");
		
		back.setStyle("-fx-color: Red; -fx-font-size: 30px ;");
		
		vbox.setAlignment(Pos.CENTER);
		
		root.setCenter(vbox);
		arrowBox.setAlignment(Pos.CENTER);
		root.setAlignment(vbox, Pos.CENTER);
	}
	
	public void setUpEvents() {
		
		back.setOnAction(ae -> controller.showStartScene());
	}
	
	public Scene getScene() {
		return scene;
	}

}

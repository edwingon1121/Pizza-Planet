/**
 * 
 */
package View;

import Controller.MainController;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
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
public class LeaderboardView {
	private MainController controller;
	private Scene scene;
	
	//UI Elements for scene
	private BorderPane root;
	private VBox vbox;
	private Text title;
	private ListView <String> hiScores;
	private Button back;
	
	public LeaderboardView(MainController controller) {
		this.controller = controller;
		
		root = new BorderPane();
		vbox = new VBox(16);
		title = new Text("Leaderboard:");
		hiScores = new ListView<>();
		hiScores.getItems().addAll("EGS 123456789", "JGR 123456788","HNZ 3456734","OSP 2347898","JGS 678324");
		back = new Button("Back");
		
		scene = new Scene(root,1000,570);
		
		setUpPane();
		setUpEvents();
	}
	
	public void setUpPane() {
		
		Image bg = new Image("assets/backgroundImages/alienCaptureDark.jpg");
		root.setStyle("-fx-background-image:  url('"+ bg.getUrl() +"');"); 
		
		hiScores.setStyle("-fx-background-color: blue; -fx-font-size: 24px;");
		
		vbox.getChildren().addAll(title,hiScores,back);
		
		root.setCenter(vbox);
		vbox.setAlignment(Pos.CENTER);
		
		title.setFont(new Font("Arial Black",40));
		title.setFill(Color.RED);
		
		back.setStyle("-fx-color: Red; -fx-font-size: 30px ;");
	}
	
	public void setUpEvents() {
		back.setOnAction(ae -> controller.showStartScene());
	}
	
	public Scene getScene() {
		return scene;
	}

}

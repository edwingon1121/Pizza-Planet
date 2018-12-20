/**
 * 
 */
package View;

import java.io.File;

import Controller.MainController;
import Model.Game;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

/**
 * @author Edwin Gonzalez
 * ITP 368, Fall 2018
 * Final Project
 * edwingon@usc.edu
 */
public class EndView  {

	private MainController controller;
	private Scene scene;
	
	private BorderPane root;
	private Media media;
	private MediaView mv;
	private MediaPlayer mp;
	
	private HBox hbox;
	private Label score;
	private Button playAgain;
	private Button back;
	
	public EndView(MainController controller){
		this.controller = controller;
		
		root = new BorderPane();
		hbox = new HBox(16);
		score = new Label("SCORE: ");
		
		playAgain = new Button("Play Again");
		back = new Button("Back to Start");
		
		playAgain.setStyle("-fx-color: Red; -fx-font-size: 32px");
		back.setStyle("-fx-color: Red; -fx-font-size: 32px");
		
		
		
		score.setTextFill(Color.WHITE);
		score.setStyle("-fx-background-color: black;");;
		
		hbox.getChildren().addAll(playAgain,back);
		hbox.setPadding(new Insets(16,0,0,0));
		
		scene = new Scene(root,900,700);
		
		setUpMedia();
		root.getChildren().addAll(mv);
		root.setCenter(score);
		root.setTop(hbox);
		hbox.setAlignment(Pos.CENTER);
		
		score.setFont(new Font("Impact",70));
		
		
		playAgain.setOnAction(ae -> {
			mp.stop();
			this.controller.setUpScenes();
			this.controller.showGameScene();
			this.controller.start();
		});
		
		back.setOnAction(ae -> {
			mp.stop();
			this.controller.setUpScenes();
			this.controller.setUpIntroTrack();
			this.controller.showStartScene();
			
		});
		
	}
	
	//Sets up media components for end Scene
	public void setUpMedia() {
		File filestring = new File("src/assets/Media/chosen.mp4");
	    media = new Media(filestring.toURI().toString());
	        
	    mp = new MediaPlayer(media);
	    mp.setCycleCount(2);
	   
		mv = new MediaView(this.mp);
		mp.pause();
	}
	
	public Scene getScene() {
		mp.play();
		return scene;
	}
	public void setScore(String str) {
		score.setText(score.getText() + str);
	}

}

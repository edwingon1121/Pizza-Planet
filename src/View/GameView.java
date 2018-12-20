/**
 * 
 */
package View;

import java.util.Timer;
import java.util.TimerTask;

import Controller.MainController;
import Model.Crane;
import Model.Game;
import Model.ObjectiveItem;
import javafx.animation.AnimationTimer;
import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 * @author Edwin Gonzalez
 * ITP 368, Fall 2018
 * Final Project
 * edwingon@usc.edu
 */
public class GameView {
	
	private MainController controller;
	private Game game;
	private Scene scene;
	
	private Pane root;
	private VBox vbox;
	
	//Determine item creation by factory depending on difficulty selected

	private Crane c;
	
	private Text timeLeft;
	private Text time;
	private Text scoreText;
	private Text score;
	
	
	public GameView(MainController controller) {
		
		this.controller = controller;
		
		root = new Pane();
		vbox = new VBox();
		timeLeft = new Text("TIME REMAINING:");
		time = new Text("30");
		scoreText = new Text("SCORE:");
		score = new Text("00000000000000");
		
		createCrane();
		setUpObjects();
		
		scene = new Scene(root,1000,600);
		setUpEvents();

	}
	
	private void setUpObjects() {
		

		Image img = new Image("assets/backgroundImages/space.jpg");
		
		root.setStyle("-fx-background-image: url('"+ img.getUrl() +"');");
		

		int displace = 0;
		

		timeLeft.setFont(new Font("Aclonica",36));
		time.setFont(new Font("Aclonica",36));
		scoreText.setFont(new Font("Aclonica",36));
		score.setFont(new Font("Aclonica",36));
		
		
		timeLeft.setFill(Color.WHITE);
		time.setFill(Color.WHITE);
		scoreText.setFill(Color.WHITE);
		score.setFill(Color.WHITE);
		
		
		root.getChildren().addAll(timeLeft,time,scoreText,score);
		
		//Loop through the collection of objectives and space them outs
		for (ObjectiveItem alien : game.getAliens()) {
			alien.getImgView().relocate(displace, 450);
			displace+= 200;
			root.getChildren().add(alien.getImgView());
		}
		
		root.getChildren().addAll(game.getMultipler().getImgView(),game.getTimeItem().getImgView());
		
		game.getMultipler().getImgView().relocate(displace, 500);
		game.getTimeItem().getImgView().relocate(displace+150,500);
		
		timeLeft.relocate(10, 0);
		time.relocate(325, 0);
		scoreText.relocate(500, 0);
		score.relocate(650, 0);
		
	}
	
	//Crane needs to check if there is a alien underneath the animation after it plays
	// 1) Load the animation when clicking C and ignore key presses for 5 seconds
	// 2) Move the alien upwards afterwards
	
	private void createCrane() {
		//create Crane, add to root node and enable movement
		c = new Crane();
		game = new Game (c);
		this.controller.setGame(game);
		
		//Obtain the box that holds crane and beam 
		vbox = c.getContainer();
		vbox.relocate(0, 50);
	
		root.getChildren().add(vbox);
		
	}

	
	public void setUpEvents() {
		
		scene.setOnKeyPressed(ke ->{
			switch(ke.getCode()) {
			 case LEFT: case RIGHT:
				c.move(ke.getCode());
				//System.out.println("This is the x value of the container " + vbox.getLayoutX());
//				System.out.println("This is the x-coord " + alien2.getLayoutX() + " and the y-coord " + alien2.getY());
				
//				System.out.print("The alien x-coord: " + alien1.getLayoutX() + " Alien 2 x-coord: "+ 
//						alien2.getLayoutX() + " Alien 3 x-coord is " + alien3.getLayoutX());
				break;
				
				
			 case DOWN:
				//Check if object underneath VBox (check x position)
				c.move(ke.getCode());
//				checkCapture(vbox.getLayoutX());
				
				//Check to see if item is beneath the crane
				if (game.checkCapture()) {
					
					score.setText(Integer.toString(game.getScore()));
//					
					if(game.checkWinStatus()) {
						controller.showEndScene();
					}
				}
				break;
				default:
					System.out.println("Ignoring keyCode " + ke.getCode());
			}
		});
		
	}

	//updates the score on objectives captured
	public void updateScore() {
		int val = Integer.parseInt(score.getText());
		val+= 1000;
		score.setText(Integer.toString(val));
	}
	
	public void animateCapture(ImageView alien) {
		FadeTransition ft = new FadeTransition();
		
		ft.setNode(alien);
		ft.setCycleCount(5);
		ft.setFromValue(1);
		ft.setToValue(0);
		ft.setRate(0.45);
		ft.play();
	}
	

	public Scene getScene() {
		this.controller.start();
		return scene;
		
		
	}
	
	//update the display on the pane 
	public void updateTime(int seconds) {
		time.setText(Integer.toString(seconds));
	}
}

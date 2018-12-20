/**
 * 
 */
package Model;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javafx.animation.FadeTransition;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * @author Edwin Gonzalez
 * ITP 368, Fall 2018
 * Final Project
 * edwingon@usc.edu
 */

//Description: The Game will hold all the objects that are needed to make a game. Such as User, objects (objective, bonus),
// and a Clock.

public class Game {
//	private User user;
//	private Clock gameClock;
	private Crane crane;
	private List<ObjectiveItem> aliens;
	private ScoreMultiplier multipler;
	private TimeItem timeItem;
	private int score;
	private int seconds;
	
	public Game(Crane c) {
		this.crane = c;
		aliens =  new ArrayList (Arrays.asList(new ObjectiveItem(1000),new ObjectiveItem(1000), new ObjectiveItem(1000))); 
		multipler = new ScoreMultiplier();
		timeItem = new TimeItem();
		score = 0;
		seconds = 30;
	}
	
	public void setCrane(Crane c) {
		crane = c; 
	}
	
	public ScoreMultiplier getMultipler() {
		return multipler;
	}

	public int getSeconds() {
		return seconds;
	}

	
	public void setSeconds(int seconds) {
		this.seconds = seconds;
	}

	public TimeItem getTimeItem() {
		return timeItem;
	}

	public List<ObjectiveItem> getAliens() {
		return aliens;
	}

	//Removes item from collection of objective items
	public void removeItem(ObjectiveItem item) {
		
		if (aliens.contains(item)) {
			aliens.remove(item);
		}
		
	}
	
	//Difference between a objective item, time item and score multiplier
	public boolean checkCapture() {
		
		int index = -1;
		
		for (ObjectiveItem alien : aliens) {
			System.out.println("Alien position is: " + alien.getImgView().getLayoutX() + 
					" Crane postion is: " + crane.getContainer().getLayoutX());
			if (alien.getImgView().getLayoutX() == crane.getContainer().getLayoutX()) {
				//Change the image of the captured alien
				alien.setImg(new Image("assets/objects/alien1.png"));
				
				index = aliens.indexOf(alien);
				
				updateScore();
			
			}
		}
		
		if (index > -1) {
			ImageView img = new ImageView();
			img = aliens.get(index).getImgView();
			animateCapture(img);
			aliens.remove(index);
			return true;
		}
		
		return false;
	}
	
	public void updateScore() {
		score+= 1000;
	}
	
	public void animateCapture(ImageView alien) {
		
		System.out.println("Alien's x-coord is "+ alien.getLayoutX());
		
		FadeTransition ft = new FadeTransition();
		
		ft.setNode(alien);
		ft.setCycleCount(5);
		ft.setFromValue(1);
		ft.setToValue(0);
		ft.setRate(0.45);
		ft.play();
	}
	
	//Checks to see if collection is empty and updates score
	public boolean checkWinStatus() {
		//When empty the game is won and takes user to end scene
		if (aliens.isEmpty()) {
			if (seconds>0) {
				System.out.println("This score before points: " + score);
				score+=200*seconds;
				System.out.println("This score after points: " + score);
				
			}
			return true;
		}
		return false;		
	}
	
	public void setScore(int val) {
		score = val; 
	}
	public int getScore() {
		return score; 
	}
	

}

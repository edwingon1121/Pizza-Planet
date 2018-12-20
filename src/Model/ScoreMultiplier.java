/**
 * 
 */
package Model;

import java.util.Random;

import javafx.scene.image.Image;

/**
 * @author Edwin Gonzalez
 * ITP 368, Fall 2018
 * Final Project
 * edwingon@usc.edu
 */
public class ScoreMultiplier extends Entity {
	
	private int value;
	private int duration;
	
	public ScoreMultiplier() {
		super();
		super.setImg(new Image("assets/objects/timer.png"));
		this.value = this.getRandScoreMutlipler();
		this.duration = this.getRandomTime();
	}
	
	public ScoreMultiplier(int value, int duration) {
		super();
		super.setImg(new Image("assets/objects/timer.png"));
		this.value = value;
		this.duration = duration;
	}
	
	public int getvalue() {
		return value;
	}
	
	public int getDuration() {
		return duration;
	}

	private int getRandScoreMutlipler() {
		Random rand = new Random();
		int val =  rand.nextInt(2);
		
		int score = -1;
		
		switch (val) {
		case 0:
			//positive quantity, 0 multiplier
			score = 0;
			break;
		case 1:
			//positive quantity, 2x multiplier
			score = 2;
			break;
		case 2:
			//3x multiplier
			score = 3;
			break;
		}
		return score;	
	}
	
	private int getRandomTime() {
		Random rand = new Random();
		int val =  rand.nextInt(2);
		
		int time = -1;
		
		switch (val) {
		case 0:
			//positive quantity, 10 seconds
			time = 10;
			break;
		case 1:
			//positive quantity, 20 seconds
			time = 20;
			break;
		case 2:
			// positive quantity, 30 seconds
			time = 30;
			break;
		
		}
		return time;	
	}

}

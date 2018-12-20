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

// Description: These items can either increase or decrease the allotted time. *Potentially the class will be able to also 
// add some sort of multiplier property 

public class TimeItem extends Entity {
	
	private int value;
	
	public TimeItem() {
		super();
		super.setImg(new Image("assets/objects/multipler.png"));
		this.value = this.getRandomTime();
	}
	
	public int getvalue() {
		return value;
	}
	
	private int getRandomTime() {
		Random rand = new Random();
		int val =  rand.nextInt(4);
		
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
			//win nothing
			time = 0;
			break;
		case 3:
			//negative quantity 
			time = -5;
			break;
		default:
			time = -10;
			break;
		}
		return time;	
	}
	
}

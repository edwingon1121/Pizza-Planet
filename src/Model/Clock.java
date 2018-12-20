/**
 * 
 */
package Model;

import javafx.scene.image.Image;

/**
 * @author Edwin Gonzalez
 * ITP 368, Fall 2018
 * Final Project
 * edwingon@usc.edu
 */

//Description: The clock is suppose to know how much time is left and handles an time based events such as reducing or
// increasing allotted time.

public class Clock {
	 
	private int timeLeft;
	public Clock(int time) {
		this.timeLeft = time;
	}
	
	public int getTime() {
		return timeLeft;
	}
	
	public void setTime(int time) {
		this.timeLeft = time;
	}
	
	//Randomize whether the time added or subtracted
	public void addTime(int time) {
		
		this.timeLeft+= time;
	}
	
	

}

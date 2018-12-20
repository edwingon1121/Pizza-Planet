/**
 * 
 */
package Model;

import java.util.Arrays;

/**
 * @author Edwin Gonzalez
 * ITP 368, Fall 2018
 * Final Project
 * edwingon@usc.edu
 */


//Description: The user is the individual that has a name associated, initial set, and an array storing 5 highest scores;
//The user will be created when they sign up (added to the "database") and sign in a user object is populated 

public class User {
	private String name;
	private String initials;
	private int[] scores;
	
	//Constructors
	public User(String name, String initials, int[] scores) {
		this.name = name;
		this.initials = initials;
		this.scores = scores;
	}
	
	public User(String name, String initials) {
		this.name = name;
		this.initials = initials;
		this.scores = new int[5];
	}
	
	//Getters & Setters
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getInitials() {
		return initials;
	}
	
	public void setInitials(String initials) {
		this.initials = initials;
	}
	
	public int[] getScores() {
		return scores;
	}
	
	public void setScores(int[] scores) {
		this.scores = scores;
	}
	
	public void orderScores() {
		Arrays.sort(scores);
	}

	public void addScore(int score) {
		
		//check if there is an element in the array smaller than score trying to add
		if (scores.length == 5) {
			
			for (int i=0; i<scores.length; i++) {
				if (score > scores[i]) {
					scores[scores.length-1] = score;
				}
				else if (score == scores[i] ) {
					i = scores.length;
				}
			}
		}
		else {
			scores[scores.length-1] = score;
		}
		
		orderScores();
		
	}
	
	@Override
	public String toString() {
		return "User [name=" + name + ", initials=" + initials + ", scores=" + Arrays.toString(scores) + "]";
	}	
	
}

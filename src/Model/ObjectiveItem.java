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

//Description: This entity is for items that the user has to collect in order to win. This object has a name, image,
// and score associated with the item.
public class ObjectiveItem extends Entity {

	private int value;
	
	//Constructors
	public ObjectiveItem(Double xPos, Double yPos, Image img, int value) {
		super(xPos,yPos,img);
		this.value = value;
	}
	
	public ObjectiveItem(Image img, int value) {
		super(img);
		this.value = value;
		
	}
	
	public ObjectiveItem(int value) {
		super();
		this.value = value;
	}
	

	
	public int getValue() {
		return value;
	}
	
	public void setValue(int value) {
		this.value = value;
	}

	
}

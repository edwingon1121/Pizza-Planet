/**
 * 
 */
package Model;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * @author Edwin Gonzalez
 * ITP 368, Fall 2018
 * Final Project
 * edwingon@usc.edu
 */
public class Entity {

	private Double xPos;
	private Double yPos;
	private ImageView imgView;
	
	public Entity(Double xPos, Double yPos, Image image) {
		
		this.xPos = xPos;
		this.yPos = yPos;
		this.imgView = new ImageView();
		this.imgView.setImage(image);
	}
	
	public Entity(Image image) {
		this.xPos = 0.0;
		this.yPos = 0.0;
		this.imgView = new ImageView();
		this.imgView.setImage(image);
	}
	public Entity() {
		this.xPos = 0.0;
		this.yPos = 0.0;
		this.imgView = new ImageView();
		this.setImg(new Image("assets/objects/alien3.png"));
	}


	public Double getxPos() {
		return xPos;
	}

	public void setxPos(Double xPos) {
		this.xPos = xPos;
	}

	public Double getyPos() {
		return yPos;
	}

	public void setyPos(Double yPos) {
		this.yPos = yPos;
	}

	public ImageView getImgView() {
		return imgView;
	}

	public void setImg(Image img) {
		this.imgView.setImage(img);
	}	
}

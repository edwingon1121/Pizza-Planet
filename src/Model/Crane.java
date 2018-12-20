/**
 * 
 */
package Model;

import javafx.animation.FadeTransition;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.VBox;

/**
 * @author Edwin Gonzalez
 * ITP 368, Fall 2018
 * Final Project
 * edwingon@usc.edu
 */

//Description: This is the crane which is responsible for having movement and interacting with objective items and entities

public class Crane extends Entity {
	
	private final int SPEED = 5;
	private ImageView imgView;
	private ImageView beam;
	private VBox container;
	
	public Crane() {
		super();
		
		imgView = new ImageView();
		imgView.setImage(new Image ("assets/objects/crane_Open.png"));
		beam = new ImageView();
		beam.setImage(new Image ("assets/objects/beams.png"));
		
		container = new VBox(12);
		container.getChildren().addAll(imgView,beam);
		
		//set beam opacity to 0
		beam.setOpacity(0);

	}
	
	public ImageView getImgView() {
		return imgView;
	}
	
	public VBox getContainer() {
		return container;
	}

	//set up game movements 
	public void move(KeyCode code) {
		
		switch(code) {
		case RIGHT:
			if (container.getLayoutX() < 1000) {
				this.container.setLayoutX(this.container.getLayoutX() + SPEED);
			}
			
//			System.out.println("Right was pressed!!");
			break;
			
		case LEFT:
			if (container.getLayoutX() > 0) {
				this.container.setLayoutX(this.container.getLayoutX() -SPEED);
			}
			
//			System.out.println("Left was pressed!!");
			break;
		case DOWN:
			//TODO Do not let the user move the crane for 8 seconds 
			animateBeam();
			break;
		}
	}
	
	public void animateBeam() {
		FadeTransition ft = new FadeTransition();
		ft.setNode(beam);
		ft.setFromValue(1);
		ft.setToValue(0);
		ft.setRate(0.45);
		ft.setCycleCount(5);
		ft.play();
		
	}
}

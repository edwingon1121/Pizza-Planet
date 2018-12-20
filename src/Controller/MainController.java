/**
 * 
 */
package Controller;

import java.io.File;
import java.util.Timer;
import java.util.TimerTask;

import Model.Game;
import View.EndView;
import View.GameView;
import View.InstructionView;
import View.LeaderboardView;
import View.StartView;
import javafx.application.Application;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * @author Edwin Gonzalez
 * ITP 368, Fall 2018
 * Final Project
 * edwingon@usc.edu
 */
public class MainController extends Application {
	//This handles communication between the model and view
	
	private Stage primaryStage; 
	private Game game;
	private StartView startView;
	private InstructionView instructView;
	private GameView gameView;
	private LeaderboardView lbView;
	private EndView endView; 
	private Media media;
	private MediaPlayer player;
	private int seconds = 30;
	private Timer myTimer;
	private TimerTask task;
	
	@Override
	public void start(Stage stage) throws Exception {
		this.primaryStage = stage;
		primaryStage.setTitle("Pizza Planet");
		setUpScenes();
		setUpIntroTrack();
		
        showStartScene();
        primaryStage.show();
	}
	
	public void setUpIntroTrack() {
		  File filestring = new File("src/assets/Media/Claw.mp3");
	        media = new Media(filestring.toURI().toString());
	        
	        player = new MediaPlayer(media);
	        player.setStartTime(Duration.seconds(5));
	        player.setStopTime(Duration.seconds(42));
	        player.setCycleCount(5);
	        player.play();

	}
	
	public void setUpGameTrack() {
		player.stop();
		
		 File filestring = new File("src/assets/Media/Star_Fox.mp4");
	        media = new Media(filestring.toURI().toString());
	        
	        player = new MediaPlayer(media);
	        player.setCycleCount(MediaPlayer.INDEFINITE);
	        player.play();

	}
	// set up all scenes for the application
		public void setUpScenes() {
			startView = new StartView(this);
			gameView = new GameView(this);
			instructView = new InstructionView(this);
			lbView = new LeaderboardView(this);
			endView = new EndView(this);
		}
		
		// display the starting scene
		public void showStartScene(){
		
			primaryStage.setScene(startView.getScene());
		}
		
		//display the Instruction scene
		public void showInstruction() {
			primaryStage.setScene(instructView.getScene());
		}
		
		// display the game scene
		public void showGameScene() {
			setUpGameTrack();
			
			myTimer = new Timer();
			task = new TimerTask() {
				public void run() {
					game.setSeconds(game.getSeconds()-1);
					gameView.updateTime(game.getSeconds());
					
					if (game.getSeconds()== 0 || game.checkWinStatus()) {

						showEndScene();
						myTimer.cancel();
						
					}
					
					System.out.println("Seconds Remaining: "+ game.getSeconds());
				}
			};
		
			
			primaryStage.setScene(gameView.getScene());

		}
		
		public void start() {
			myTimer.schedule(task, 1000, 1000);
		}
		
		//display the leaderboard scene
		public void showLeaderBoardScene() {
			primaryStage.setScene(lbView.getScene());
		}
		
		// display the end scene
		public void showEndScene(){
			
			player.stop();
			
//			System.out.println("This is the score on game " + game.getScore());
			int sec = game.getScore();
			
			endView.setScore(Integer.toString(sec));
			
			primaryStage.setScene(endView.getScene());
		}

		public void setGame(Game g) {
			 game = g;
		}
		
		public Game getGame() {
			return game;
		}

		public MediaPlayer getMediaPlayer() {
			return player;
		}
	
	public static void main(String[] args) {
		launch(args);

	}

}

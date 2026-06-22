package moviePackage;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Date;
import java.util.Observable;
import java.util.Observer;

import javafx.application.*;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.shape.*;
import javafx.stage.Stage;
import moviePackage.Movie.Genre;
import moviePackage.Movie.Rating;
import moviePackage.MoviesRMessage.Operation;
import javafx.scene.paint.*;

public class MoviesRView extends Application implements Observer {
	@Override
	public void start(Stage arg0) throws Exception {
		BorderPane root = new BorderPane();
		GridPane movieGrid = new GridPane();
		Rectangle rectangle = new Rectangle();
		rectangle.setHeight(40);
		rectangle.setWidth(20);

		
		
		
		Scene scene = new Scene(root, 1000, 1000);
		Stage stage = new Stage();
		stage.setScene(scene);
		stage.setTitle("Movies R Back");
		stage.show();
	}

	public void login(){


	}
	@Override
	public void update(Observable o, Object arg) {
		
		
	}
	
	public Rectangle createPoster(){
		Rectangle movieCover = new Rectangle();
		movieCover.setStroke(Color.BLACK);
		movieCover.setFill(Color.BLACK);
		movieCover.setStrokeWidth(18);
		movieCover.setScaleY(30);
		movieCover.setScaleX(15);
		return movieCover;
	}
}

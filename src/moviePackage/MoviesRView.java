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
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.*;
import javafx.stage.Stage;
import moviePackage.Movie.Genre;
import moviePackage.Movie.Rating;
import moviePackage.MoviesRMessage.Operation;
import javafx.scene.paint.*;

public class MoviesRView extends Application implements Observer {
	@Override
	public void start(Stage arg0) throws Exception {
		Movie terminatorTest = new Movie("Terminator 2: Judgment Day", new Date(7, 3, 1991), 137, Genre.ACTION, Rating.LIKE);
		Socket socket = new Socket("localHost", 1313);
		ObjectOutputStream out = new  ObjectOutputStream(socket.getOutputStream());
		out.flush();
		ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
		out.writeObject(new MoviesRMessage(new User(),Operation.INITIALIZE, terminatorTest));
		in.readObject();
		
		BorderPane root = new BorderPane();
		
		
		
		Scene scene = new Scene(root, 300, 300);
		Stage stage = new Stage();
		stage.setScene(scene);
		stage.setTitle("Movies R Back");
		stage.show();
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

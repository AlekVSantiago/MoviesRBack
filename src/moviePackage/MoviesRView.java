package moviePackage;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javafx.application.*;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.*;
import javafx.scene.shape.*;
import javafx.stage.Stage;
import javafx.scene.paint.*;

public class MoviesRView extends Application implements Observer {
	@Override
	public void start(Stage arg0) throws Exception {

		MoviesRModel model = new MoviesRModel("/Users/aleksantiago/Desktop/spreadSheets/Movies.csv");
		MoviesRController controller = new MoviesRController(model);
		ArrayList<Movie> library = controller.getModel().getMovies();
		BorderPane root = new BorderPane();

		/*
		For the Top of the BorderPane
		 */
		GridPane topGrid = new GridPane(1000, 200);
		topGrid.setVgap(200);
		topGrid.setPadding(new Insets(20));

		/*
		Grid of movies
		 */
		GridPane movieGrid = new GridPane();
		movieGrid.setHgap(20);
		movieGrid.setVgap(10);
		movieGrid.setPadding(new Insets(20));


		/*
		scrollPane for the movieGrid
		 */
		ScrollPane centerScroll = new ScrollPane(movieGrid);

		/*
		for loop initializing
		the selectable movies

		for(int i = 0; i < 5; i++){
			for(int j = 0; j < 10; j++){
				StackPane movieDisplayStack = new StackPane();
				Rectangle inputRectangle = new Rectangle(100, 200);
				inputRectangle.setStrokeWidth(9);
				inputRectangle.setFill(Color.BLACK);
				inputRectangle.setFill(Color.GRAY);

				Label titleLabel = new Label("Title");
				movieDisplayStack.getChildren().addAll(inputRectangle, titleLabel);

				movieGrid.add(movieDisplayStack,i, j);
			}
		}
		*/
		int rowNumber = 0;
		int colNumber = 0;

		for(int i = 0; i < library.size(); i++){
			StackPane movieDisplay = new StackPane();
			/*TODO
			Make this into a legitimate poster
			  */
			Rectangle posterPlaceHolder = new Rectangle(100, 200);
			posterPlaceHolder.setFill(Color.GRAY);
			posterPlaceHolder.setStroke(Color.BLUE);
			posterPlaceHolder.setStrokeWidth(20);

			Label movieLabel = new Label(library.get(i).getName());

			movieDisplay.getChildren().addAll(posterPlaceHolder,movieLabel);


		}


		root.setTop(topGrid);
		root.setCenter(centerScroll);



		
		
		
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

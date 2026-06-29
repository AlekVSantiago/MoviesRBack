package moviePackage;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javafx.application.*;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.shape.*;
import javafx.stage.Stage;
import javafx.scene.paint.*;

public class MoviesRView extends Application implements Observer {
	@Override
	public void start(Stage arg0) throws Exception {
		MoviesRModel model = new MoviesRModel("/Users/aleksantiago/Desktop/spreadSheets/Movies.csv");
		MoviesRController controller = new MoviesRController(model);
		ArrayList<Movie> library = controller.getModel().getLibrary();
		BorderPane root = new BorderPane();
		//Meant for the side of the screen, This is for things like search, home, settings, etc
		VBox controlTabs = new VBox(9);

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


		for(int i = 0; i < library.size(); i++){
			StackPane movieDisplay = new StackPane();
			/*TODO
			Make this into a legitimate poster via just grabbing it from somewhere in the computer/ server
			  */


			Label movieLabel = new Label(library.get(i).getName());
			movieLabel.setMaxWidth(60);

			movieDisplay.getChildren().addAll(posterPlaceHolder,movieLabel);
			movieGrid.add(movieDisplay, colNumber, rowNumber);
			if(colNumber == 4){
				colNumber = 0;
				rowNumber++;
			}
			else{
				colNumber++;
			}
		}


		root.setCenter(centerScroll);



		Scene scene = new Scene(root, 1000, 1000, Color.BLACK);
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

    /**
     * @param
     * @param movieArr
     * @return
     */
	/*
	carousel refers to the sidways scrolling rows in the ui of the main screen

		ScrollPane(The whole thing) --> VBox(Label) --> HBox(Movies)
	 */
	public displayCarousel(String title, ArrayList<Movie> movieArr){
		 Label carouselTitle = new Label(title);
		 carouselTitle.setMinSize(40, 40);
		 VBox  components = new VBox(20);
		 HBox carouselMovie = new HBox(20);


		 String locationString = "This String should be changed from this";
		 components.getChildren().addAll(carouselTitle);

		 for(int i = 0 ; i < movieArr.size(); i++){
			locationString = movieArr.get(i).getMovieLocation();
			Image image = new Image(movieArr.get(i).getMovieLocation());
			ImageView imageView = new ImageView(image);
			carouselMovie.getChildren().add(imageView);
		 }
		 components.getChildren().addAll(carouselTitle, carouselMovie);
		ScrollPane carouselPane = new ScrollPane(components);

		return carouselPane;
	}
}

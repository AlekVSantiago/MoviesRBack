package moviePackage;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;

public class MoviesRModel {
	private User user;
	private View viewMode;
	private ArrayList<Movie> library;
	private ArrayList<Movie> myList;
	private HashMap<String, ArrayList<Movie>> carouselMap = initCarousel("carousel.csv");

    public enum View{ LIBRARY, HOME, SEARCH}
	MoviesRModel(User user, ArrayList<Movie> library){
		this.library = library;
	}

	MoviesRModel(String file) throws FileNotFoundException {
		this.user = new User();
		this.library = initializeLibrary(file);
		this.myList = new ArrayList<Movie>();
		this.viewMode = View.HOME;
	}

	/*
	Example to draw fron of the csvFile
	Star_Wars_(4K77)	George_Lucas	SciFi	5/25/1977	 121	movieLocation	PosterLocation
	0					    1			  2		  3			  4		  5				6
	 */
	public ArrayList<Movie> initializeLibrary(String fileString) throws FileNotFoundException {
		ArrayList<Movie> result = new ArrayList<Movie>();

		File file = new File(fileString);
		Scanner scanner = new Scanner(file);
		String currString = scanner.nextLine();
		while(scanner.hasNextLine()){
			currString = scanner.nextLine();
			String[] cols = currString.split(",");
			/*
			Initialize
			 */
			String movieName = cols[0].replace('_', ' ');
			String movieDirector = cols[1].replace('_', ' ');
			Movie.Genre movieGenre = MoviesRController.stringToGenre(cols[2]);
			/*
			little work for the release date
			 */
			String[] dateNumbers = cols[3].split("/");

			int month = Integer.valueOf(dateNumbers[0]);
			int day = Integer.valueOf(dateNumbers[1]);
			int year = Integer.valueOf(dateNumbers[2]);
			Date movieReleaseDate = new Date(month, day, year);


			int runtime = Integer.valueOf(cols[4]);
			String location = cols[5];
			result.add(new Movie(movieName, movieDirector, movieGenre, movieReleaseDate, runtime,location));
		}
        return result;
    }
	public User getUser() {
		return this.user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public ArrayList<Movie> getLibrary() {

		return this.library;
	}
	public void setLibrary(ArrayList<Movie> library) {

		this.library = library;
	}

	public ArrayList<Movie> getMyList(){
		return this.myList;
	}
	public void setMyList(ArrayList<Movie> myList) {
		this.myList = myList;
	}

	public View getViewMode() { return viewMode;
	}
	public void setViewMode(View viewMode) {
		this.viewMode = viewMode;
	}

	/*
	I am intending for the ArrayList of Movies to be initialized via a text document.
	It will read the name of the movie, See if they have it, and then populate the carousel if it does have the movie
	that the document is talking about.

	The Expected format of the CSV File that I would like to use will be like this.

	|_name_|_movie1, movie2, movie3
	 */
	public HashMap<String, ArrayList<Movie>> initCarousel(String fileName) {
        HashMap<String, ArrayList<Movie>> resultCarousel;
        try {
            resultCarousel = new HashMap<String, ArrayList<Movie>>();
            File carouselFile = new File(fileName);
            Scanner scanner = new Scanner(carouselFile);
            String currentLine = "";

            String carouselName = "Nothing mate";
            String[] carouselArray = {};
            String[] movieTextArray = {};
            while (scanner.hasNextLine()) {
                currentLine = scanner.nextLine();
                carouselArray = currentLine.split(" ");


                carouselName = carouselArray[0];
                currentLine = scanner.nextLine();
                carouselArray = currentLine.split(" ");
                movieTextArray = carouselArray[1].split(",");
                for (int i = 0; i < movieTextArray.length; i++) {
                    if (inLibrary(movieTextArray[i])) {
                        Movie currentMovie = retrieveMovie(movieTextArray[i]);
                        resultCarousel.get(carouselName).add(currentMovie);
                    }
                }
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return resultCarousel;
    }

	private Movie retrieveMovie(String movieName) {
		for(int i = 0; i < this.getLibrary().size(); i++){
			if(this.getLibrary().get(i).getName().equals(movieName)){
				return this.getLibrary().get(i);
			}
		}
		return null;
	}

	public boolean inLibrary(String movieName){
		 for(int i = 0; i < this.getLibrary().size(); i++){
			 if(this.getLibrary().get(i).getName().equals(movieName)){
				 return true;
			 }
			 else{
				 continue;
			 }
		 }
		 return false;
		}

}

package moviePackage;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class MoviesRModel {
	private User user;
	private ArrayList<Movie> movies;
	private ArrayList<Movie> myList;
	
	MoviesRModel(User user, ArrayList<Movie> movies){
		this.movies = movies;
	}

	MoviesRModel(String file) throws FileNotFoundException {
		this.user = new User();
		this.movies = initializeLibrary(file);
		this.myList = new ArrayList<Movie>();

	}

	/*
	Example to draw fron of the csvFile
	Star_Wars_(4K77)	George_Lucas	SciFi	5/25/1977	121
	 */
	public ArrayList<Movie> initializeLibrary(String fileString) throws FileNotFoundException {
		ArrayList<Movie> result = new ArrayList<Movie>();

		File file = new File(fileString);
		Scanner scanner = new Scanner(file);

		while(scanner.hasNextLine()){
			String currString = scanner.nextLine();
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
			result.add(new Movie(movieName, movieDirector, movieGenre, movieReleaseDate, runtime));
		}
        return result;
    }
	public User getUser() {
		return this.user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public ArrayList<Movie> getMovies() {
		return this.movies;
	} 
	public ArrayList<Movie> getMyList(){
		return this.myList;
	}
	public void setMovies(ArrayList<Movie> movies) {
		this.movies = movies;
	}
	public void setMyList(ArrayList<Movie> myList) {
		this.myList = myList;
	}
	
	
	
	
	
	
	
}

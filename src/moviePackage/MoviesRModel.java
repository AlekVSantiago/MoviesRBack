package moviePackage;

import java.util.ArrayList;

public class MoviesRModel {
	private ArrayList<Movie> movies;
	private ArrayList<Movie> myList;
	
	MoviesRModel(User user, ArrayList<Movie> movies){
		this.movies = movies;
	}
	
	//This should be constructing through the server that is set up
	MoviesRModel(){
		this.movies = new ArrayList<Movie>();
		this.myList = new ArrayList<Movie>();
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

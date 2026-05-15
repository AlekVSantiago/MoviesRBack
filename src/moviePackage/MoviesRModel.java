package moviePackage;

import java.util.ArrayList;

public class MoviesRModel {
	User user;
	ArrayList<Movie> movies;
	
	MoviesRModel(User user, ArrayList<Movie> movies){
		this.user = user;
		this.movies = movies;
	}
	MoviesRModel(){
		this.user = new User();
		this.movies = new ArrayList<Movie>();
	}
	
	
	
	
}

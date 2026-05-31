package moviePackage;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Date;

import moviePackage.Movie.Genre;
import moviePackage.Movie.Rating;
import moviePackage.MoviesRMessage.Operation;

import java.io.File;
import java.io.FileNotFoundException;


public class MoviesRServer implements Serializable{
	ArrayList<Movie> serverLibrary;
	private HashMap<User, MoviesRModel> userMap;
	private static final long serialVersionUID = 1L;
	
	
	MoviesRServer() throws FileNotFoundException{
		this.userMap = new HashMap<User, MoviesRModel>();
		this.serverLibrary = buildServer();
	}
	
	
	public static void main (String[] args) throws IOException {
		ServerSocket server = new ServerSocket(1313);
		
		while(true) {
			Socket socket = server.accept();
			ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
			out.flush();
			
			ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
			
			
		}
		
	}
	//initializes the User's model when logging and sending it out. Right now it is just literal nonsense
	public void initializeModel(User user, ObjectOutputStream out) throws IOException {
		MoviesRModel outputModel = userMap.get(user);
		out.writeObject(outputModel);
		
	}
	
	public void ratingChange(User user, Movie selectedMovie, Rating rating) {
		ArrayList<Movie> movieList = this.userMap.get(user).getMovies(); 
		for(Movie movie : movieList) {
			if(movie.getName().equals(selectedMovie.getName())) {
				movie.setRating(rating);
			}
			else {
				System.out.println("Was not able to find the movie in the server or whatever CODE: 101");	
			}
		}
	} 
	
	// I don't quite know if this is needed yet or how I am going to make there whole server populated yet
	public ArrayList<Movie> buildServer()throws FileNotFoundException{
		ArrayList<Movie> resultArr = new ArrayList<Movie>();
		File file = new File("MoviesRBack.csv");
		Scanner scanner = new Scanner(file);
		
		while(scanner.hasNextLine()) {
			String[] dataArr = scanner.nextLine().split("");
			String tempName = dataArr[0];
			Date release = MoviesRController.createDate(dataArr[1]);
		
			

		
			 int runtime = MoviesRController.createRuntime(dataArr[1]);
			 Genre genre = MoviesRController.createGenre(dataArr[2]);
			 Rating rating = Rating.NEUTRAL;
			
			Movie currMovie = new Movie(tempName, release, runtime, genre, rating);
			resultArr.add(currMovie);
			
		}
		return resultArr;
		
		
	}
	
	
	
	
}

package moviePackage;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import moviePackage.Movie.Genre;

public class MoviesRController {


	private MoviesRModel model;

	/*TODO
	The fact that this parameter is passed into two layers of constructors is
	absolutley madness and needs to be FIXED
	 */
	MoviesRController(String file) throws FileNotFoundException {
		this.model = new MoviesRModel(file);
	}
	MoviesRController(MoviesRModel model){
		this.model = model;
	}




	/*
	 * Console based information display
	 */
	public void displayInfoConsole(Movie selectedMovie) {
		System.out.println("Name: " + selectedMovie.getName());
		System.out.println("Release Date: " + selectedMovie.getRelease());
		System.out.println("Runtime: " + selectedMovie.getRuntime());
		System.out.println("Genre: " + selectedMovie.getGenre());
	}
	
	/*public void playMovie(Movie selectedMovie) {
		System.out.println("Now Playing " + selectedMovie.getName() + "... " );
	}
	*/


	public static void MoviesinitializeLibrary(User user) throws UnknownHostException, IOException {
		Socket socket = new Socket("localHost", 1313);
		ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
		out.flush();
		ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
		//out.writeObject(MoviesRMessage(user, ));
		
		
	}

	@SuppressWarnings("deprecation")
	public static Date createDate(String dateString) {
		String[] dateStringArr = dateString.split("/");
		int month = Integer.valueOf(dateStringArr[0]);
		int year = Integer.valueOf(dateStringArr[1]);
		int day = Integer.valueOf(dateStringArr[2]);
		return  new Date(month, year, day);
	}
	
	public static int createRuntime(String runtimeString){
		return Integer.valueOf(runtimeString);
		
		
	}
	public static Genre createGenre(String stringGenre) {
		switch(stringGenre) {
			case "action":
				return Genre.ACTION;
			case "fantasy":
				return Genre.FANTASY;
			case "adventure":
				return Genre.ADVENTURE;
			case "scifi":
				return Genre.SCIFI;
			case "horror":
				return Genre.HORROR;
			default:
				return Genre.NONE;
		}
	}



	public static boolean loginConsole() throws UnknownHostException, IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
		String loginString = "";
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter Email: ");
		loginString += scanner.nextLine() + " ";
		System.out.println("Enter Password: ");
		loginString += scanner.nextLine();
		
		Socket socket = new Socket("localhost", 1313);
		
		ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
		out.flush();
		ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
		
		
		
		return (boolean) in.readObject();


	}
	////HORROR, SCIFI, WESTERN, FANTASY, ADVENTURE, ACTION, NONE
	public static Genre stringToGenre(String genreString){
		switch (genreString.toLowerCase()){
			case "sci-fi":
				return Genre.SCIFI;
            case "horror":
				return Genre.HORROR;
            case "fantasy":
				return Genre.FANTASY;
            case "adventure":
				return Genre.ADVENTURE;
            case "action":
				return Genre.ACTION;
            case "comedy":
				return Genre.COMEDY;
			default:
				return Genre.ACTION;
		}
	}


	public MoviesRModel getModel() {
		return model;
	}

	public void setModel(MoviesRModel model) {
		this.model = model;
	}

}

package moviePackage;


import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import moviePackage.Movie.Genre;
import moviePackage.MoviesRMessage.Operation;

public class MoviesRController {
	private MoviesRModel model;
	
	MoviesRController(MoviesRModel model){
		this.model = model;
	}



	public static boolean login(String email, String password) {
		try{
			Socket socket = new Socket("localhost", 1313);
			ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
			out.flush();
			ObjectInputStream in = new ObjectInputStream(socket.getInputStream());

			out.writeObject(new MoviesRMessage(email, Operation.LOGIN, password));
			boolean returnVerification = in.readBoolean();
			return returnVerification;
		}
		/*
		I don't think that any of these Exceptions are possible but you never know and they require me to put these here
		 */
		catch (UnknownHostException e){
			System.out.println("login failed: Unknown Host");
			e.printStackTrace();
		}
		catch (IOException j){
			System.out.println("Login failed: Input Output Exception");
			j.printStackTrace();
		}


	return false;}
	//This is a sort of test method to just say that I am playing the movie 
	
	/*
	 * Console based information display
	 */
	public void displayInfo(Movie selectedMovie) {
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

}

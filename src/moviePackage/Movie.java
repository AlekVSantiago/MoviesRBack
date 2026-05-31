package moviePackage;

import java.util.ArrayList;
import java.util.Date;

public class Movie {
	public enum Genre{
		HORROR, SCIFI, WESTERN, FANTASY, ADVENTURE, ACTION, NONE 
	}
	public enum Rating{
		LIKE, DISLIKE, NEUTRAL
	}
	
	
	private String name;
	private Date release;
	private ArrayList<Crew> crew;
	private int runtime;
	private Genre genre;
	private Rating rating;
	
	
	Movie(String name, Date date, int runtime, Genre genre, Rating rating){
		this.name = name;
		this.release = date;
		this.runtime = runtime;
		this.genre = genre;
		this.rating = rating;
		this.crew = new ArrayList<Crew>();
	}
	
	
	public String getName() {
		return this.name;
	}
	public Date getRelease() {
		return this.release;
	}
	public int getRuntime() {
		return this.runtime;
	}
	public ArrayList<Crew> getCrew(){
		return this.crew;
	}
	public Genre getGenre() {
		return this.genre;
	}
	public Rating getRating() {
		return this.rating;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public void setRelease(Date date) {
		this.release = date;
	}
	public void setRuntime(int runtime) {
		this.runtime = runtime;
	}
	public void setGenre(Genre genre) {
		this.genre = genre;
	}
	public void setRating(Rating rating) {
		this.rating = rating;
	}
	
	
	public static void main(String[] args) {
		
	}
	
	@Override
	public String toString() {
		String result = "";
		result += "Name: " + this.getName() + "\n";
		result += "Release Date: " + this.getRelease().toString() + "\n";
		result += "Rumtime: " + this.getRuntime()+ "\n";
		return result;
	}
	
	
	
}

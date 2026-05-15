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
	private Date date;
	private int runtime;
	private Genre genre;
	private Rating rating;
	private ArrayList<Crew> crew;
	
	
	Movie(String name, Date date, int runtime){
		this.name = name;
		this.date = date;
		this.runtime = runtime;
		this.genre = Movie.Genre.NONE;
		this.rating = Movie.Rating.NEUTRAL;
		this.crew = new ArrayList<Crew>();
	}
	public String getName() {
		return this.name;
	}
	public Date getDate() {
		return this.date;
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
	public void setDate(Date date) {
		this.date = date;
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
		result += "Release Date: " + this.getDate()+ "\n";
		result += "Rumtime: " + this.getRuntime()+ "\n";
		return result;
	}
	
	
	
}

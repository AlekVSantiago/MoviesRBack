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
	private int runtime;
	private Genre genre;
	
	
	Movie(String name, Date date, int runtime, Genre genre, Rating rating){
		this.name = name;
		this.release = date;
		this.runtime = runtime;
		this.genre = genre;
	}
	
	Movie(){
		this.name = "nothing";
		this.release = new Date(12,12,12);
		this.runtime = 121;
		this.genre = Genre.NONE;
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
	public Genre getGenre() {
		return this.genre;
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

package moviePackage;

import java.util.ArrayList;
import java.util.Date;

public class Movie {
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public enum Genre{
		HORROR, SCIFI, WESTERN, FANTASY, ADVENTURE, ACTION, COMEDY, NONE
	}
	public enum Rating{
		LIKE, DISLIKE, NEUTRAL
	}
	
	
	private String name;



	private String director;
	private Date releaseDate;
	private int runtime;
	private Genre genre;
	private String location;
	
	
	Movie(String name, String director, Genre genre, Date date, int runtime, String location){
		this.name = name;
		this.director = director;
		this.releaseDate = date;
		this.runtime = runtime;
		this.genre = genre;
	}
	
	Movie(){
		this.name = "nothing";
		this.releaseDate = new Date(12,12,12);
		this.runtime = 121;
		this.genre = Genre.NONE;
	}
	
	
	public String getName() {
		return this.name;
	}
	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}
	public Date getRelease() {
		return this.releaseDate;
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

		this.releaseDate = date;
	}
	public void setRuntime(int runtime)
	{
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

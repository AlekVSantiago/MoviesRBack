package moviePackage;

import java.util.ArrayList;
import java.util.Date;

public class Movie {
	public enum Genre{
		HORROR, SCIFI, WESTERN, FANTASY, ADVENTURE, SPY,
	}
	private String name;
	private Date date;
	private int runtime;
	private ArrayList<Crew> crew;
	
	
	Movie(String name, Date date, int runtime){
		this.name = name;
		this.date = date;
		this.runtime = runtime;
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
	
	public void setName(String name) {
		this.name = name;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public void setRuntime(int runtime) {
		this.runtime = runtime;
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

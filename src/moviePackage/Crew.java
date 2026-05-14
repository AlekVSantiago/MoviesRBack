package moviePackage;

import java.util.ArrayList;
import java.util.Date;
public class Crew {
	private String name;
	private Date birthdate;
	private ArrayList<Movie> projects;
	
	Crew(String name, Date birthday){
		this.name = name;
		this.birthdate = birthday;
		this.projects = new ArrayList<Movie>();
	}
	
	public String getName() {
		return this.name;
	}
	public Date getBirthday() {
		return birthdate;
	}
	public ArrayList<Movie> getProjects(){
		return this.projects;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}
	
}

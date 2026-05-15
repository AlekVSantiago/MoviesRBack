package moviePackage;

import java.util.Date;

public class User {
	private String name;
	private Date birthdate;
	private String password;
	
	User(String name, Date birthdate, String password){
		this.name = name;
		this.birthdate = birthdate;
		this.password = password;
	}
	
	User(){
		this.name = "default";
		this.password = "password";
		this.birthdate = new Date();
		
	}
	
	public String getName() {
		return this.name;
	}
	public Date getBirthdate() {
		return this.birthdate;
	}
	public String getPassword() {
		return this.password;
	}
	public int getAge() {
		System.out.println("Age has not been implemented yet"); //No implementation of the age yet
		return 1;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}
	public void setPassword(String password) {
		this.password = password;
	}
		
}

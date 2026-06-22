package moviePackage;
/*
This is supposed to be an encapsulation of the operations and what they are operatiing on within an object of certain fields
Hopefully every field is enough. According to what you would need to make this work This should be it

			(EMAIL(Who)-------------Operation(What)--------------Object(Where))
 */
public class MoviesRMessage{
	private String email; //Who is doing the operation and on what account
	private Operation operation; //Enum which is defined below. More operations should be able to be added as needed
	private Object obj;
	
	
	public enum Operation{
		LOGIN, SELECT, PLAY
	}
	
	MoviesRMessage(String email, Operation operation, Object obj){
		this.email = email;
		this.operation = operation;
		if(obj instanceof String) {
			this.obj = (String) obj;
		}
		else if(obj instanceof Movie) {
			this.obj = (Movie) obj;
		}
		else {
			System.out.println("Something is here that should not be");
			System.exit(0);
		}
		
	}
	public String getEmail() {
		return email;
	}
	
	public Operation getOperation() {
		return this.operation;
	}
	public Object getObject() {
		return this.obj;
	}
	public void setOperation(Operation operation) {
		this.operation = operation;
	}
	public void setMovie(Object obj) {
		this.obj = obj;
	}
	
	@Override
	public String toString() {
		
		String result = "Operation message \n";
		result += "Email: " + this.email + "\n";
		result += "Operation: " + this.operation + "\n";
		if(this.obj instanceof Movie) {
			result += "Movie: " + this.obj.toString();
		}
		else if(this.obj instanceof String) {
			result += "String: " + this.obj;
		}
		return result;
	}

}

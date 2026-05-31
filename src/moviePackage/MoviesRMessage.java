package moviePackage;

public class MoviesRMessage{
	private User user;
	private Operation operation;
	private Movie movie;
	
	public enum Operation{
		VERIFY, INITIALIZE, RATING, UPDATE
	}
	
	MoviesRMessage(User user, Operation operation, Movie movie){
		this.user = user;
		this.operation = operation;
		this.movie = movie;
	}
	public User getUser() {
		return this.user;
	}
	public Operation getOperation() {
		return this.operation;
	}
	public Movie getMovie() {
		return this.movie;
	}
	public void setUser(User user) {
		this.user = user;
	
	}
	public void setOperation(Operation operation) {
		this.operation = operation;
	}
	public void setMovie(Movie movie) {
		this.movie = movie;
	}
	
	@Override
	public String toString() {
		String result = "";
		result += this.user.toString();
		result += this.operation;
		result += this.movie.toString();
		return result;
	}
	
	
}


public class SocSecException extends Exception{
	
	public SocSecException(String error) {
		super("Invalid the social security number, "+error); 
		//displays the type of error that has occurred
	}
}

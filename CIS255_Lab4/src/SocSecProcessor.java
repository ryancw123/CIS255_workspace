import java.util.*;

public class SocSecProcessor{
	static SocSecException ex;
	static String error = " ";

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String name;
		String ssn;
		String cont;
		boolean end=false; //a boolean variable to control the while loop if conditions are met
		while(!end) {
			Scanner input= new Scanner(System.in);
			System.out.println("name?");
			name = input.nextLine();
			System.out.println("SSN?");
			ssn = input.nextLine();
			try {	//the try catch calls on the isValid method 
				isValid(ssn);
				System.out.println(name + " "+  ssn + " is valid");
			}catch(SocSecException e){
				System.out.println(name + " "+  ssn + " is invalid. " + e.getMessage());
			}
			System.out.println("continue?"); //prompts the user if they want to continue or not
			cont=input.nextLine();
			if(cont.equals("n")) {
				end=true;
			}
			
		}
			
	}
	/*
	 * the isValid method checks to see if the social security number is a valid social
	 * security number. isValid throws the exception when a problem is met.
	 */
	public static boolean isValid(String ssn) throws SocSecException {
		boolean valid=true;
		if(ssn.length() != 11) {
			throw new SocSecException("wrong number of characters");
		}else if(ssn.charAt(3) != '-' || ssn.charAt(6) != '-') {
			throw new SocSecException("dashes at wrong position");
		}else {
			for(int x=0;x<ssn.length();x++) {
				if(ssn.charAt(x) == '-' || Character.isDigit(ssn.charAt(x))) {
					continue;
				}else {
					throw new SocSecException("contains a character that is not a number");
				}
			}
		}
		return valid;
	}

}

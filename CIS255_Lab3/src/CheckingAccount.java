
public class CheckingAccount extends BankAccount {
	public static double fee= .15;
	
	//passes on a name and an amount to the super class and sets
	//the account number in the super class to be concatenated with a "-10"
	public CheckingAccount(String name, int initialAmount) {
		super(name, initialAmount);
		super.setAccountNumber(super.getAccountNumber() + "-10");
	}
	
	//calls on the withdraw method in the super class and adds a fee to the withdrawal
	public boolean withdraw(double amount) {
		return super.withdraw(amount+fee);
	}
}


public class SavingsAccount extends BankAccount{
	private double rate = .025;
	private int savingsNumber = 0;
	private String accountNumber;
	
	//concatenates the account number with the savings number with the hyphen
	public SavingsAccount(String name, double initialBalance) {
		super(name, initialBalance);
		accountNumber = super.getAccountNumber()+ "-" + savingsNumber;
	}
	//copy constructor that creates another savings account
	public SavingsAccount(SavingsAccount old, double balance) {
		super(old,balance);
		savingsNumber = old.savingsNumber +1;
		accountNumber = super.getAccountNumber() + "-" + savingsNumber;
	}
	
	//uses a formula to calculate one month worth interest
	public void postInterest() {
		double newBalance= getBalance()*(1+rate/12);
		setBalance(newBalance);
	}
	
	//mutator method to get the accountNumber
	public String getAccountNumber() {
		return accountNumber;
	}
}

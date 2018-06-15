
public class CreditCard {
	private Person owner;
	private Money balance;
	private Money creditLimit;
	
	/*the creditCard constructor is overloaded to accept its own object type.
	 */
	public CreditCard(Person p,Money m) {
		owner=p;
		creditLimit=m;
		balance= new Money(0.0);
	}
	
	public CreditCard(CreditCard x) {
		this.owner=new Person(x.owner);
		this.balance=new Money(x.balance);
		this.creditLimit=new Money(x.creditLimit);
	}
	
	public Money getBalance(){
		return new Money(balance);//creates a copy of the balance
	}
	
	public Money getCreditLimit() {
		return creditLimit;
	}
	
	public String getOwner() {
		return owner.toString();
	}
	
	/*
	 * the charge and payment methods changes the balance of the credit 
	 * card depending on the payment paid or the amount charged.
	 */
	
	public void charge(Money chargeAmount) {
		Money checkBalance=getBalance().add(chargeAmount);
		if(checkBalance.isGreater(creditLimit)) {
			System.out.println("Exceeds credit limit");
		}else {
			balance=balance.add(chargeAmount);
		}
	}
	
	public void payment(Money paymentAmount) {
		balance=balance.subtract(paymentAmount);
	}
	
	/*
	 * Gets the information about the user or the owner of the credit card.
	 */
	public String getPersonals() {
		return getOwner();
	}
}

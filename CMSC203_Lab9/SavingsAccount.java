
public class SavingsAccount extends BankAccount {

	final double rate = 0.025;
	int savingsNumber = 0;
	String accountNumber;
	
	public SavingsAccount(String name, double amount) 
	{
		super(name, amount);
		accountNumber = super.getAccountNumber() + "-" + savingsNumber;
	}
	
	public SavingsAccount(SavingsAccount oldAccount, double amount) 
	{
		super(oldAccount, amount);
		savingsNumber++;
		accountNumber = super.getAccountNumber() + "-" + savingsNumber;
	}
	
	public void postInterest()
	{
		double interest = getBalance() * (rate/12);
		super.setBalance(getBalance()+interest);
	}
	
	public String getAccountNumber()
	{
		return this.accountNumber;
	}

}

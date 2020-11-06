public class CheckingAccount extends BankAccount {

	private static final double FEE = 0.15;
	
	public CheckingAccount(String name, double amount)
	{
		super(name, amount);
		super.setAccountNumber(super.getAccountNumber()+"-10");
	}
	
	public boolean withdraw(double amount) 
	{
		double localAmount = amount + FEE;
		boolean bool = super.withdraw(localAmount);
		return bool;
	}
}

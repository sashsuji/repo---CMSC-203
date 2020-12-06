
public class Coffee extends Beverage {

	//boolean variables that hold
	//whether or not the customer
	//ordered extra shot of coffee
	//and/or extra syrup
	boolean xShot = false;
	boolean xSyrup = false;
	//the additional charges for
	//extra shot of coffee and extra syrup
	final double xShotPrice = 0.5;	
	final double xSyrupPrice = 0.5;
	
	//parameterized constructor that passes
	//name, type, and size to superclass constructor
	//and sets boolean instance variables to the passed in values
	Coffee(String coffeeName, SIZE coffeeSize, boolean extraShot, boolean extraSyrup) {
		super(coffeeName, TYPE.COFFEE, coffeeSize);
		xShot = extraShot;
		xSyrup = extraSyrup;

	}

	//calls toString of Beverage class and adds
	//whether or not customer selected extra shot
	//of coffee and/or extra syrup to the string
	//returns string
	public String toString() 
	{
		String str;
		double price = this.calcPrice();
		str = super.toString() + "\nExtra Shot: " + xShot 
				+ "\nExtra Syrup: " + xSyrup + "\nPrice: $"
				+ price;
		return str;
	}
	
	//sets price to base price of any drink
	//then, it checks for truth of 
	//the instance variable(s) which results in
	//an additional charge(s) and also checks
	//size of drink. Medium = +$1 Large = +$2
	@Override
	public double calcPrice() {
		double coffeePrice = this.basePrice;
		if(xShot == true)
		{
			coffeePrice+=xShotPrice;
		}
		if(xSyrup == true)
		{
			coffeePrice+=xSyrupPrice;
		}
		if(bevSize == SIZE.MEDIUM) 
		{
			coffeePrice+=this.sizePrice;
		}
		if(bevSize == SIZE.LARGE) 
		{
			coffeePrice+=this.sizePrice;
			coffeePrice+=this.sizePrice;
		}
		return coffeePrice;
	}
	
	//calls equals() method of superclass and
	//then checks equality of boolean instance
	//variable(s)
	public boolean equals(Coffee thatCoffee) 
	{
		boolean coffeeIndicator;
		if(super.equals(thatCoffee) == true && this.xShot == thatCoffee.xShot && this.xSyrup == thatCoffee.xSyrup) 
		{
			coffeeIndicator = true;
		}
		else
			coffeeIndicator = false;
		
		return coffeeIndicator;
	}
	
	//returns boolean var xShot
	public boolean getExtraShot() 
	{
		return xShot;
	}

	//returns boolean var xSyrup
	public boolean getExtraSyrup() 
	{
		return xSyrup;
	}

}

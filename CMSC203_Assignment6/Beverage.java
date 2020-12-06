public abstract class Beverage {

	//instance vars that are included in
	//all Beverage subclasses
	String bevName;
	TYPE bevType;
	SIZE bevSize;
	//base price of any drink
	final double basePrice = 2.0;
	//additional charge per size upgrade
	final int sizePrice = 1;
	
	//parameterized constructor that sets
	//name, type, and size of drink
	Beverage(String theName, TYPE theType, SIZE theSize)
	{
		bevName = theName;
		bevType = theType;
		bevSize = theSize;
	}
	
	//stores beverage's name and size in string
	//and then returns that string
	public String toString() 
	{
		String str;
		str = "\nBeverage Name: " + bevName + "\nSize: " + bevSize;
		return str;
	}
	
	//compares two Beverage objects based on
	//names, types, and sizes
	public boolean equals(Beverage thatBev) 
	{
		boolean indicator;
		if(this.bevName.equals(thatBev.bevName) && this.bevType == thatBev.bevType && this.bevSize == thatBev.bevSize) 
		{
			indicator = true;
		}
		else
			indicator = false;
		
		return indicator;
	}
	
	//following are get methods
	//for instance vars
	public double getBasePrice()
	{
		return basePrice;
	}
	
	public String getBevName()
	{
		return bevName;
	}
	
	public SIZE getSize()
	{
		return bevSize;
	}
	
	public TYPE getType()
	{
		return bevType;
	}
	
	//abstract method that forces
	//all subclasses to have
	//a method that calculates
	//the total cost for a drink
	public abstract double calcPrice();

}

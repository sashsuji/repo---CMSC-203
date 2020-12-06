
public class Smoothie extends Beverage {

	//int that stores number of extra fruits ordered
	int xFruit;
	//additional charge per extra fruit
	final double pricePerF = 0.5;
	//boolean that stores whether customer ordered
	//extra protein
	boolean xProtein;
	//additional charge for extra protein
	final double xProteinPrice = 1.5;
	
	//parameterized constructor that passes name, type
	// and size to superclass constructor and sets
	//values of boolean instance variables to parameters
	public Smoothie(String theName, SIZE theSize, int extraFruits, boolean extraProtein) {
		super(theName, TYPE.SMOOTHIE, theSize);
		xFruit = extraFruits;
		xProtein = extraProtein;
	}
	
	//calls toString of Beverage class and adds
	//whether or not customer selected extra fruits
	//and/or extra protein to the string
	//returns string
	public String toString() 
	{
		String str;
		double price = this.calcPrice();
		str = super.toString() + "\nNumber of Fruits Added: " + xFruit 
				+ "\nExtra Protein: " + xProtein + "\nPrice: $" + price;
		return str;
	}

	//sets price to base price of any drink
	//then, it checks for truth of 
	//the instance variable(s) which results in
	//an additional charge(s) and also checks
	//size of drink. Medium = +$1 Large = +$2
	@Override
	public double calcPrice() {
		double smoothiePrice = this.basePrice;
		smoothiePrice+= (xFruit) * (pricePerF);
		if(xProtein == true) 
		{
			smoothiePrice += xProteinPrice;
		}
		if(bevSize == SIZE.MEDIUM) 
		{
			smoothiePrice+=this.sizePrice;
		}
		if(bevSize == SIZE.LARGE) 
		{
			smoothiePrice+=this.sizePrice;
			smoothiePrice+=this.sizePrice;
		}
		return smoothiePrice;
	}
	
	//calls equals() method of superclass and
	//then checks equality of boolean instance
	//variable(s)
	public boolean equals(Smoothie thatSmoothie) 
	{
		boolean smoothieIndicator;
		if(super.equals(thatSmoothie) && this.xFruit == thatSmoothie.xFruit && this.xProtein == thatSmoothie.xProtein) 
		{
			smoothieIndicator = true;
		}
		else
			smoothieIndicator = false;
			
		return smoothieIndicator;
	}
	
	//returns number of extra fruits ordered
	public int getNumOfFruits() 
	{
		return xFruit;
	}

	
	//returns boolean that stores
	//whether or not customer ordered
	//extra protein
	public boolean getAddProtein() 
	{
		return xProtein;
	}
}

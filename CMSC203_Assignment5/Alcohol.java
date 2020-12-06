
public class Alcohol extends Beverage {

	//boolean variable that holds whether or
	//not if the customer ordered alcohol
	//on a weekend day
	boolean isWeekend;
	//extra charge when alcohol is ordered
	//on weekend
	final double weekendPrice = 0.6;
	
	//Parameterized constructor that passes name, type, and size
	//to Beverage superclass constructor and sets boolean 
	//isWeekend to the passed in boolean
	public Alcohol(String theName, SIZE theSize, boolean weekendOrNot) {
		super(theName, TYPE.ALCOHOL, theSize);
		isWeekend = weekendOrNot;
	}
	
	//calls toString of Beverage class and adds
	//whether or not it is a weekend to the string
	//returns string
	public String toString() 
	{
		String str;
		double price = calcPrice();
		str = super.toString() + "\nWeekend: " + isWeekend
				+ "\nPrice: $" + price;
		return str;
	}
	
	//sets price to base price of any drink
	//then, it checks for truth of 
	//the instance variable(s) which results in
	//an additional charge(s) and also checks
	//size of drink. Medium = +$1 Large = +$2
	@Override
	public double calcPrice() {
		double alcoPrice = this.basePrice;
		if(isWeekend == true) 
		{
			alcoPrice+=weekendPrice;
		}
		if(bevSize == SIZE.MEDIUM) 
		{
			alcoPrice+=this.sizePrice;
		}
		if(bevSize == SIZE.LARGE) 
		{
			alcoPrice+=this.sizePrice;
			alcoPrice+=this.sizePrice;
		}
		return alcoPrice;
	}
	
	//calls equals() method of superclass and
	//then checks equality of boolean instance
	//variable(s)
	public boolean equals(Alcohol thatAlco) 
	{
		boolean alcoIndicator;
		if(super.equals(thatAlco) && isWeekend == thatAlco.isWeekend) 
		{
			alcoIndicator = true;
		}
		else
			alcoIndicator = false;
		return alcoIndicator;
	}

}

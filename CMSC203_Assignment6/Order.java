import java.util.ArrayList;


public class Order implements Comparable<Order>, OrderInterface {

	//instance variables
	
	//stores order number in int
	int orderNum;
	//stores day the order was made in enum DAY
	DAY orderDay;
	//stores time the order was made in int
	int time;
	//object of Customer class
	Customer c;
	//arrayList stores all the beverages purchased in
	//a single order
	ArrayList<Beverage> drinksList = new ArrayList<Beverage>();
	
	//parameterized constructor that sets
	//time and order to params. it then initializes
	//the Customer object and passes the param
	//to the copy constructor of the Customer class
	//also calls on random number generator to assign a value
	//to order number int
	Order(int timey, DAY day, Customer o)
	{
		time = timey;
		orderDay = day;
		c = new Customer(o);
		orderNum = randomNum();
	}
	
	//random number generator that picks a number from 1000 to 9000
	public int randomNum() 
	{
		int rando = (int)(Math.random() * ((9000 - 1000 +1)) + 1000);
		return rando;
	}
	
	//returns order number instance var
	public int getOrderNo() 
	{
		return orderNum;
	}
	
	//returns a deep copy of Customer
	//object using Customer class's copy constructor
	public Customer getCustomer() 
	{
		Customer dCopy = new Customer(c);
		return dCopy;
	}

	//returns number of items ordered
	//which is the length of the arrayList
	//that holds the beverages ordered
	public int getTotalItems() 
	{
		return drinksList.size();
	}
	
	//checks if order is being made on weekend
	//by seeing if orderDay is == saturday or sunday (enum)
	@Override
	public boolean isWeekend() {
		if(orderDay == DAY.SATURDAY || orderDay == DAY.SUNDAY) 
		{
			return true;
		}
		else
			return false;
	}

	//adds a new coffee beverage to the order
	//by creating new object of Coffee class and
	//adding to drinksList
	@Override
	public void addNewBeverage(String bevName, SIZE size, boolean extraShot, boolean extraSyrup) {
		Coffee drink = new Coffee(bevName, size, extraShot, extraSyrup);
		drinksList.add(drink);

	}

	//adds a new alcohol beverage to the order
	//by creating new object of Alcohol class and
	//adding to drinksList
	@Override
	public void addNewBeverage(String bevName, SIZE size) {
		boolean weekendOrNot = isWeekend();
		Alcohol drink = new Alcohol(bevName, size, weekendOrNot);
		drinksList.add(drink);
	}

	//adds a new smoothie beverage to the order
	//by creating new object of Smoothie class and
	//adding to drinksList
	@Override
	public void addNewBeverage(String bevName, SIZE size, int numOfFruits, boolean addProtein) {
		Smoothie drink = new Smoothie(bevName, size, numOfFruits, addProtein);
		drinksList.add(drink);
	}

	//stores order number, order day, order time in
	//string object str. str also contain all info of the items
	//ordered which is obtained by a toString() call
	//on all the Beverage objects in drinksList.
	@Override
	public String toString() 
	{
		String str;
		str = "Order Number: " + orderNum + "\nOrder Day: " + orderDay
				+ "\nOrder Time: " + time + "\n" + c.toString();
		for (int i = 0; i< drinksList.size();i++) 
		{
			str += drinksList.get(i).toString();
		}
		str += "\nOrder Total: $" + calcOrderTotal();
		return str;
	}
	
	//returns beverage object in drinksList
	//that is located in the index specified
	//by param
	@Override
	public Beverage getBeverage(int itemNo) {
		return drinksList.get(itemNo);
	}
	
	//calls calcPrice() method of each beverage
	//and adds sum of all individual prices of beverages
	//to a double that stores order total. returns the
	//double
	@Override
	public double calcOrderTotal() {
		double total=0.0;
		for (int i = 0; i< drinksList.size();i++) 
		{
			total += drinksList.get(i).calcPrice();
		}
		return total;
	}

	//finds the # of beverages of a specific type 
	//(specified in parameter) in the current order 
	@Override
	public int findNumOfBeveType(TYPE type) {
		int num = 0;
		for (int i = 0; i< drinksList.size();i++) 
		{
			if(drinksList.get(i).bevType == type) 
			{
				num++;
			}
		}
		return num;
	}

	//returns time that the order was made
	public int getOrderTime() 
	{
		return time;
	}
	
	//returns day that the order was made
	public DAY getOrderDay() 
	{
		return orderDay;
	}
	
	//opted to use the comparable interface
	//a differently than the way specified
	//in the assignment instructions because
	//this new way results in much cleaner code
	/////////////////////////////////////////////
	//used Collections.sort() in bevShop to sort
	//and thus, needed a proper compareTo method
	//which returns the difference between order numbers
	@Override
	public int compareTo(Order o) {
		int compare = ((Order)o).getOrderNo();
		return this.orderNum - compare;
	}
	
}

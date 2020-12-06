import java.util.ArrayList;
import java.util.Collections;

public class BevShop implements BevShopInterfce {

	//int that stores number of alcoholic drinks per order
	private int numOfAlcDrinks = 0;
	//arrayList of orders
	ArrayList<Order> ordersList = new ArrayList<Order>();
	//Order object that represents current order
	Order currentOrder;
	
	//checks if the order is being placed
	//within the open hours of the shop by
	//comparing time parameter to the opening
	//and closing times.
	@Override
	public boolean validTime(int time) {
		if(time>=MIN_TIME && time <= MAX_TIME) 
		{
			return true;
		}
		else
			return false;
	}

	//checks for whether the customer has
	//already ordered the max number
	//of alcoholic beverages by comparing
	//number of alcoholic drinks ordered
	//to max number of alcoholic drinks that
	//are allowed in one order
	@Override
	public boolean eligibleForMore() {
		if(numOfAlcDrinks == MAX_ORDER_FOR_ALCOHOL) 
		{
			return false;
		}
		else
			return true;
	}

	//checks whether the customer
	//is old enough to purchase alcohol
	//by comparing customer age to min
	//age required for alcohol purchase
	@Override
	public boolean validAge(int age) {
		if(age >= MIN_AGE_FOR_ALCOHOL) 
		{
			return true;
		}
		else
			return false;
	}

	//starts new order by instantiating currentOrder
	//instance variable and then initializes it by
	//calling Order class constructor
	//then adds order to arrayList and sets alcoholic 
	//drinks count to 0
	@Override
	public void startNewOrder(int time, DAY day, String customerName, int customerAge) {
		currentOrder = new Order(time, day, new Customer(customerName, customerAge));
		ordersList.add(currentOrder);
		numOfAlcDrinks = 0;
	}

	//calls addNewBeverage method that's made for
	//coffee in the Order class
	@Override
	public void processCoffeeOrder(String bevName, SIZE size, boolean extraShot, boolean extraSyrup) {
		currentOrder.addNewBeverage(bevName, size, extraShot, extraSyrup);

	}

	//calls addNewBeverage method that's made for
	//alcoholic beverages in the Order class
	//also increments # of alcoholic drinks variable
	@Override
	public void processAlcoholOrder(String bevName, SIZE size) {
			numOfAlcDrinks++;
			currentOrder.addNewBeverage(bevName, size);
	}

	//calls addNewBeverage method that's made for
	//smoothie in the Order class
	@Override
	public void processSmoothieOrder(String bevName, SIZE size, int numOfFruits, boolean addProtein) {
		currentOrder.addNewBeverage(bevName, size, numOfFruits, addProtein);

	}

	//returns true only if the argument (the number of fruits) passed
	//is greater than BevShopInterface's MAX_FRUIT field
	public boolean isMaxFruit(int fruitNumber) 
	{
		if(fruitNumber>MAX_FRUIT) 
		{
			return true;
		}
		else
			return false;
	}
	
	//uses Order class method getOrderNo() to
	//compare the orderNo param to the different
	//order numbers in the orders in the drinksList
	//arrayList
	@Override
	public int findOrder(int orderNo) {
		for(int i = 0; i < ordersList.size(); i++) 
		{
			if(ordersList.get(i).getOrderNo() == orderNo) 
			{
				return i;
			}
		}
		return -1;
	}

	//mimics findOrder() with the only difference
	//being that this returns Order class's calcOrderTotal()
	//instead of index
	@Override
	public double totalOrderPrice(int orderNo) {
		for(int i = 0; i < ordersList.size(); i++) 
		{
			if(ordersList.get(i).getOrderNo() == orderNo) 
			{
				return ordersList.get(i).calcOrderTotal();
			}
		}
		return -1;
	}

	//using order class's calcOrderTotal() method,
	//and a for loop that repeats for length of arrayList,
	//finds total sales by summing up all of the sales of 
	//the individual orders
	@Override
	public double totalMonthlySale() {
		double total = 0.0;
		for(int i = 0; i < ordersList.size(); i++) 
		{
			total += ordersList.get(i).calcOrderTotal();
		}
		return total;
	}
	
	//returns length of arrayList which holds
	//all orders
	public int totalNumOfMonthlyOrders() 
	{
		return ordersList.size();
	}

	//uses Comparable interface to complete
	//a selection sort on all orders
	//based on order numbers. strayed a bit from 
	//original method description bc this way
	//is more efficient
	@Override
	public void sortOrders() {
		Collections.sort(ordersList);
	}

	//returns the Order object at the index specified
	//in drinksList
	@Override
	public Order getOrderAtIndex(int index) {
		return ordersList.get(index);
	}
	
	//returns currentOrder instance variable
	public Order getCurrentOrder() 
	{
		return currentOrder;
	}	

	//returns number of drinks on a single order
	public int getNumOfAlcoholDrink() 
	{
		return numOfAlcDrinks;
	}
	
	//returns the max number of alcoholic 
	//drinks per order
	public int getMaxOrderForAlcohol() 
	{
		return MAX_ORDER_FOR_ALCOHOL;
	}
	
	//returns min age to purchase alcohol
	public int getMinAgeForAlcohol() 
	{
		return MIN_AGE_FOR_ALCOHOL;
	}
	
	//stores in a string the total number of orders,
	//total sales. and list of all orders. Does the list of all orders
	//by calling toString() of each order in a for loop
	@Override
	public String toString() 
	{
		String str = "\nTotal Number of Orders This Month: " + 
					totalNumOfMonthlyOrders() + "\nTotal Sales This Month: "
					+ this.totalMonthlySale() + "\nList of Orders:\n\n\n";
		for(int i = 0; i < ordersList.size(); i++) 
		{
			str += ordersList.get(i).toString();
		}
		return str;
	}

}

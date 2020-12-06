
public class Customer {
	
	//Instance variables for customer's name and age
	String name;
	int age;
	
	//parameterized constructor that assigns
	//parameters to name and age
	Customer(String passedName, int passedAge)
	{
		this.name = passedName;
		this.age = passedAge;
	}
	
	//copy constructor - don't have to 
	//worry about data protection
	//because we are dealing with an int
	//and a string object (which is immutable)
 	Customer(Customer otherCust)
	{
		this.name = otherCust.name;
		this.age = otherCust.age;
	}
	
 	//stores customer's name and age in a string and
 	//returns the string
	public String toString() 
	{
		String str;
		str = "Customer Name: " + name + "\nCustomer Age: " + age;
		return str;
	}
	
	//sets name to param
	public void setName(String newName) 
	{
		name = newName;
	}
	
	//sets age to param
	public void setAge(int newAge) 
	{
		age = newAge;
	}
	
	//returns customer's name as a string
	public String getName() 
	{
		return name;
	}
	
	//returns customer's age as an int
	public int getAge() 
	{
		return age;
	}
}

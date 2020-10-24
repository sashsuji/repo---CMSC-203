
public class Property {
	private String city;
	private String owner;
	private String propertyName;
	private double rentAmount;
	private Plot plot;
	
	//default no-arg constructor
	public Property()
	{
		city = "";
		owner = "";
		propertyName = "";
		rentAmount = 0;
		plot = new Plot();
	}
	
	//Copy constructor that produces deep copy of
	//argument
	public Property(Property p)
	{
		city = p.city;
		owner = p.owner;
		propertyName = p.propertyName;
		rentAmount = p.rentAmount;
		plot = p.plot;
	}
	
	//Parameterized Constructor with no Plot data provided
	public Property(String propertyName, String city, double rentAmount, String owner)
	{
		this.propertyName = propertyName;
		this.city = city;
		this.owner = owner;
		this.rentAmount = rentAmount;
		plot = new Plot();
	}
	
	//Parameterized Constructor with Plot data provided
	public Property(String propertyName, String city, double rentAmount, String owner, int x, int y, int width, int depth)
	{
		this.propertyName = propertyName;
		this.city = city;
		this.owner = owner;
		this.rentAmount = rentAmount;
		plot = new Plot(x, y, width, depth);
	}
	
	//returns city
	String getCity()
	{
		return this.city;
	}
	
	//returns owner
	String getOwner()
	{
		return this.owner;
	}
	
	//returns property name
	String getPropertyName()
	{
		return this.propertyName;
	}
	
	//returns rent amount
	double getRentAmount()
	{
		return this.rentAmount;
	}
	
	//returns plot object
	Plot getPlot()
	{
		return plot;
	}
	
	//set Plot values and return Plot instance
	Plot setPlot(int x, int y, int width, int depth)
	{
		this.plot.setX(x);
		this.plot.setY(y);
		this.plot.setWidth(width);
		this.plot.setDepth(depth);
		return this.plot;
	}
	
	//sets city
	void setCity (String city) 
	{
		this.city = city;
	}
	
	//sets owner
	void setOwner (String owner)
	{
		this.owner = owner;
	}
	
	//sets property name
	void setPropertyName (String propertyName)
	{
		this.propertyName = propertyName;
	}
	
	//sets rent amount
	
	void setRentAmount (double rentAmount)
	{
		this.rentAmount = rentAmount;
	}
	
	public String toString() 
	{
		String str = "Property Name: " + this.propertyName + 
					 "\nLocated in " + city + "\nBelonging to: "
					 + owner +"\nRent Amount: " + rentAmount;
		return str;
	}
}

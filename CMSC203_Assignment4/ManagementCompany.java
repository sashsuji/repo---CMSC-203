//Assignment 4 is application that lets the user create a management company and add the properties managed by the company to its list.
//By Sash Sujith


public class ManagementCompany {
	final private int MAX_PROPERTY = 5;
	private double mgmFeePer;
	private String name;
	private Property properties[];
	private String taxID;
	final private int MGMT_WIDTH = 10;
	final private int MGMT_DEPTH = 10;
	private Plot plot;
	
	//default no-arg constructor
	public ManagementCompany() 
	{
		mgmFeePer = 0;
		name = "";
		properties = new Property[MAX_PROPERTY];
		taxID = "";
		plot = new Plot(0, 0, MGMT_WIDTH, MGMT_DEPTH);
	}
	
	//Copy constructor that produces deep copy of
	//argument
	public ManagementCompany(ManagementCompany otherCompany)
	{
		mgmFeePer = otherCompany.mgmFeePer;
		name = otherCompany.name;
		properties = otherCompany.properties;
		taxID = otherCompany.taxID;
		plot = otherCompany.plot;
	}
	
	//Parameterized Constructor with no Plot info
	public ManagementCompany(String name, String taxID, double mgmFee)
	{
		this.name = name;
		this.taxID = taxID;
		this.mgmFeePer = mgmFee;
		properties = new Property[MAX_PROPERTY];
		plot = new Plot(0, 0, MGMT_WIDTH, MGMT_DEPTH);		
	}
	
	//Parameterized Constructor with Plot info
	public ManagementCompany(String name, String taxID, double mgmFee, int x, int y, int width, int depth)
	{
		this.name = name;
		this.taxID = taxID;
		this.mgmFeePer = mgmFee;
		properties = new Property[MAX_PROPERTY];
		plot = new Plot(x, y, width, depth);		
	}
	
	//Creates a property object by copying from another property and 
	//adds it to the "properties" array.
	int addProperty(Property property)
	{
		//checking if array is full
		int count = 0;
		for (int i=0; i< MAX_PROPERTY; i++)
		{
			if (properties[i] != null) 
			{
				count++;
			}
		}
		if(count==5)
		{
			return -1;
		}
				
		//checking if passed object is null
		if (property == null)
		{
			return -2;
		}

		Property addedProperty = new Property(property);
		
		//checking if mgmt company doesn't encompass plot
		if(!(this.plot.encompasses(addedProperty.getPlot())))
		{
			return -3;
		}
		
		//checking if passed property overlaps any other properties.
		Plot plots[] = new Plot[MAX_PROPERTY];
		int number = 0;
		for(int w = 0; w < MAX_PROPERTY; w++)
		{
			if(properties[w]!=null) 
			{
				plots[w]=properties[w].getPlot();
				number++;
			}
		}
		Plot addedPlot = addedProperty.getPlot();
		for(int u = 0; u < number; u++) 
		{
			if (addedPlot.overlaps(plots[u]))
			{
				return -4;
			}
		}
		
		//if passed all requirements, add passed object to array
		for (int i=0; i< MAX_PROPERTY; i++)
		{
			if (properties[i] == null) 
			{
				properties[i] = addedProperty;
				return i;
			}
		}
		return 0;
	}
	
	//Creates a property object with default plot and passed values
	//adds it to the "properties" array.
	int addProperty(String name, String city, double rent, String owner) 
	{
		//checking if array is full
				int count = 0;
				for (int i=0; i< MAX_PROPERTY; i++)
				{
					if (properties[i] != null) 
					{
						count++;
					}
				}
				if(count==5)
				{
					return -1;
				}
						
				//checking if passed objects are null just in case
				if (name == null || city == null || owner == null)
				{
					return -2;
				}

				Property addedProperty = new Property(name, city, rent, owner);
				
				//checking if mgmt company doesn't encompass plot
				if(!(this.plot.encompasses(addedProperty.getPlot())))
				{
					return -3;
				}
				
				//checking if passed property overlaps any other properties.
				Plot plots[] = new Plot[MAX_PROPERTY];
				for(int w = 0; w < MAX_PROPERTY; w++)
				{
					plots[w]=properties[w].getPlot();
				}
				Plot addedPlot = addedProperty.getPlot();
				for(int u = 0; u < MAX_PROPERTY; u++) 
				{
					if (addedPlot.overlaps(plots[u]))
					{
						return -4;
					}
				}
				
				//if passed all requirements, add passed object to array
				for (int i=0; i< MAX_PROPERTY; i++)
				{
					if (properties[i] == null) 
					{
						properties[i] = addedProperty;
						return i;
					}
				}
				return 0;
	}
	
	
	//Creates a property object with default plot and more passed values
	//adds it to the "properties" array.
	int addProperty(String name, String city, double rent, String owner, int x, int y, int width, int depth) 
	{
		//checking if array is full
				int count = 0;
				for (int i=0; i< MAX_PROPERTY; i++)
				{
					if (properties[i] != null) 
					{
						count++;
					}
				}
				if(count==5)
				{
					return -1;
				}
						
				//checking if passed String objects are null just in case
				if (name == null || city == null || owner == null)
				{
					return -2;
				}

				Property addedProperty = new Property(name, city, rent, owner, x, y, width, depth);
				
				//checking if mgmt company doesn't encompass plot
				if((this.plot.encompasses(addedProperty.getPlot())) == false)
				{
					return -3;
				}
				
				//checking if passed property overlaps any other properties.
				Plot plots[] = new Plot[MAX_PROPERTY];
				for(int w = 0; w < MAX_PROPERTY; w++)
				{
					plots[w]=properties[w].getPlot();
				}
				Plot addedPlot = addedProperty.getPlot();
				for(int u = 0; u < MAX_PROPERTY; u++) 
				{
					if (addedPlot.overlaps(plots[u]))
					{
						return -4;
					}
				}
				
				//if passed all requirements, add passed object to array
				for (int i=0; i< MAX_PROPERTY; i++)
				{
					if (properties[i] == null) 
					{
						properties[i] = addedProperty;
						return i;
					}
				}
				return 0;
	}
	
	//Displays the information of the property at index i
	String displayPropertyAtIndex(int i) 
	{
		String str = "Property Name: " + properties[i].getPropertyName() + "\n Located in: "
					+ properties[i].getCity() + "\n Belonging to: " + properties[i].getOwner()
					+ "\n Rent Amount: " + properties[i].getRentAmount();
		return str;
	}
	
	
	//returns MAX_PROPERTY constant that represents the size of the "properties" array.
	int getMAX_PROPERTY() 
	{
		return MAX_PROPERTY;
	}
	
	//finds property that has the maximum rent amount and returns the rent amount.
	double maxRentProp() 
	{
		double rents[] = new double[MAX_PROPERTY];
		for(int i=0; i<MAX_PROPERTY; i++) 
		{
			if(properties[i]!=null)
			{
				rents[i] = properties[i].getRentAmount();
			}
			
		}
		double max = rents[0];
		for(int z=1; z<rents.length; z++)
		{
			if (rents[z] > max)
			{
				max = rents[z];
			}
		}
		return max;
	}
	
	//This method finds the index of the property with the maximum rent amount.
	int maxRentPropertyIndex()
	{
		double rents[] = new double[MAX_PROPERTY];
		for(int i=0; i<MAX_PROPERTY; i++) 
		{
			if(properties[i]!=null)
			{
				rents[i] = properties[i].getRentAmount();
			}
			
		}
		double max = rents[0];
		int index = 0;
		for(int z=1; z<rents.length; z++)
		{
			if (rents[z] > max)
			{
				max = rents[z];
				index = z;
			}
		}
		return index;
		
	}
	
	//accesses each Property object and sums up the property rent and returns the total amount.
	double totalRent() 
	{
		double rents[] = new double[MAX_PROPERTY];
		for(int i=0; i<MAX_PROPERTY; i++) 
		{
			if(properties[i]!=null)
			{
				rents[i] = properties[i].getRentAmount();
			}
			
		}
		double total = 0;
		for(int q=0; q<MAX_PROPERTY;q++)
		{
			total += rents[q];
		}
		return total;
	}
	
	//returns plot
	Plot getPlot() 
	{
		return this.plot;
	}
	
	//returns name
	String getName() 
	{
		return this.name;
	}
	
	//Displays the information of all properties
	public String toString()
	{
		String str = "List of properties for " + name + ", taxID: " + taxID + "\n\n_______________\n";
		double totalRent=0;
		double totalMgmFee;
		for (int b=0; b<MAX_PROPERTY; b++)
		{
			if(properties[b]!=null) 
			{
				str+= "Property Name: " + properties[b].getPropertyName() + "\n Located in: "
						+ properties[b].getCity() + "\n Belonging to: " + properties[b].getOwner()
						+ "\n Rent Amount: " + properties[b].getRentAmount()+"\n";
				totalRent+=properties[b].getRentAmount();
			}
		}
		totalMgmFee = totalRent * (mgmFeePer / 100);
		str+="_______________\nTotal Management Fee: " + totalMgmFee;
		return str;
	}
}

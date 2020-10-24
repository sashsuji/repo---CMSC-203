
public class Plot {
	private int x;
	private int y;
	private int width;
	private int depth;
	
	//Default no-arg constructor
	public Plot()
	{
		x=0;
		y=0;
		width=1;
		depth=1;
	}
	
	//Copy constructor that produces deep copy of
	//argument
	public Plot (Plot p)
	{
		x = p.x;
		y = p.y;
		width = p.width;
		depth = p.depth;
	}
	
	//Constructor that takes data as input
	//and sets them
	public Plot(int x, int y, int width, int depth)
	{
		this.x = x;
		this.y = y;
		this.width = width;
		this.depth = depth;
	}
	
	//determines if this plot overlaps the parameter
	//returns true if the two plots overlap, false otherwise
	boolean overlaps(Plot plot) 
	{
		int currentX1 = this.x;
		int currentY1 = this.y;
		int currentX2 = this.x + this.width;
		int currentY2 = this.y + this.depth;
		int thatX1 = plot.x;
		int thatY1 = plot.y;
		int thatX2 = plot.x + plot.width;
		int thatY2 = plot.y + plot.depth;
		
		if( (thatX1<currentX2 && thatX2 >currentX1) && (thatY1<currentY2 && thatY2 >currentY1) )
		{
			return true;
		}
		else
			return false;
			
	}
	
	//takes a Plot instance and determines if the current plot contains it.
	//is inclusive
	boolean encompasses(Plot plot)
	{
		int currentX1 = this.x;
		int currentY1 = this.y;
		int currentX2 = this.x + this.width;
		int currentY2 = this.y + this.depth;
		int thatX1 = plot.x;
		int thatY1 = plot.y;
		int thatX2 = plot.x + plot.width;
		int thatY2 = plot.y + plot.depth;
		
		if( (currentX1<=thatX1 && currentX2 >=thatX2) && (currentY1<=thatY1 && currentY2 >=thatY2) )
		{
			return true;
		}
		else
			return false;
	}
	
	//sets x value
	void setX (int x)
	{
		this.x = x;
	}
	
	//gets x value
	int getX ()
	{
		return this.x;
	}
	
	//sets y value
	void setY (int y)
	{
		this.y = y;
	}
	
	//gets y value
	int getY()
	{
		return this.y;
	}
	
	//sets width value
	void setWidth (int width)
	{
		this.width = width;
	}
	
	//gets width value
	int getWidth ()
	{
		return this.width;
	}
	
	//sets depth value
	void setDepth (int depth)
	{
		this.depth = depth;
	}
	
	//gets depth value
	int getDepth()
	{
		return this.depth;
	}
	
	//Prints the X,Y of the upper left corner, the width and the depth.
	public String toString()
	{
		String str = "Upper left: (" + this.x + "," + this.y + 
					 "); Width: " + this.width + " Depth: " 
					 + this.depth;
		return str;
	}
}

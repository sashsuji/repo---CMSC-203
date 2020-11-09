
public class HolidayBonus {

	public static double[] calculateHolidayBonus(double[][] data, int high, int low, int other) 
	{
		double bonuses[] = new double[data.length];
		int maxNumOfCols = 0;
		int storeIndexHigh = 0;
		int storeIndexLow = 0;
		
		for(int i = 0; i < data.length; i++) 
		{
			if(data[i].length > maxNumOfCols) 
			{
				maxNumOfCols = data[i].length;
			}
		}
				
		for (int i = 0; i < data.length; i++) 
		{
				for(int j = 0; j < maxNumOfCols; j++) 
				{
					storeIndexHigh = TwoDimRaggedArrayUtility.getHighestInColumnIndex(data, j);
					storeIndexLow = TwoDimRaggedArrayUtility.getLowestInColumnIndex(data, j);
					if(data[i].length > j)
					{
						if(storeIndexHigh ==  i && data[i][j] > 0.0) 
						{
							bonuses[i] += high;
						}
						else if(storeIndexLow == i && data[i][j] > 0.0) 
						{
							bonuses[i] += low;
						}
						else if (i != storeIndexHigh && i != storeIndexLow && data[i][j] > 0.0) 
						{
							bonuses[i] += other;
						}
					}					
				}	
		}	
		return bonuses;	
	}
	
	
	public static double calculateTotalHolidayBonus(double[][] data, int high, int low, int other) 
	{
		double total = 0.0;
		double bonuses[] = new double[data.length];
		bonuses = calculateHolidayBonus(data, high, low, other);
		for(int i = 0; i < bonuses.length; i++) 
		{
			total+=bonuses[i];
		}
		return total;
	}
	
}

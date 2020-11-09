import java.util.Scanner;
import java.io.*;

public class TwoDimRaggedArrayUtility {

	public static double[][] readFile (java.io.File file) throws java.io.FileNotFoundException
	{
		Scanner fileRead = new Scanner(file);

		//checking if file is null
		if (file.length() == 0)
		{
			fileRead.close();
			return null;
		}
		
		//loading doubles into temporary
		//String array
		String temp[][] = new String[10][10];
		for(int i = 0; fileRead.hasNextLine() && i < 10; i++)
		{
			String line = fileRead.nextLine();
			Scanner lineRead = new Scanner(line);
			for(int j=0; lineRead.hasNextDouble() && j < 10; j++)
			{
				double theDouble = lineRead.nextDouble();
				temp[i][j] = "" + theDouble;
			}
			lineRead.close();
		}
		
		fileRead.close();
		
		//row count
		int rowCount = 0;
		for(int r = 0; r<10; r++) 
		{
			if(temp[r][0] != null) 
			{
				rowCount++;
			}
		}

		//create ragged array based on number of rows
		double[][] array = new double[rowCount][];
		
		//Assign column numbers to the rows of array
		for(int q=0;q<rowCount;q++) 
		{
			int colCount = 0;
			for(int e=0; e<10; e++) 
			{
				if(temp[q][e] != null) 
				{
					colCount++;
				}
			}
			array[q] = new double[colCount];
			//fill array
			for (int u = 0; u < colCount; u++) 
			{
				String str = temp[q][u];
				double value = Double.parseDouble(str);
				array[q][u] = value;
			}
		}
		return array;
	}
	
	//writes numbers from given array to the passed file
	public static void writeToFile(double[][] data, java.io.File outputFile) throws java.io.FileNotFoundException
	{
		PrintWriter fileWrite = new PrintWriter(outputFile);
		for(int i = 0; i < data.length; i++)
		{
			for(int j = 0; j < data[i].length; j++) 
			{
				fileWrite.write(data[i][j] + " ");
			}
			fileWrite.println();
		}
		fileWrite.close();
	}
	
	//gets average of all values in matrix
	public static double getAverage(double[][] data) 
	{
		double sum = 0.0;
		int count = 0;
		double average = 0.0;
		for(int i = 0; i < data.length; i++)
		{
			for(int j = 0; j < data[i].length; j++) 
			{
				sum+=data[i][j];
				count++;
			}
		}
		average = (sum/count);
		return average;
	}
	
	//returns the total of all the elements of the two dimensional array
	public static double getTotal(double[][] data) 
	{
			double sum = 0.0;
			for(int i = 0; i < data.length; i++)
			{
				for(int j = 0; j < data[i].length; j++) 
				{
					sum+=data[i][j];
				}
			}
			return sum;
	}
	
	//Returns the total of the selected row in the two dimensional array.
	public static double getRowTotal(double[][] data, int row) 
	{
			double rowSum = 0.0;
			for(int i = 0; i < data[row].length; i++)
			{
				rowSum+=data[row][i];
			}
			return rowSum;
	}
	
	//Returns the total of the selected column in the two dimensional array
	//If a row in the two dimensional array doesn't have this column index, it doesn't participate in this method.
	public static double getColumnTotal(double[][] data, int col) 
	{
			double colSum = 0.0;
			for(int i = 0; i < data.length; i++)
			{
				if(data[i].length > col)
				{
					colSum+=data[i][col];
				}
			}
			return colSum;
	}
	
	//Returns the largest element of the selected row in the two dimensional array
	public static double getHighestInRow(double[][] data, int row) 
	{
			double highest = data[row][0];
			for(int i = 0; i < data[row].length; i++)
			{
				if(data[row][i] > highest)
				{
					highest = data[row][i];
				}
			}
			return highest;
	}
	
	//Returns the index of largest element of the selected row in the two dimensional array 
	public static int getHighestInRowIndex(double[][] data, int row) 
	{
			int highestIndex = 0;
			for(int i = 0; i < data[row].length; i++)
			{
				if(data[row][i] > data[row][highestIndex])
				{
					highestIndex = i;
				}
			}
			return highestIndex;
	}
	
	//Returns the smallest element of the selected row in the two dimensional array
	public static double getLowestInRow(double[][] data, int row) 
	{
			double lowest = data[row][0];
			for(int i = 0; i < data[row].length; i++)
			{
				if(data[row][i] < lowest)
				{
					lowest = data[row][i];
				}
			}
			return lowest;
	}
	
	//Returns the index of the smallest element of the selected row in the two dimensional array
	public static int getLowestInRowIndex(double[][] data, int row) 
	{
			int lowestIndex = 0;
			for(int i = 0; i < data[row].length; i++)
			{
				if(data[row][i] < data[row][lowestIndex])
				{
					lowestIndex = i;
				}
			}
			return lowestIndex;
	}
	
	//Returns the largest element of the selected column in the two dimensional array index 
	//If a row in the two dimensional array doesn't have this column index, it doesn't participate in this method.
	public static double getHighestInColumn(double[][] data, int col) 
	{
			double highest = 0;
			for(int q = 0; q < data.length; q++) 
			{
				if(data[q].length > col) 
				{
					highest = data[q][col];
				}
			}
			for(int i = 0; i < data.length; i++)
			{
				if(data[i].length > col) 
				{
					if(data[i][col] > highest)
					{
						highest = data[i][col];
					}
				}
			}
			return highest;
	}
	
	//Returns the index of the largest element of the selected column in the two dimensional array index 
	//If a row in the two dimensional array doesn't have this column index, it doesn't participate in this method.
	public static int getHighestInColumnIndex(double[][] data, int col) 
	{
			int highestIndex=0;
			for(int q = 0; q < data.length; q++) 
			{
				if(data[q].length > col) 
				{
					highestIndex = q;
				}
			}
			for(int i = 0; i < data.length; i++)
			{
				if(data[i].length > col) 
				{
					if(data[i][col] > data[highestIndex][col])
					{
						highestIndex = i;
					}
				}
			}
			return highestIndex;
	}
	
	//Returns the smallest element of the selected column in the two dimensional array index 
	//If a row in the two dimensional array doesn't have this column index, it doesn't participate in this method.
	public static double getLowestInColumn(double[][] data, int col) 
	{
			double lowest = 0;
			for(int q = 0; q < data.length; q++) 
			{
				if(data[q].length > col) 
				{
					lowest = data[q][col];
				}
			}
			for(int i = 0; i < data.length; i++)
			{
				if(data[i].length > col) 
				{
					if(data[i][col] < lowest)
					{
						lowest = data[i][col];
					}
				}
			}
			return lowest;
	}
	
	//Returns the smallest element of the selected column in the two dimensional array index 
	//If a row in the two dimensional array doesn't have this column index, it doesn't participate in this method.
	public static int getLowestInColumnIndex(double[][] data, int col) 
	{
			int lowest = 0;
			for(int q = 0; q < data.length; q++) 
			{
				if(data[q].length > col) 
				{
					lowest = q;
				}
			}
			for(int i = 0; i < data.length; i++)
			{
				if(data[i].length > col) 
				{
					if(data[i][col] < data[lowest][col])
					{
						lowest = i;
					}
				}
			}
			return lowest;
	}
	
	//Returns the largest element in the two dimensional array
	public static double getHighestInArray(double[][] data) 
	{
		double highest = data[0][0];
		for(int i = 0; i < data.length; i++) 
		{
			if(getHighestInRow(data, i) > highest) 
			{
				highest = getHighestInRow(data, i);
			}
		}
		return highest;
	}
	
	//Returns the smallest element in the two dimensional array
	public static double getLowestInArray(double[][] data) 
	{
		double lowest = data[0][0];
		for(int i = 0; i < data.length; i++) 
		{
			if(getLowestInRow(data, i) < lowest) 
			{
				lowest = getLowestInRow(data, i);
			}
		}
		return lowest;
	}
}

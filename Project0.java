package Project0.java;
import java.util.*;
import java.io.*;

//Add imports as needed

public class Project0 
{	
	public static void main(String[] args) throws FileNotFoundException, IOException
	{
		//Insert your code here
		readFile("test1.in");
	}
	
	public static void readFile(String filename) throws FileNotFoundException, IOException
	{
		FileReader fileReader = new FileReader(filename);
		BufferedReader in = new BufferedReader(fileReader);
		
		while (true)
		{
			String s = in.readLine();
			if (s == null)
				break;
			Scanner scan = new Scanner(s);
			
			while (scan.hasNext())
			{
				System.out.println(scan.nextInt());
			}
			scan.close();
		}
	}
	
}

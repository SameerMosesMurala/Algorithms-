
public class dynamic {
	public static String longestRepeatedSubstring(String inputString)
	{
		int length=inputString.length();
		String result="";
		//convert the input string into a character array
		char[] charArray  = inputString.toLowerCase().toCharArray();
		//Create a lookup table
		int[][] matchtable = new int [length+1][length+1];
		//Intialise the lookup table to zero
		for(int i=0;i<=length;i++)
		{
			for(int j=0;j<=length;j++)
			{
			matchtable[i][j]=0;
			}
		}
		//Fill the lookup table in a bottom manner 
		//Using the values from the smaller subsequences to get values for the larger subsequences
		for(int i=1;i<=length;i++)
		{
			for(int j=1;j<=length;j++)
			{
			//if the charaters match and the indices do not match add the value to the lookup table
				if (charArray[i-1]==charArray[j-1] && i != j)
				{
					matchtable[i][j] = 1 + matchtable[i-1][j-1];
				}
				//if not get the maximum of values present at [i][j-1] and [i-1][j]
				else 
				{
					matchtable[i][j] = Math.max(matchtable[i][j-1], matchtable[i-1][j]);
				}
			}
		}
		int i1=length;
		int j1=length;
		//begin from the bottom of the lookup table
		while (i1 > 0 && j1 > 0)
		{
		//Whenever there is a change of value in the 
		//lookup table get the index value and store the character in the result string  
			if (matchtable[i1][j1] == matchtable[i1-1][j1-1] + 1)
			{
				result += charArray[i1-1];
				i1 -= 1;
			    j1 -= 1;
			}
			else if(matchtable[i1][j1] == matchtable[i1-1][j1])
			{
				i1 -= 1;
			}
			else
			{
				j1 -= 1;
			}
		}
		//reverse the resultant string
		result= new StringBuffer(result).reverse().toString();
		//return the result
		return result;
	}	
	
	public static void main(String[] args)
	{
	//Take the input from the command line
		String input=args[0];
		String result=longestRepeatedSubstring(input);
		//Check whether the input is an invalid input
		if(result.equals("")) 
		{
			System.out.println("Invalid Input");	
		}
		else	
		{
			System.out.println(result.toUpperCase());
		}
		
		
	}
	
}

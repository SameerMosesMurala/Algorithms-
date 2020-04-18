import java.lang.*;
import java.util.*;
public class bruteforce {
	public static String longestRepeatedSubstring(String inputString)
	{
	//Store the Result in a String
		String result="";
		//Create an character array 
		ArrayList<Character> charArray = new ArrayList<Character>();
		//Convert input string into a character array
		 for(int i = 0; i<inputString.length(); i++){
			 charArray.add(inputString.charAt(i));
	       }
		int length=charArray.size();
		//Iteratively search through the input array to find the longest 
		//repeating subsequence
		for(int i=0;i<length;i++)
		{
			char compareChar=charArray.get(i);
			length=charArray.size();
			for(int j=i+1;j<length;j++)
			{
			//compare the characters and see that the indices are not overlapping
				if(compareChar==charArray.get(j))
				{
					result=result+compareChar;
					charArray.remove(j);
					break;
				}
			}
			//Exhaust through the input character array
			length=charArray.size();
		}
		return result;
	}
	public static void main(String[] args) 
    { 
		//Take the input from the command line
		String s=args[0];
        String result=longestRepeatedSubstring(s);
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

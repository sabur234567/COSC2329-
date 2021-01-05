package dominoes;

import java.util.ArrayList;
import java.util.Set;

public class DominoHighLowImpl_Khan implements Domino {
	private int highPipCount;
	private int lowPipCount;
	
	public DominoHighLowImpl_Khan(int highPipCount,int lowPipCount)
	{		
		assert highPipCount <= MAXIMUM_PIP_COUNT && highPipCount >= MINIMUM_PIP_COUNT : "High Pip Count is not in range";
		assert lowPipCount <= MAXIMUM_PIP_COUNT && lowPipCount >= MINIMUM_PIP_COUNT : "Low Pip Count is not in range";
		
		this.highPipCount = highPipCount;
		this.lowPipCount = lowPipCount;
	}
	
	
	public static final char HIGH_LOW_STRING_SEPERATOR = ':';
	// gets the index of the domino... should always have length of 3
	public static boolean isHighLowString(String str)
	{
		if (str.length()!=3)
		{
			return false;
		}
		char [] allowedChars = new char [] {'0','1','2','3','4','5','6'};
		char firstIndex = str.charAt(0);
		boolean firstIndexValid = false;
		for(int i=0; i< allowedChars.length; i++)
		{
			if ( allowedChars[i]== firstIndex)
			{
				firstIndexValid = true;
				break;
			}
		}
		
		boolean secondIndexValid = false;
		char secondIndex = str.charAt(1);
		if(secondIndex == HIGH_LOW_STRING_SEPERATOR)
		{
			secondIndexValid = true;
		}
		
		char thirdIndex = str.charAt(2);
		boolean thirdIndexValid = false;
		for(int i=0; i< allowedChars.length; i++)
		{
			if ( allowedChars[i]== thirdIndex)
			{
				thirdIndexValid = true;
				break;
			}
		}
		if(firstIndexValid == true && secondIndexValid == true && thirdIndexValid == true)
		{
			int high = (int)str.charAt(0);
			int low = (int)str.charAt(2);
			if(high>low)
				return true;
			else
			{
				return false;
			}
		}
		else
		{
			return false;
		}
	}
	// isHighLowString(highLowString) = true  
	// a highLowString returns a domino instance of isHighLowString
	public DominoHighLowImpl_Khan(String highLowString)
	{
		assert isHighLowString(highLowString) : "invalid highLowString";
		
		char hpc = highLowString.charAt(0);
		char lpc  = highLowString.charAt(2);
		highPipCount = Integer.parseInt(String.valueOf(hpc));
		lowPipCount = Integer.parseInt(String.valueOf(lpc));

	}
	
	public static final int INDEX_OF_SUM =0;
	public static final int INDEX_OF_DIFFERENCE = 1;
	//part of pre: sumDifference.length==2
	//part of pre: sumDifference[INDEX_OF_SUM] >= sumDifference[INDEX_OF_DIFFERENCE]
	//high = low+diff
	public DominoHighLowImpl_Khan(int[] sumDifference)
	{
		int sum = sumDifference[0];
		int difference = sumDifference[1];
		boolean validDomino = false;
		int low =0;
		int high=0;
		while(validDomino==false && low<=MAXIMUM_PIP_COUNT)
		{
			high= low+difference;
			if(low+high==sum && high-low==difference)
			{
				validDomino=true;
				break;
			}
			low++;
		}
		this.highPipCount = high;
		this.lowPipCount = low;
			
	}
	
	// part of pre: 1<= highLowSet.size() <= 2
	// part of pre: ! highLowSet.contains(null)
	public DominoHighLowImpl_Khan(Set<Integer> highLowSet)
	{
		assert highLowSet != null : "HighLowSet is invalid";
		assert highLowSet.size() ==1 || highLowSet.size()==2 : "Invalid size of highLowSet";
		
		ArrayList<Integer> intList = new ArrayList<Integer>(highLowSet);
	
		if (intList.size()==1)
		{
			this.highPipCount= intList.get(0);
			this.lowPipCount = highPipCount;
		}
		else
		{
			int first = intList.get(0);
			int second = intList.get(1);
			if(first>second)
			{
				this.highPipCount=first;
				this.lowPipCount=second;
			}
			else
			{
				this.highPipCount=second;
				this.lowPipCount= first;
			}
		}
	}
	public DominoHighLowImpl_Khan(int highPipCountDivisionBy2Quotient, int highPipCountDivisionBy3Remainder, int lowPipCountDivisionBy2Quotient, int lowPipCountDivisionBy3Remainder)
	{
		assert highPipCountDivisionBy2Quotient >= 0 && highPipCountDivisionBy2Quotient <= 3:
			"Invalid " + highPipCountDivisionBy2Quotient ;
		
		assert highPipCountDivisionBy3Remainder >= 0 && highPipCountDivisionBy3Remainder <= 2:
			"Invalid " + highPipCountDivisionBy3Remainder;
		
		assert lowPipCountDivisionBy2Quotient >= 0 && lowPipCountDivisionBy2Quotient <= 3: 
			"Invalid " + lowPipCountDivisionBy2Quotient;
		
		assert lowPipCountDivisionBy3Remainder >= 0 && lowPipCountDivisionBy3Remainder <= 2:
			"Invalid " + lowPipCountDivisionBy3Remainder;
		
		boolean validHpc = false;
		boolean validLpc = false;
		
		int high = 0;
		int low= 0;
		
		boolean hpcDivBy2 = false;
		boolean hpcDivBy3Remainder = false;
		
		while(validHpc==false)
		{
			if(high/2==highPipCountDivisionBy2Quotient)
			{
				hpcDivBy2 = true;
			}
			else
			{
				hpcDivBy2 = false;
			}
			if(high%3==highPipCountDivisionBy3Remainder)
			{
				hpcDivBy3Remainder = true;
			}
			else
			{
				hpcDivBy3Remainder= false;
			}
			if(hpcDivBy2== true && hpcDivBy3Remainder== true)
			{
				validHpc =true;
			}
			else {
				high=high+1;
			}
		}
		
		boolean lpcDivBy2 = false;
		boolean lpcDivBy3Remainder = false;
		
		while(validLpc==false)
		{
			if(low/2==lowPipCountDivisionBy2Quotient)
			{
				lpcDivBy2 = true;
			}
			else
			{
				lpcDivBy2 = false;
			}
			if(low%3==lowPipCountDivisionBy3Remainder)
			{
				lpcDivBy3Remainder = true;
			}
			else
			{
				lpcDivBy3Remainder= false;
			}
			if(lpcDivBy2== true && lpcDivBy3Remainder== true)
			{
				validLpc =true;
			}
			else {
				low=low+1;
			}
		}
		this.highPipCount = high;
		this.lowPipCount = low;
	}
	
	public int getHighPipCount() {
		return highPipCount;
	}

	public int getLowPipCount() {
		return lowPipCount;
	}

}

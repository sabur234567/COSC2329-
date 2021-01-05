package dominoes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class DominoHighLowSetImpl_Khan implements Domino{

	private Set<Integer> highLowSet;
	
	public DominoHighLowSetImpl_Khan(int highPipCount, int lowPipCount)
	{
		assert highPipCount <= MAXIMUM_PIP_COUNT && highPipCount >= MINIMUM_PIP_COUNT : "High Pip Count is not in range";
		assert lowPipCount <= MAXIMUM_PIP_COUNT && lowPipCount >= MINIMUM_PIP_COUNT : "Low Pip Count is not in range";
		
		highLowSet = new HashSet<>(Arrays.asList(highPipCount, lowPipCount));
	}
	
	public static final char SUM_DIFFERENCE_DELIMITER = ',';
	
	public static boolean isSumDifferenceString(String str)
	{
		if (str.length() != 3 && str.length() != 4) 
			return false;	
		if(str.length() == 3)
		{
			char sumChar = str.charAt(0);
			char deliChar = str.charAt(1);
			char diffChar = str.charAt(2);
			
			boolean checkDigits = Character.isDigit(sumChar) && Character.isDigit(diffChar);
			
			if(checkDigits == false)
				return false;
			if(deliChar != SUM_DIFFERENCE_DELIMITER)
				return false;
			
			int sum = Integer.parseInt(String.valueOf(sumChar)); 
			int diff = Integer.parseInt(String.valueOf(diffChar));
			
			boolean diffGreaterSum = sum<diff;
			if(diffGreaterSum)
				return false;
			
			boolean evenCheck = sum%2==0 && diff%2!=0;
			if(evenCheck)
				return false;
			
			boolean oddCheck = sum%2!=0 && diff%2==0;
			if(oddCheck)
				return false;
			
			boolean highGreaterThanMax = (sum+diff)/2 > MAXIMUM_PIP_COUNT; //he changes max so set it to max_pip_count
			if(highGreaterThanMax)
				return false;
			
		}
		
		if(str.length() == 4)
		{
			char sumChar = str.charAt(0);
			char sumChar2 = str.charAt(1);
			char deliChar = str.charAt(2);
			char diffChar = str.charAt(3);
			
			boolean checkDigits = Character.isDigit(sumChar) && Character.isDigit(diffChar) && Character.isDigit(sumChar2);
			
			if(checkDigits == false)
				return false;
			if(deliChar != SUM_DIFFERENCE_DELIMITER)
				return false;
			
			String sumStr = String.valueOf(sumChar) + String.valueOf(sumChar2);
			int sum = Integer.valueOf(sumStr);
			int diff = Integer.parseInt(String.valueOf(diffChar));
			
			if(sum>12) //above max
				return false;
			
			boolean diffGreaterSum = sum<diff;
			if(diffGreaterSum)
				return false;
			
			boolean evenCheck = sum%2==0 && diff%2!=0;
			if(evenCheck)
				return false;
			
			boolean oddCheck = sum%2!=0 && diff%2==0;
			if(oddCheck)
				return false;
			
			boolean highGreaterThanMax = (sum+diff)/2 > MAXIMUM_PIP_COUNT; //he changes max so set it to max_pip_count
			if(highGreaterThanMax)
				return false;
		}
		return true;
	}
	
	public DominoHighLowSetImpl_Khan(String sumDifferenceString)
	{
		assert isSumDifferenceString(sumDifferenceString) : "Invalid sumDifferenceString "+ sumDifferenceString;
		{
			int low = -1;
			int high = -1;
			if(sumDifferenceString.length() == 3) 
			{
				char sumChar = sumDifferenceString.charAt(0);
				char delimiterChar = sumDifferenceString.charAt(1);
				char diffChar = sumDifferenceString.charAt(2);
				
				int sum = Integer.parseInt(String.valueOf(sumChar)); 
				int diff = Integer.parseInt(String.valueOf(diffChar));	
				
				boolean validDomino = false;
				if(sumDifferenceString.length() == 3) 
				{
					while(validDomino==false && low<=MAXIMUM_PIP_COUNT)
					{
						low++;
						high = low + diff;
						if(low+high==sum && high<=MAXIMUM_PIP_COUNT)
						{
							validDomino = true;
						}
					}
				}
			}
			else //length of 4
			{
			String sumStr = String.valueOf(sumDifferenceString.charAt(0)) +  String.valueOf(sumDifferenceString.charAt(1));
			int totalSum = Integer.parseInt(sumStr);
			char diffChar2 = sumDifferenceString.charAt(3);
			int diff2 = Integer.parseInt(String.valueOf(diffChar2));
			
			boolean validDomino2 = false;
			while(validDomino2==false && low <= MAXIMUM_PIP_COUNT)
			{
				low++;
				high = low + diff2;
				if(low+high== totalSum && high<=MAXIMUM_PIP_COUNT)
				{
					validDomino2 = true;
				}
			}
			}
			highLowSet = new HashSet<Integer>();
			highLowSet.add(high);
			highLowSet.add(low);
		}

	}
	//low+(8*high)
	// 36 = 4+(8*4) 
	public static boolean isLowPlus8TimesHighInteger(int k)
	{	
		int max = MAXIMUM_PIP_COUNT + (8 * MAXIMUM_PIP_COUNT);
		if(k>max)
			return false;
		boolean retValue = false;
		int low = 0;
		int high = 0;
		for(low =0; low<=6; low++)
		{
			for(high=low; high<=6;high++)
			{
				if(low+(8*high)==k)
				{
					retValue = true;
					break;
				}
			}
		}
		return retValue;
	}
	public DominoHighLowSetImpl_Khan(int lowPlus8TimesHigh)
	{
		assert isLowPlus8TimesHighInteger(lowPlus8TimesHigh) : "Invalid, "+ lowPlus8TimesHigh;
		
		highLowSet = new HashSet<Integer>();
		int lowPipCount = lowPlus8TimesHigh % 8;
		int highPipCount = (lowPlus8TimesHigh - lowPipCount) / 8;
		
		highLowSet.add(highPipCount);
		highLowSet.add(lowPipCount);
	}
	
	public int getHighPipCount() 
	{	
		int highPipCount = 0;
		ArrayList<Integer> intList = new ArrayList<Integer>(highLowSet);
		if (intList.size()==1)
		{
			highPipCount= intList.get(0);
		}	
		else
		{
			int first = intList.get(0);
			int second = intList.get(1);
			if(first>second)
			{
				highPipCount = first;
			}
			else
			{
				highPipCount = second;
			}
		}
		return highPipCount;
	}

	public int getLowPipCount()
	{
		int lowPipCount = 0;
		ArrayList<Integer> intList = new ArrayList<Integer>(highLowSet);
		if (intList.size()==1)
		{
			lowPipCount= intList.get(0);
		}	
		else
		{
			int first = intList.get(0);
			int second = intList.get(1);
			if(first<second)
			{
				lowPipCount = first;
			}
			else
			{
				lowPipCount = second;
			}
		}
		return lowPipCount;
	}

}

package dominoes;

import java.util.List;

public class DominoLowDifferenceStringImpl_Khan implements Domino {
	
	private String lowDifferenceString;
	private static final char LOW_DIFFERENCE_DELIMITER = '*';
	
	public static boolean isLowPlus8TimesHighInteger(int k)
	{
		int max = MAXIMUM_PIP_COUNT + (8 * MAXIMUM_PIP_COUNT);
		if(k>max || k<0)
		{
			return false;
		}
		for(int low = 0; low <= 6; low++)
		{
			for(int high = 0; high <= 6; high++)
			{
				if(low+(8* high) == k)
				{
					return true;
				}
			}
		}
		return false;
	}
	//pre: isLowPlus8TimesHighInteger = True, 
	//low+delimiter+high-low because you need to find difference on last index
	//converting int --> string... use Integer.toString
	public DominoLowDifferenceStringImpl_Khan(int lowPlus8TimesHigh)
	{
		assert isLowPlus8TimesHighInteger(lowPlus8TimesHigh) : "Invalid, " + lowPlus8TimesHigh;

		int validHigh = -1;
		int validLow = -1;
		boolean validDomino = false;
		while(validDomino==false) 
		{
			for(int low = 0; low<=6; low++)
			{
				for(int high = low; high<=6; high++)
				{
					if(low+(8 * high) ==lowPlus8TimesHigh)
					{
						validDomino = true;
						validHigh = high;
						validLow = low;
					}
				}
			}
		}
		this.lowDifferenceString = Integer.toString(validLow) + LOW_DIFFERENCE_DELIMITER + Integer.toString(validHigh - validLow);
	}
	public static final int INDEX_OF_HIGH=0;
	public static final int INDEX_OF_SUM=1;
	//pre: has to have length of 2 since its a list
	//[HPC, high+low]
	public DominoLowDifferenceStringImpl_Khan(List<Integer>highSum)
	{
		assert highSum != null;
		assert highSum.size() == 2 : "Invalid, " + highSum.size();

		int highPipCount = highSum.get(INDEX_OF_HIGH);
		int sum = highSum.get(INDEX_OF_SUM);
		int lowPipCount = sum- highPipCount;

		String lowStr = Integer.toString(lowPipCount);
		String diffStr = Integer.toString(highPipCount-lowPipCount);
		this.lowDifferenceString= lowStr+LOW_DIFFERENCE_DELIMITER+ diffStr;
		
	}
	
	public int getHighPipCount() {	
		char lowPipCountChar = lowDifferenceString.charAt(0);
		int lowPipCount =  Integer.parseInt(String.valueOf(lowPipCountChar));
		
		char diffChar = lowDifferenceString.charAt(2);
		int diff =Integer.parseInt(String.valueOf(diffChar));
		int highPipCount = lowPipCount+diff;
		return highPipCount;
	}
	@Override
	public int getLowPipCount() {
		char lowPipCountChar = lowDifferenceString.charAt(0);
		int lowPipCount =  Integer.parseInt(String.valueOf(lowPipCountChar));
		return lowPipCount;
	}
	
}

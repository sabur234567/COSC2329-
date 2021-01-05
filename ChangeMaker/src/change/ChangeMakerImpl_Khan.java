package change;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;


public class ChangeMakerImpl_Khan implements ChangeMaker
{	
	
	private List<Integer> denominationList;
	
	//part of pre: i <= 0 ==> !denominations.contains(i)
	//Student should figure out other parts of the precondition
	public ChangeMakerImpl_Khan(Set<Integer> denominations)
	{
		assert denominations != null;
		assert !denominations.contains(null);
		assert !denominations.contains(0);
		assert denominations.size() > 0;
		assert checkNegative(denominations);
		
		denominationList = new ArrayList<>();
		denominationList.addAll(denominations);
		
		Collections.sort(denominationList); // least-greatest
		Collections.reverse(denominationList); // greatest-least
	}
	public boolean checkNegative(Set<Integer> denomList)
	{
		for(int value :denomList)
		{
			if(value <= 0)
				return false;
		}
		return true;
	}

	public List<Integer> getDenominations()
	{
		return denominationList;
	}
	
	public boolean canMakeExactChange(int valueInCents)
	{
		boolean canMakeChange = true;
		if(valueInCents ==0 )
			return true;
		for(int i=0;  i<denominationList.size();i++)
		{
			int denominationVal = valueInCents / denominationList.get(i);
			valueInCents -= denominationVal * denominationList.get(i);
		}
		if(valueInCents != 0)
		{
			canMakeChange = false;
		}
		return canMakeChange;
	}
	
	public int calculateValueOfChangeList(List<Integer> changeList)
	{
		assert !changeList.contains(null);
		assert changeList != null;
		assert changeList.size( )== denominationList.size();
		
		int value=0;
		for(int i=0; i<changeList.size(); i++)
		{
			value = value + (changeList.get(i)* denominationList.get(i));
		}
		return value;
	}

	public List<Integer> getExactChange(int valueInCents)
	{
		assert valueInCents >= 0;
		assert canMakeExactChange(valueInCents);
		
		List<Integer> changeList = new ArrayList<Integer>();
		
		for(int currentValue : denominationList)
		{
			int exact = 0;
			
			while(valueInCents - currentValue >= 0)
			{
				valueInCents -= currentValue;
				exact++;
			}
			changeList.add(exact);
		}
		return changeList;
	}
	
	public String toString()
	{
		throw new RuntimeException("NOT IMPLEMENTED YET!");
	}
}

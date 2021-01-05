package utils;

import java.awt.List;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public interface IntegerUtils_Khan {
	// This function will determine if integer k is even by returning T/F. If 0 is entered, it will return false. 
	// pre: integer k is a positive int that is not null
	// post: returns true or false depending on if k is even.
	// Straightforward: IntegerUtils_Khan.isEven(2)
	// Extreme: IntegerUtils_Khan.isEven(-4)
	// Bizarre/exotic: IntegerUtils_Khan.isEven(0)
	public static boolean isEven(int k)
	{
		boolean isEven = true;
		if(k%2==1 || k%2==-1)
		{
			isEven= false;
		}
		if(k==0)
		{
			return !isEven;
		}
		return isEven;
	}
	// This function will determine if integer k is odd by returning a boolean variable (T/F). If 0 is entered, it will return false. 
	//pre: integer k is a positive int that is not null
	//post: returns true or false depending on if k is odd.
	// Straightforward: IntegerUtils_Khan.isOdd(1)
	// Extreme: IntegerUtils_Khan.isOdd(-3)
	// Bizarre/exotic: IntegerUtils_Khan.isOdd(0)
	public static boolean isOdd(int k)
	{
		boolean isOdd = true;
		if(k%2==0)
		{
			isOdd= false;
		}
		if(k==0)
		{
			return !isOdd;
		}
		return isOdd;
	}
	// This function will determine if integer k is prime by returning a boolean variable (T/F). If k is less than or equal to 1 then automatic false.  
	// Otherwise loop from 2 until k/2 and increment by one then check if k is divisible by any of those numbers. If it is then it is not prime.
	//pre: k is an integer and does not come in as null
	//post: True/False depending on if k is a prime #
	// Straightforward: IntegerUtils_Khan.isPrime(10)
	// Extreme: IntegerUtils_Khan.isPrime(2048)
	// Bizarre/exotic: IntegerUtils_Khan.isPrime(0)
	public static boolean isPrime(int k)
	{
		boolean isPrime = true;
		if(k==1 || k<=0)
		{
			return !isPrime;
		}
		for(int index=2; index<=k/2; index++)
		{
			if(k%index==0)
			{
				return !isPrime;
			}
		}
		return isPrime;
	}
	// This function will determine the GCD of m,n. Loop through the smaller # and check for numbers divisible into both m,n. The number that is greatest in the counter of the loop will be GCD.
	// pre: m,n are both integers
	// post: returns an integer that is gcd of m,n.
	// Straightforward: IntegerUtils_Khan.greatestCommonFacter(1,5)
	// Extreme: IntegerUtils_Khan.greatestCommonFacter(-2,-6)
	// Bizarre/exotic: IntegerUtils_Khan.greatestCommonFacter(0,0)
	public static int greatestCommonFactor(int m, int n)
	{
		int gcd =0;
		if(m==0)
			return n;
		if(n==0)
			return m;
		if(m<0)
			m= m*-1;
		if(n<0)
			n = n*-1;
		for(int i = 1; i <= m && i <= n; i++)
		{
			if(m % i==0 && n % i==0)
				gcd = i;
		}
		return gcd;
	}
	//Find the greatest multiple of k that can reach up until the maximum value.For loop starting from k up until maximum with the increment of +=k.
	//pre: k and maxiumum are cominng in as integers
	//post: returns an integer that is closest to maximum but is a multiple of k.
	// Straightforward: IntegerUtils_Khan.getGreatestConstrainedMultiple(1,5)
	// Extreme: IntegerUtils_Khan.getGreatestConstrainedMultiple(10,9)
	// Bizarre/exotic: IntegerUtils_Khan.getGreatestConstrainedMultiple(-3,10)
	public static int getGreatestConstrainedMultiple(int k, int maximum)
	{
		if(k==0 || maximum ==0)
			return 0;
		if(k<=maximum)
		{
			for(int i = maximum; i>0; i--)
			{
				if(i%k==0)
				{
					return i;
				}
			}
		}
		for(int i = maximum; i<0; i++)
		{
			if(i%k==0)
			{
				return i;
			}
		}
		return 0;
	}
	// This function has to have an integer that leads to h_q_3 to be equal to that integer divisible by 3. At the same time 5
	// divides that same integer and if the remainder is equal to h_r_5 then the integer should be returned.
	//pre:  The integers in the parameters can either be both positive or both negative
	//post: returns an int that is divisible by 3 and when divided by 5 the remainder is equal to the integer h_r_5.
	// Straightforward: IntegerUtils_Khan.getIntegerH(4,12)
	// Extreme: IntegerUtils_Khan.getIntegerH(-7,-1)
	// Bizarre/exotic: IntegerUtils_Khan.getIntegerH(0,0)
	public static int getIntegerH(int h_q_3, int h_r_5)
	{
		int q3 = h_q_3*3;
		int q4 = h_q_3 *4;
		int mod = 0;

		int retVal = -1;

		if(q3 <=0 && q4<=0)
		{
			for(int i =q4; i<=q3; i--)
			{
				mod = (i%5);
				if(mod== h_r_5 && (i/3)*-1== h_q_3)
				{
					retVal = i;
				}
			}
		}
		if(q3 >=0 && q4>=0)
		{
			for(int i =q4; i>=q3; i--)
			{
				mod = (i%5);
				if(mod== h_r_5 && i/3== h_q_3)
				{
					retVal = i;
				}
			}
		}
		return retVal;
	}
	// This function will get the max integer from the set
	//pre: integerSet is coming in as not null and not empty (size of 0).
	//post: returns a integer that is represented as the max in the set
	// Straightforward: IntegerUtils_Khan.getMaximum({5,6,7,8,9,10)
	// Extreme: IntegerUtils_Khan.getMaximum({-3000})
	// Bizarre/exotic: IntegerUtils_Khan.getMaximum({null})
	public static int getMaximum(Set<Integer> integerSet)
	{
		ArrayList<Integer> intList = new ArrayList<Integer>(integerSet);
		int max = intList.get(0);
		for (int i = 1; i < intList.size(); i++) 
			if (intList.get(i) > max) 
				max = intList.get(i);	
		return max;

	}
	// Create a return variable to represent the minimum value. Check for length of 1 variable. Otherwise loop through the list to find the least valued int.
	//pre: An array of integers with at least of length of 1. 
	//post: Returns the integer with the least value inside the list.
	//Straightforward: IntegerUtils_Khan.getMinimum([2,4,5,6,8])
	// Extreme: IntegerUtils_Khan.getMinimum([10])
	// Bizarre/exotic: IntegerUtils_Khan.getMinimum([])
	public static int getMinimum(int[] intArray)
	{
		int min =0;
		int retVal = 0;
		if(intArray.length==0)
			return -1;
		if(intArray.length==1)
			return intArray[0];
		retVal=intArray[0];
		for(int i=0; i<intArray.length; i++)
		{
			min = intArray[i];
			if(min<=retVal)
				retVal=min;
		}
		return retVal;

	}
	// This function will see if intArray is sorted in ascending order. Increment by i+1 in order to check the element in front of the index. Use length-1 to test all the way.
	//pre: A list coming in as not null
	//post: Returns true or false depending if the list is sorted in ascending order.
	//Straightforward: IntegerUtils_Khan.isSorted([-2,5,6,7,8,9,10])
	// Extreme: IntegerUtils_Khan.isSorted([10,10,10,10])
	// Bizarre/exotic: IntegerUtils_Khan.isSorted([]) --> should return true
	public static boolean isSorted(int[] intArray)
	{
		boolean isSorted = true;
		int check = 0;
		if(intArray.length >=0)
		{
			for(int i=0; i<intArray.length-1; i++)
			{
				check = intArray[i];
				if(check<=intArray[i+1])
					continue;
				else
				{
					return !isSorted;
				}
			}
		}
		return isSorted;

	}
	//This function will loop inside of intArray and find the first int that is equal to target then output that integer.
	//pre: intArray is an integer of integers and is not null, target represents a int that is not null to look for inside intArray
	//post: return the int located first that is equal to target inside intArray.
	//Straightforward: IntegerUtils_Khan.getSmallestIndexOfMatch([-2,5,6,7,8,9,10],5)
	// Extreme: IntegerUtils_Khan.getSmallestIndexOfMatch([5],0)
	// Bizarre/exotic: IntegerUtils_Khan.getSmallestIndexOfMatch([null],7) 
	public static int getSmallestIndexOfMatch(int[] intArray, int target)
	{
		int count = -1;
		if(intArray.length >=0)
		{
			for(int i=0; i<intArray.length; i++)
			{
				if(intArray[i]==target)
				{
					count = i;
					break;
				}
			}	
		}
		return count;

	}
	//This function will take in a integer then flip it to show the reversed version of it.  (84) -->(48)
	// divide by 10 in order to pick out the remainder by mod and reduce the integer digit by digit. Then multiply it back into the reversedInt variable by *=10. 
	//pre: This function will take in a positive integer that is only a 2 digit number.
	//post: returns the reversed version of integer k.
	//Straightforward: IntegerUtils_Khan.reverse(12)
	// Extreme: IntegerUtils_Khan.reverse(100)
	// Bizarre/exotic: IntegerUtils_Khan.reverse(-12)
	public static int reverse(int k)
	{

		int reverseInt = 0;
		while(k!=0)
		{
			int digits = k%10;
			reverseInt = reverseInt* 10+ digits;
			k/=10;
		}
		return reverseInt;
	}
	//This function will get the digits from the integer and add them together. If the sum is equal to another 2 digit number then repeat.
	//pre: k comes in as a positive integers
	//post: returns the sum of the digits 
	//Straightforward: IntegerUtils_Khan.sumthing(12)
	// Extreme: IntegerUtils_Khan.sumthing(29)
	// Bizarre/exotic: IntegerUtils_Khan.sumthing(-158)
	public static int sumthing(long k)
	{
		int n = 0;
		int sum =0;
		
		while(k !=0)
		{
			n = (int) (k % 10);
			sum = sum + n;
			k = k / 10;
		}
		if(sum>9)
		{
			k = sum;
			sum = 0;
			while(k!=0)
			{
				n = (int) (k % 10);
				sum = sum + n;
				k = k / 10;
			}
		}
		return sum;
	}	

}

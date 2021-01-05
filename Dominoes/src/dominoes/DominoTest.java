package dominoes;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.Test;
import dominoes.DominoHighLowImpl_Khan;
import dominoes.DominoHighLowSetImpl_Khan;

class DominoTest {

	@Test
	void testDominoHighLowInput() 
	{
		System.out.println("NOW TESTING DOMINO HIGH LOW INPUT WITH TWO INTS");
		int high = 4;
		int low = 3;
		Domino domino1 = new DominoHighLowImpl_Khan(high,low);
		int assertHigh = domino1.getHighPipCount();
		int assertLow = domino1.getLowPipCount();
		assertEquals(assertHigh, 4);
		assertEquals(assertLow, 3);
		System.out.println("TEST SUCCESFULLY COMPLETED");
	}
	
	@Test
	void testDominoIsHighLowString()
	{
		System.out.println("NOW TESTING ISHIGHLOWSTRING");
		String highLowString = "4:3";
		boolean assertThis = DominoHighLowImpl_Khan.isHighLowString(highLowString);
		assertTrue(assertThis);
		
		highLowString = "9:5";
		assertThis = DominoHighLowImpl_Khan.isHighLowString(highLowString);
		assertFalse(assertThis);
		
		highLowString = "a:6";
		assertThis = DominoHighLowImpl_Khan.isHighLowString(highLowString);
		assertFalse(assertThis);
		
		highLowString = "2:1 ";
		assertThis = DominoHighLowImpl_Khan.isHighLowString(highLowString);
		assertFalse(assertThis);
		
		highLowString = "2,1";
		assertThis = DominoHighLowImpl_Khan.isHighLowString(highLowString);
		assertFalse(assertThis);
		
		highLowString = "1:3";
		assertThis = DominoHighLowImpl_Khan.isHighLowString(highLowString);
		assertFalse(assertThis);
		
		System.out.println("TEST SUCCESFULLY COMPLETED");
	}
	
	
	@Test
	void testDominoHighLowString()
	{
		System.out.println("NOW TESTING DOMINO HIGH LOW STRING CONSTRUCTOR");
		String highLowString = "2:1";
		Domino d1 = new DominoHighLowImpl_Khan(highLowString);
		int assertHigh = d1.getHighPipCount();
		int assertLow = d1.getLowPipCount();
		assertEquals(assertHigh, 2);
		assertEquals(assertLow, 1);
		
		highLowString = "5:1";
		Domino d2 = new DominoHighLowImpl_Khan(highLowString);
		assertHigh = d2.getHighPipCount();
		assertLow = d2.getLowPipCount();
		assertEquals(assertHigh, 5);
		assertEquals(assertLow, 1);
		
		highLowString = "6:6";
		Domino d3 = new DominoHighLowImpl_Khan(highLowString);
		assertHigh = d3.getHighPipCount();
		assertLow = d3.getLowPipCount();
		assertEquals(assertHigh, 6);
		assertEquals(assertLow, 6);
		System.out.println("TEST SUCCESFULY COMPLETED");
	}
	
	@Test
	void testDominoHighLowIntArray()
	{
		System.out.println("TESTING DOMINO HIGH LOW INT ARRAY SUM DIFF CONSTRUCTOR");
		int [] intArray = new int[] {4,0};
		Domino d1 = new DominoHighLowImpl_Khan(intArray);
		int assertHigh = d1.getHighPipCount();
		int assertLow = d1.getLowPipCount();
		assertEquals(assertHigh, 2);
		assertEquals(assertLow, 2);
		
		int [] intArray2 = new int[] {5,1};
		Domino d2 = new DominoHighLowImpl_Khan(intArray2);
		assertHigh = d2.getHighPipCount();
		assertLow = d2.getLowPipCount();
		assertEquals(assertHigh, 3);
		assertEquals(assertLow, 2);
		
		int [] intArray3 = new int[] {0,0};
		Domino d3 = new DominoHighLowImpl_Khan(intArray3);
		assertHigh = d3.getHighPipCount();
		assertLow = d3.getLowPipCount();
		assertEquals(assertHigh, 0);
		assertEquals(assertLow, 0);
		System.out.println("TEST SUCCESFULLY COMPLETED");
	}
	
	@Test
	void testDominoHighLowPipSet()
	{
		System.out.println("NOW TESTING HIGH LOW SET CONSTUCTOR");
		Integer testArray[] = {1, 2};
		Set <Integer> testSet = new HashSet<Integer>(Arrays.asList(testArray));
		Domino d1 = new DominoHighLowImpl_Khan(testSet);
		int assertHigh = d1.getHighPipCount();
		int assertLow = d1.getLowPipCount();
		assertEquals(assertHigh, 2);
		assertEquals(assertLow, 1);
		
		Integer testArray2[] = {1, 1};
		Set <Integer> testSet2 = new HashSet<Integer>(Arrays.asList(testArray2));
		Domino d2 = new DominoHighLowImpl_Khan(testSet2);
		assertHigh = d2.getHighPipCount();
		assertLow = d2.getLowPipCount();
		assertEquals(assertHigh, 1);
		assertEquals(assertLow, 1);
		System.out.print("TEST SUCCESFULLY COMPLETED");
	}
	
	// NOW STARTING DOMINO HIGH LOW SET IMPL
	@Test
	void testDominoHighLowSetTwoInts()
	{
		System.out.println("NOW TESTING TWO INTS PASSED TO HIGHLOWSET IMPL");
		int highPip = 5;
		int lowPip = 3;
		Domino d1 = new DominoHighLowSetImpl_Khan(highPip,lowPip);
		int assertHigh = d1.getHighPipCount();
		int assertLow = d1.getLowPipCount();
		assertEquals(assertHigh, 5);
		assertEquals(assertLow, 3);
		System.out.println("TEST SUCCESFULLY COMPLETED");
	}
	
	@Test
	void testIsSumDifferenceString()
	{
		System.out.println("NOW TESTING IS SUMDIF STRING");
		String sumDif = "7,3";
		boolean assertThis = DominoHighLowSetImpl_Khan.isSumDifferenceString(sumDif);
		assertTrue(assertThis);
		
		sumDif = "4,0";
		assertThis = DominoHighLowSetImpl_Khan.isSumDifferenceString(sumDif);
		assertTrue(assertThis);
		
		sumDif = " 4,0";
		assertThis = DominoHighLowSetImpl_Khan.isSumDifferenceString(sumDif);
		assertFalse(assertThis);
		
		sumDif = "5,4";
		assertThis = DominoHighLowSetImpl_Khan.isSumDifferenceString(sumDif);
		assertFalse(assertThis);
		
		sumDif = "a,5";
		assertThis = DominoHighLowSetImpl_Khan.isSumDifferenceString(sumDif);
		assertFalse(assertThis);
		
		sumDif = "13,1";
		assertThis = DominoHighLowSetImpl_Khan.isSumDifferenceString(sumDif);
		assertFalse(assertThis);
		
		sumDif = "5,9";
		assertThis = DominoHighLowSetImpl_Khan.isSumDifferenceString(sumDif);
		assertFalse(assertThis);
		
		//sumDif = "12,0";
		//assertThis = DominoHighLowSetImpl_Guerrero.isSumDifferenceString(sumDif);
		//assertTrue(assertThis);

		System.out.println("TEST SUCCESFULLY COMPLETED");
		
		
	}
	
	@Test
	void testSumDifferenceString()
	{
		System.out.println("NOW TESTING DOMINOSETIMPL SUMDIFFERENCESTRING");
		String sumDif = "7,3";
		Domino d1 = new DominoHighLowSetImpl_Khan(sumDif);
		int assertHigh = d1.getHighPipCount();
		int assertLow = d1.getLowPipCount();
		assertEquals(assertHigh, 5);
		assertEquals(assertLow, 2);
		
		sumDif = "8,4";
		Domino d2 = new DominoHighLowSetImpl_Khan(sumDif);
		assertHigh = d2.getHighPipCount();
		assertLow = d2.getLowPipCount();
		assertEquals(assertHigh, 6);
		assertEquals(assertLow, 2);
		
		sumDif = "2,2";
		Domino d3 = new DominoHighLowSetImpl_Khan(sumDif);
		assertHigh = d3.getHighPipCount();
		assertLow = d3.getLowPipCount();
		assertEquals(assertHigh, 2);
		assertEquals(assertLow, 0);
		System.out.println("TEST SUCCESFULLY COMPLETED");
		
		sumDif = "10,0";
		Domino d4 = new DominoHighLowSetImpl_Khan(sumDif);
		assertHigh = d4.getHighPipCount();
		assertLow = d4.getLowPipCount();
		assertEquals(assertHigh, 5);
		assertEquals(assertLow, 5);
		System.out.println("TEST SUCCESFULLY COMPLETED");
	}
	
	@Test
	void testIsLowPlus8TimesHigh()
	{
		System.out.println("NOW TESTING ISLOWPLUS8TIMESHIGH");
		int testInt = 54;
		boolean assertThis = DominoHighLowSetImpl_Khan.isLowPlus8TimesHighInteger(testInt);
		assertTrue(assertThis);
		
		testInt = 29;
		assertThis = DominoHighLowSetImpl_Khan.isLowPlus8TimesHighInteger(testInt);
		assertFalse(assertThis);
		System.out.println("TEST SUCCESFULLY COMPLETED");
	}
	

	
	//NOW TESTING THE DOMINO LOW DIFFERENCE STRING IMPL
	@Test
	void lowDiffLowPlus8TimesHigh()
	{
		System.out.println("NOW TESTING LOWDIFSTRING LOWPLUS8TIMESHIGH");
		int k = 42;
		Domino d1 = new DominoLowDifferenceStringImpl_Khan(k);
		int assertHigh = d1.getHighPipCount();
		int assertLow = d1.getLowPipCount();
		assertEquals(assertHigh, 5);
		assertEquals(assertLow, 2);
		
		k = 34;
		Domino d2 = new DominoLowDifferenceStringImpl_Khan(k);
		assertHigh = d2.getHighPipCount();
		assertLow = d2.getLowPipCount();
		assertEquals(assertHigh, 4);
		assertEquals(assertLow, 2);
		System.out.println("TEST SUCCESFULLY COMPLETED");
	}
	
	// List<MyType> myList = new ArrayList<>();
	
	@Test
	void lowDiffListHighSum()
	{
		System.out.println("NOW TESTING LOWDIFF LIST HIGHSUM");
		List<Integer> myList = new ArrayList <Integer> ();
		myList.add(5);
		myList.add(7);
		Domino d1 = new DominoLowDifferenceStringImpl_Khan(myList);
		int assertHigh = d1.getHighPipCount();
		int assertLow = d1.getLowPipCount();
		assertEquals(assertHigh, 5);
		assertEquals(assertLow, 2);
		
		
		List<Integer> myList2 = new ArrayList <Integer> ();
		myList2.add(2);
		myList2.add(4);
		Domino d2 = new DominoLowDifferenceStringImpl_Khan(myList2);
		assertHigh = d2.getHighPipCount();
		assertLow = d2.getLowPipCount();
		assertEquals(assertHigh, 2);
		assertEquals(assertLow, 2);
		System.out.println("TEST SUCCESFULLY COMPLETE");
	}
	
	

}




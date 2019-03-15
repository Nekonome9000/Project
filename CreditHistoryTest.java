import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.ArrayList;

import org.junit.Test;

/**
 * Group #2
 */ 
public class CreditHistoryTest {
	/**
	 * Tests method 'addRating' that adds a valid number 0 into array list. 
	 * Should return ArrayList containing 0.
	 */
	@Test
	public void test_add_get_ratings_0() {
		CreditHistory ch = new CreditHistory();

		ch.addRating(0);

		assertEquals("There should be a 0 Rating in a list.", 
			new ArrayList<Integer>(Arrays.asList(0)), 
			ch.getRatings());

	}
	
	/**
	 * Tests method 'addRating' that adds a valid number -5 into array list. 
	 * Should return ArrayList containing -5.
	 */
	@Test
	public void test_add_get_ratings_lowerBound_neg5() {
		CreditHistory ch = new CreditHistory();

		ch.addRating(-5);

		assertEquals("There should be a -5 Rating in a list.", 
			new ArrayList<Integer>(Arrays.asList(Integer.valueOf(-5))), 
			ch.getRatings());

	}
	
	/**
	 * Tests method 'addRating' that adds invalid number -6 into array list. 
	 * Should return an empty ArrayList.
	 */
	@Test
	public void test_add_get_ratings_lowerBound_neg6() {
		CreditHistory ch = new CreditHistory();

		ch.addRating(-6);

		assertEquals("The ratings should be empty.",
			new ArrayList<Integer>(),
			ch.getRatings());

	}
	
	/**
	 * Tests method 'addRating' that adds a valid number 5 to array list. 
	 * Should return ArrayList containing 5.
	 */
	@Test
	public void test_add_get_ratings_upperBound_5() {
		CreditHistory ch = new CreditHistory();

		ch.addRating(5);

		assertEquals("There should be a 5 Rating in a list.", 
			new ArrayList<Integer>(Arrays.asList(Integer.valueOf(5))), 
			ch.getRatings());

	}
	
	/**
	 * Tests method 'addRating' that adds an invalid number 6 to array list. 
	 * Expectations is to return empty ArrayList.
	 */
	@Test
	public void test_add_get_ratings_upperBound_6() {
		CreditHistory ch = new CreditHistory();

		ch.addRating(6);

		assertEquals("The ratings should be empty.",
			new ArrayList<Integer>(),
			ch.getRatings());

	}
	
	/**
	 * Tests method 'addRating' that adds valid numbers 0, -2, 5. 
	 * Should return ArrayList containing [0, -2, 5].
	 */
	@Test
	public void test_add_get_ratings_order() {
		CreditHistory ch = new CreditHistory();

		ch.addRating(0);
		ch.addRating(-2);
		ch.addRating(5);

		assertEquals("There should be 0, -2, 5 in order in a list.",
			new ArrayList<Integer>(Arrays.asList(
				Integer.valueOf(0), Integer.valueOf(-2), Integer.valueOf(5))),
			ch.getRatings());

	}
	
	/**
	 * Tests mehod trimRatings arraylist has less then 10 integers
	 * Should return the arraylist with no changes
	 */
	@Test
	public void test_trim_get_ratings_lessThan10() {
		CreditHistory ch = new CreditHistory();
		ArrayList<Integer> iList = new ArrayList<Integer>();

		for (int i = 0; i < 7; i++) {
			ch.addRating(i - 5);
			iList.add(Integer.valueOf(i - 5));
		}

		assertEquals("There should be integers from -5 to 1 in an ordered list.",
			iList, ch.getRatings());

		ch.trimRatings();

		assertEquals("There should still be integers from -5 to 1 in an ordered list after trimming.",
			iList, ch.getRatings());

	}

	/**
	 * Tests method trimRatings arraylist inputed has more then 10 integers
	 * Should return arraylist that trimed the first few arrays inputed
	 * So that the final arraylist starts from the last integer it trimed 
	 * In this case the array should start from 3
	 */
	@Test
	public void test_trim_get_ratings_moreThan10() {
		CreditHistory ch = new CreditHistory();
		ArrayList<Integer> iList = new ArrayList<Integer>();

		for (int i = 0; i < 13; i++) {
			ch.addRating(i % 5);
			iList.add(i % 5);
		}

		assertEquals("There should be integers in an ordered list.",
			iList, ch.getRatings());

		iList = new ArrayList<Integer>(iList.subList(iList.size() - 10, iList.size()));
		ch.trimRatings();

		assertEquals("There should be integers in an ordered list after trimming, starting from 3.",
			iList, ch.getRatings());

	}

	/**
	 * Test method trimRating and method numOfRating
	 * Inputs an arraylist with less then 10 integers
	 * Should output a list with the amount of integers inputed 
	 * In this case it would be a list of 7 integers
	 */
	@Test
	public void test_trim_numOf_ratings_lessThan10() {
		CreditHistory ch = new CreditHistory();
		ArrayList<Integer> iList = new ArrayList<Integer>();

		for (int i = 0; i < 7; i++) {
			ch.addRating(i - 5);
			iList.add(Integer.valueOf(i - 5));
		}

		assertEquals("There should be 7 integers in the list.",
			7, ch.numOfRatings());

		ch.trimRatings();

		assertEquals("There should still be 7 integers in the list after trimming.",
			7, ch.numOfRatings());

	}

	/**
	 * Test Method trimRating and method numOfRating
	 * Inputs an arraylist with more the 10 integers
	 * Should output a list with 10 integers after the triming
	 */
	@Test
	public void test_trim_numOf_ratings_moreThan10() {
		CreditHistory ch = new CreditHistory();
		ArrayList<Integer> iList = new ArrayList<Integer>();

		for (int i = 0; i < 13; i++) {
			ch.addRating(i % 5);
			iList.add(i % 5);
		}

		assertEquals("There should be 13 integers in the list.",
			13, ch.numOfRatings());

		iList = new ArrayList<Integer>(iList.subList(iList.size() - 10, iList.size()));
		ch.trimRatings();

		assertEquals("There should be 10 integers in the list after trimming.",
			10, ch.numOfRatings());

	}
	
	/**
	 *
	 */
	@Test 
	public void test_creditRating_lessThan10_odd(){
		CreditHistory ch = new CreditHistory();
		ArrayList<Integer> iList = new ArrayList<Integer>();

		for (int i = 0; i < 3; i++) {
			ch.addRating(i % 5 - 2);
			iList.add(i % 5 - 2);
		}

		double sum = 0;

		for (int i = 1; i <= iList.size(); i++) {
			sum += 2d * i / (iList.size() + 1) * iList.get(i - 1);
		}

		assertEquals("The weighted average without trimming",
			sum/iList.size(), ch.getCreditRating(), 0.0001);

	}
	
	/**
	 *
	 */
	@Test 
	public void test_creditRating_moreThan10_odd(){
		CreditHistory ch = new CreditHistory();
		ArrayList<Integer> iList = new ArrayList<Integer>();

		for (int i = 0; i < 13; i++) {
			ch.addRating(i % 5 - 2);
			iList.add(i % 5 - 2);
		}

		double sum = 0;

		for (int i = 0; i < iList.size(); i++) {
			sum += 2d * (i + 1) / (iList.size() + 1) * iList.get(i);
		}

		assertEquals("The weighted average without trimming",
			sum/iList.size(), ch.getCreditRating(), 0.0001);

	}

	/**
	 *
	 */
	@Test 
	public void test_creditRating_moreThan10_even(){
		CreditHistory ch = new CreditHistory();
		ArrayList<Integer> iList = new ArrayList<Integer>();

		for (int i = 0; i < 14; i++) {
			ch.addRating(i % 5 - 2);
			iList.add(i % 5 - 2);
		}

		double sum = 0;

		for (int i = 0; i < iList.size(); i++) {
			sum += 2d * (i + 1) / (iList.size() + 1) * iList.get(i);
		}

		assertEquals("The weighted average without trimming",
			sum/iList.size(), ch.getCreditRating(), 0.0001);

	}

	/**
	 *
	 */
	@Test 
	public void test_trim_creditRating_lessThan10_odd(){
		CreditHistory ch = new CreditHistory();
		ArrayList<Integer> iList = new ArrayList<Integer>();

		for (int i = 0; i < 7; i++) {
			ch.addRating(i % 5 - 2);
			iList.add(i % 5 - 2);
		}

		ch.trimRatings();

		double sum = 0;

		for (int i = 0; i < iList.size(); i++) {
			sum += 2d * (i + 1) / (iList.size() + 1) * iList.get(i);
		}

		assertEquals("The weighted average with trimming",
			sum/iList.size(), ch.getCreditRating(), 0.0001);
	}
	
	/**
	 *
	 */
	@Test 
	public void test_trim_creditRating_moreThan10_odd(){
		CreditHistory ch = new CreditHistory();
		ArrayList<Integer> iList = new ArrayList<Integer>();

		for (int i = 0; i < 11; i++) {
			ch.addRating(i % 5 - 2);
			iList.add(i % 5 - 2);
		}
		
		iList = new ArrayList<Integer>(iList.subList(iList.size() - 10, iList.size()));
		ch.trimRatings();

		double sum = 0;

		for (int i = 0; i < iList.size(); i++) {
			sum += 2d * (i + 1) / (iList.size() + 1) * iList.get(i);
		}

		assertEquals("The weighted average with trimming",
			sum/iList.size(), ch.getCreditRating(), 0.0001);
	}
}	

package project1.algorithms;

import java.util.List;
import project1.exceptions.NullArgumentException;

/**
 * This class stores the search algorithms of each type. Linear, recursive and
 * iterative binary search.
 * 
 * @author Mustafa Al-Shebeeb
 * @version 1.0
 * @since 2023-02-24
 */

public class Search {

	/**
	 * Generic Linear Search algorithm, simplest method of searching a data set
	 * Starting at the beginning of the data set, each item of data is examined
	 * until a match is made. Once the item is found, the search ends. If there is
	 * no match, the algorithm must deal with this.
	 * 
	 * @param target paramter is the target value bieng searched for input is the
	 *               list being searched through
	 * @return i is the index that returns the position
	 */
	public static <T extends Comparable<T>> int linearSearch(T target, List<T> input) throws NullArgumentException {
		// throws nullarg exception
		if (target == null || input == null)
			throw new NullArgumentException();
		// for loop that searches through list one by one
		for (int i = 0; i < input.size(); i++) {
			if (input.get(i).compareTo(target) == 0) {
				// returns index
				return i;
			}
		}
		return -1;

	}

	/**
	 * Binary search begins by comparing the middle element of the array to the
	 * target value. If the target value is equal to the middle element, its
	 * position in the array is returned. This is an iterative version of the binary
	 * search so the space complexity is O(1)
	 * 
	 * @param target paramter is the target value bieng searched for input is the
	 *               list being searched through
	 * @return middle is the middle of the list bieng searched
	 */
	public static <E extends Comparable<E>> int iterativeBinarySearch(E target, List<E> input)
			throws NullArgumentException {

		if (target == null || input == null)
			throw new NullArgumentException();
		// end and start variable for higher and lower bounds
		int start = 0;
		int end = input.size() - 1;
		// while loop that iterates when the condition is met
		while (start <= end) {
			int middle = (start + end) / 2;
			System.out.println(input + " " + start + " " + end + " " + middle);
			// if the middle is less than the target then it will move up
			if (input.get(middle).compareTo(target) < 0) {
				start = middle + 1;
			}
			// if the middle is greater than the target then it will move down
			if (input.get(middle).compareTo(target) > 0) {
				end = middle - 1;
			}
			// if the target and middle are the same then it will return middle
			if (input.get(middle).compareTo(target) == 0) {
				return middle;
			}
		}
		return -1;

	}

	/**
	 * This method is used for calling the recursive binary search below it and also
	 * throws null argument exception if it is required to do so
	 * 
	 * @param target paramter is the target value bieng searched for input is the
	 *               list being searched through
	 * @return returns a call to the recursive binary search method
	 */
	public static <E extends Comparable<E>> int recursiveBinarySearch(E target, List<E> input)
			throws NullArgumentException {
		// throws null argument exception
		if (target == null || input == null)
			throw new NullArgumentException();
		// returns a method call
		return doRecursiveBinarySearch(target, input, 0, input.size() - 1);

	}

	/**
	 * Binary search begins by comparing the middle element of the array to the
	 * target value. If the target value is equal to the middle element, its
	 * position in the array is returned. This is an recursive version of the binary
	 * search so the space complexity is O(log N)
	 * 
	 * @param target paramter is the target value bieng searched for input is the
	 *               list being searched through. low is the lower bound of the list
	 *               high is the higher bound of the list
	 * @return Return value with description
	 */
	public static <E extends Comparable<E>> int doRecursiveBinarySearch(E target, List<E> input, int low, int high) {

		// base case
		if (high < low) {
			return -1;
		}

		int middle = (low + high) / 2;

		// if the target and middle are the same then middle is returned
		if (input.get(middle).compareTo(target) == 0) {
			return middle;
		}
		// if the middle is less than the target then it will go to the higher bound
		// and return the method call
		if (input.get(middle).compareTo(target) < 0) {
			return doRecursiveBinarySearch(target, input, middle + 1, high);
		}
		// if the middle is greater than the target then it will go the lower
		// bound and return the method call
		return doRecursiveBinarySearch(target, input, low, middle - 1);

	}

}

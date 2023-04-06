package drivers;

import java.util.ArrayList;

import project1.algorithms.Search;
import project1.exceptions.NullArgumentException;

public class MySearchTester {
	public static void main(String[] args) 
			throws NullArgumentException {
		ArrayList<Integer> testData = new ArrayList<>();
		
		for (int i = 0; i < 10; i++) {
			testData.add(i);
		}
		System.out.println(testData);
		System.out.println(Search.linearSearch(1, testData));
	}

}

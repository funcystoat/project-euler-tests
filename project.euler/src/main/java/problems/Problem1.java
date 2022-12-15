package problems;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Problem1 {
	public static void main(String[] args) {
		int upperBound = 1000;
		
		bruteForce(upperBound);
		differentBruteForce(upperBound);
		justUseMath(upperBound);
	}

	// Simply checks every number from 1 to UPPER_BOUND
	// for being a multiple of either 3 or 5
	public static void bruteForce(int upperBound) {
		int sum = 0;

		for (int i = 1; i < upperBound; i++) {
			if ((i % 3 == 0) || (i % 5 == 0))
				sum += i;
		}

		System.out.println(sum);
	}

	// Directly goes through only the multiples of 3 and then the multiples of 5
	// In the case of 1000 this only runs (1000/3 + 1000/5) = 333 + 200 = 533 times
	// instead of 1000
	public static void differentBruteForce(int upperBound) {
		Integer sum = 0;

		Set<Integer> setOfMultiplesOf3or5 = new HashSet<Integer>();

		for (int i = 1; i <= upperBound / 3; i++) {
			setOfMultiplesOf3or5.add(3 * i);
		}

		for (int i = 1; i <= upperBound / 5; i++) {
			setOfMultiplesOf3or5.add(5 * i);
		}

		setOfMultiplesOf3or5.remove(upperBound);

		Iterator<Integer> iter = setOfMultiplesOf3or5.iterator();

		while (iter.hasNext())
			sum += iter.next();

		System.out.println(sum);
	}

	// Use the sum formula (sum i from 1 to N = N*(N+1)/2) to add up all
	// multiples of 3, of 5, and then subtract the sum of all multiples of 15
	public static void justUseMath(int upperBound) {
		int N1 = (upperBound % 3 == 0) ? (upperBound / 3 - 1) : (upperBound / 3);
		int N2 = (upperBound % 5 == 0) ? (upperBound / 5 - 1) : (upperBound / 5);
		int N3 = (upperBound % 15 == 0) ? (upperBound / 15 - 1) : (upperBound / 15);

		System.out.println(
				3 * (N1 * (N1 + 1)) / 2 
				+ 5 * (N2 * (N2 + 1)) / 2 
				- 15 * (N3 * (N3 + 1)) / 2
				);
	}
}
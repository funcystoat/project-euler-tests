package problems;

import java.util.ArrayList;

public class Problem43 {
	static ArrayList<String> pdNumsWithProp;

	public static void main(String[] args) {
		System.out.println("brute force solution, calculating all 10! permuations of the digits 0 through 9, and then checking the condtion on each of them:"
				+ "\n(Note that we are allowing 0 to be a leading digit here, as it doesn't prima facie contradict the given conditions to do so.)");
		bruteForceSolution();
	}

	public static void bruteForceSolution() {
		long numOfPerms = factorial(10);
		long sum = 0;
		int[] primesOfInterest = { 2, 3, 5, 7, 11, 13, 17 };
		String panDigital = "0123456789";
		boolean flag;

		pdNumsWithProp = new ArrayList<String>();
		calculuatePerms(panDigital, 0, panDigital.length() - 1);

		for (int i = 0; i < numOfPerms; i++) {
			flag = true;
			String current = pdNumsWithProp.get(i);

			for (int j = 1; j < panDigital.length() - 2; j++) {
				if (Integer.parseInt(current.substring(j, j + 3)) % primesOfInterest[j - 1] != 0) {
					flag = false;
					break;
				}
			}

			if (flag)
				sum += Long.parseLong(current);

		}

		System.out.println(sum);
	}

	public static long factorial(long n) {
		if (n < 2)
			return 1;

		return n * factorial(n - 1);
	}

	public static void calculuatePerms(String str, int left, int right) {
		if (left != right) {
			for (int i = left; i <= right; i++)
				calculuatePerms(swapCharacters(str, left, i), left + 1, right);

			return;
		}

		pdNumsWithProp.add(str);
	}

	public static String swapCharacters(String str, int i, int j) {
		char temp;
		char[] ca = str.toCharArray();
		temp = ca[i];
		ca[i] = ca[j];
		ca[j] = temp;

		return String.valueOf(ca);
	}
}
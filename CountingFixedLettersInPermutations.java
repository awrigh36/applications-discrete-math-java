package multinomials;

import math3323.multinomials.Multinomials;
import math3323.multinomials.PermutationGeneratorCoveyouSullivan;

/**
 * 	Aly Wright
 *  Assignment 05
 *  Math 3323
 */

public class CountingFixedLettersInPermutations {

	public static void main(String[] args) {
		
		String testString = "FEDCBAKJIHG";
		
		System.out.println("Count of fixed letters in permutations of the string: " + testString);
		
		PermutationGeneratorCoveyouSullivan pg = new PermutationGeneratorCoveyouSullivan(testString);
		
		// Count fixed letters
		int fixed = 0;
		for (String s : pg) {
			for (int i = 0; i < 11; i++) {
				if (s.charAt(i) == testString.charAt(i)) {
					fixed++;
				}
			}
		}
		System.out.println("fixed = " + fixed);
		
		// Check fixed count with formula
		int n = testString.length();
		long resultG = 0;
		
		// g(n,m)
		for (int m = 0; m <= n; m++)
		{
			resultG += functionG(n, m) * functionH(n-m);	
		}
		
		System.out.println("g(n,m) = " + resultG);
	}

	// h(n)
	private static long functionH(int n) {
		if (n == 0)
			return 1;
		else if (n == 1)
			return 0;
		else
			return (n-1)*(functionH(n-1)+functionH(n-2));
	}

	// binom(n,m)
	private static long functionG(int n, int m) {
		long result = Multinomials.multinomial(n-m, m);
		return result;
	}
}

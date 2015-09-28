package multinomials;

import java.util.Set;
import java.util.TreeSet;

import math3323.multinomials.Multinomials;
import math3323.multinomials.PermutationGeneratorCoveyouSullivan;

public class TestMultinomial {

	/**
	 * 	Aly Wright
	 *  Assignment 04
	 *  Math 3323
	 */
	
	public static void main(String[] args) {
		String testString1 = "AAAAAAA";
		String testString2 = "ABCDEFG";
		String testString3 = "AAABBBCCCC";
		String testString4 = "AABBCCDDEE";
		
		// "AAAAAAA"
		int distinctPermSetSize1 = getDistinctPermutations(testString1);
		int[] mult1 = {6};
		int multinomial1 = (int) Multinomials.multinomial(mult1);
		print(testString1, distinctPermSetSize1, multinomial1);
		
		// "ABCDEFG"
		int distinctPermSetSize2 = getDistinctPermutations(testString2);		
		int[] mult2 = {1,1,1,1,1,1,1};
		int multinomial2 = (int) Multinomials.multinomial(mult2);
		print(testString2, distinctPermSetSize2, multinomial2);
		
		// "AAABBBCCCC"
		int distinctPermSetSize3 = getDistinctPermutations(testString3);		
		int[] mult3 = {3,3,4};
		int multinomial3 = (int) Multinomials.multinomial(mult3);
		print(testString3, distinctPermSetSize3, multinomial3);
		
		// "AABBCCDDEE"
		int distinctPermSetSize4 = getDistinctPermutations(testString4);		
		int[] mult4 = {2,2,2,2,2};
		int multinomial4 = (int) Multinomials.multinomial(mult4);
		print(testString4, distinctPermSetSize4, multinomial4);
	}
	
	private static void print(String testString, int permSetSize, int multinomial) {
		System.out.println("Distinct permutations of " + testString + ", count: " + permSetSize + " multinomial: " + multinomial);
	}

	// Create permutations and count them by making a set of them
	static int getDistinctPermutations(String testString) {
		PermutationGeneratorCoveyouSullivan pg = new PermutationGeneratorCoveyouSullivan(testString);
		Set<String> permSet = new TreeSet<String>();
		
		int distinctPerms = 0;
		pg = new PermutationGeneratorCoveyouSullivan(testString);
		for (String s : pg) {
			permSet.add(s);
		}
		distinctPerms = permSet.size();
		return distinctPerms;
	}
}

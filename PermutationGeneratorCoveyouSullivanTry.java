package multinomials;

import java.util.Set;
import java.util.TreeSet;

import math3323.multinomials.PermutationGeneratorCoveyouSullivan;

public class PermutationGeneratorCoveyouSullivanTry {

	/**
	 * 	Try out permutation generator.
	 */
	public static void main(String[] args) {
		// create a permutation generator for a particular string of characters
		PermutationGeneratorCoveyouSullivan pg = new PermutationGeneratorCoveyouSullivan("ABCD");
		// The first loop uses pg as an iterator
		while(pg.hasNext()) {  // while there are more permutations
			String n = pg.next();  // get the next permutation
			System.out.println(n);
		}
		System.out.println();
		pg = new PermutationGeneratorCoveyouSullivan("ABCDE");
		// the next loop is the 'foreach' which is new in Java 1.5
		for(String s : pg) {  // s takes on each permutation in succession
			System.out.println(s);
		}
		// Create permutations and count them by making a set of them
		pg = new PermutationGeneratorCoveyouSullivan("ABCDEF");
		Set<String> permSet = new TreeSet<String>();
		for(String s: pg) {
			permSet.add(s);
		}
		System.out.println("There are " + permSet.size() + " permutations of ABCDEF");
		System.out.println("6! = 720");
		

	}

}
/**
 * 	Aly Wright
 *  Assignment 07
 *  Math 3323
 */

package multinomials;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import org.apache.commons.math3.distribution.ChiSquaredDistribution;

public class A07PartOne {
	public static void main(String[] args) {
		String base = "ABCDEF";
	    String permString;
	    Map<String,Integer> mapping = new HashMap<String,Integer>();
	    int k = 0;
	    while (k < 720000) {
		    permString = generatePermutation(base);
		    int count = 0;
		    if (mapping.keySet().contains(permString)) {
		    	count = mapping.get(permString);
		    	mapping.put(permString, count+1);
		    } else {
		    	mapping.put(permString, 0);
		    }
		    k++;
	    }
	    Set set = mapping.entrySet();
	    Iterator iter = set.iterator();
	    int expected = 1000;
	    double csq = 0.0;

	    while(iter.hasNext()) {
	    	Map.Entry<String, Integer> me = (Map.Entry<String, Integer>) iter.next();
	    	System.out.println(me.getKey() + ": ");
	    	System.out.println("	  " + me.getValue());
	    	System.out.println("------------------");
	    	double diff = me.getValue() - expected;
	    	csq += diff * diff / expected;
	    }
	    
	    ChiSquaredDistribution csd = new ChiSquaredDistribution(719);
	    double prob = csd.cumulativeProbability(csq);
	    System.out.println("Chisquare statistic: " + csq);
	    System.out.println("The probability is: " + prob);
	}
	
	public static String generatePermutation(String base) {
		StringBuilder sB = new StringBuilder(base);
		int i = 0;
		int j = 0;
		int len = base.length();
		String s = "";
		for (i = 0; i < len; i++){
			j = randInt(0, len-1);
			char temp = sB.charAt(j);
			sB.setCharAt(j,  sB.charAt(i));
			sB.setCharAt(i, temp);
		}
		s = sB.toString();
		return s;
	}

	private static int randInt(int min, int max) {
		Random rand = new Random();
		int randNum = rand.nextInt((max - min) + 1) + min;
		
		return randNum;
	}
}

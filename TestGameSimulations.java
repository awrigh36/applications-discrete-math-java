package multinomials;

/*
 * Assignment 06
 * Math 3323
 * Spring 2015
 * Aly Wright
 */

/*
 * Results:
 * A vs B: A: 5236 Wins, B: 4765 Wins
 * B vs C: B: 6472 Wins, C: 3529 Wins
 * C vs A: C: 5183 Wins, A: 4818 Wins
 * 
 * Each simulated game with 10,000 rolls of each pair
 * produced results that are similar to those gathered
 * from using a combinatorial approach. A beat B 5236 times,
 * which is 52.36% of the time. This is still more than half
 * of the times the pair were rolled, so it proves the dice
 * are non-transitive.
 */

public class TestGameSimulations {
	public static void main(String[] args) {
		int[] testDieA = {5, 7, 17, 19, 59, 61};
		int[] testDieB = {2, 3, 31, 37, 47, 53};
		int[] testDieC = {11, 13, 23, 29, 41, 43};
		
		int[] winsAB = simThrows(testDieA, testDieB);
		int[] winsBC = simThrows(testDieB, testDieC);
		int[] winsCA = simThrows(testDieC, testDieA);
		
		System.out.println("A vs B: " + "A: " + winsAB[0] + " Wins, B: " + winsAB[1]
				+ " Wins\nB vs C: " + "B: " + winsBC[0] + " Wins, C: " + winsBC[1]
				+ " Wins\nC vs A: " + "C: " + winsCA[0] + " Wins, A: " + winsCA[1]
				+ " Wins");
	}
	
	private static int[] simThrows(int[] testSet1, int[] testSet2) {
		int[] wins = {0, 0};

		for(int i = 0; i <= 10000; i++) {
			int die1Index = (int)(Math.random()*5+1);
			int die2Index = (int)(Math.random()*5+1);
			if (testSet1[die1Index] > testSet2[die2Index]) {
				wins[0]++;
			} else {
				wins[1]++;
			}
		}
		return wins;
	}

}

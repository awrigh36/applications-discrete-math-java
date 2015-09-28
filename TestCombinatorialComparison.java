package multinomials;

/*
 * Assignment 06
 * Math 3323
 * Spring 2015
 * Aly Wright
 */

/*
 * Results:
 * A vs B: A: 20 Wins, B: 16 Wins
 * B vs C: B: 20 Wins, C: 16 Wins
 * C vs A: C: 20 Wins, A: 16 Wins
 * 
 * The results imply that die A "beats" die B,
 * die B "beats" die C, and die C "beats" die A.
 * 
 * These dice are non-transitive because each die can 
 * beat one of the other two, but not both, more than half the time.
 * In fact the probability of die A beating die B is 20/36, or
 *  0.555555556. That is, a 55.55555556% probability exists that
 *  a chosen die, die A in this case, will beat its "lesser", 
 *  which is die B in this case.
 */


public class TestCombinatorialComparison {
	public static void main(String[] args) {
		int[] testDieA = {5, 7, 17, 19, 59, 61};
		int[] testDieB = {2, 3, 31, 37, 47, 53};
		int[] testDieC = {11, 13, 23, 29, 41, 43};
		
		int[] winsAB = getWins(testDieA, testDieB);
		int[] winsBC = getWins(testDieB, testDieC);
		int[] winsCA = getWins(testDieC, testDieA);
		
		System.out.println("A vs B: " + "A: " + winsAB[0] + " Wins, B: " + winsAB[1]
							+ " Wins\nB vs C: " + "B: " + winsBC[0] + " Wins, C: " + winsBC[1]
							+ " Wins\nC vs A: " + "C: " + winsCA[0] + " Wins, A: " + winsCA[1]
							+ " Wins");
	}
	
	



	// Count winning combinations for each die in a pair
	static int[] getWins(int[] testSet1, int[] testSet2) {

		int[] wins = {0, 0};
		int j = 0;
		
		for(int i = 0;  i < testSet1.length; i++) {
			if(testSet1[i] > testSet2[j]) {
				wins[0]++;
			} else {
				wins[1]++;
			}
			if(testSet1[i] > testSet2[j+1]) {
				wins[0]++;
			} else {
				wins[1]++;
			}
			if(testSet1[i] > testSet2[j+2]) {
				wins[0]++;
			} else {
				wins[1]++;
			}
			if(testSet1[i] > testSet2[j+3]) {
				wins[0]++;
			} else {
				wins[1]++;
			}
			if(testSet1[i] > testSet2[j+4]) {
				wins[0]++;
			} else {
				wins[1]++;
			}
			if(testSet1[i] > testSet2[j+5]) {
				wins[0]++;
			} else {
				wins[1]++;
			}
		}
		return wins;
	}
}
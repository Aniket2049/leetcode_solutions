package neetcode250.m_1Ddp;

// https://leetcode.com/problems/stone-game-iii/
// https://www.youtube.com/watch?v=KI8suf35r38
// https://algo.monster/liteproblems/1406
public class _17_1406_StoneGameIII {
	
	private int[] stoneValues; // An array to hold the values of the stones.
	private Integer[] memoization; // A memoization array to store results of subproblems.
	private int totalStones; // The total number of stones.

	// Determines the outcome of the stone game III.
	public String stoneGameIII(int[] stoneValues) {
		totalStones = stoneValues.length; // Initialize the total number of stones.
		this.stoneValues = stoneValues; // Set the class's stoneValues array.
		memoization = new Integer[totalStones]; // Initialize the memoization array.

		// Result of the DFS to compare against.
		int result = dfs(0);

		if (result == 0) {
			return "Tie"; // If result is zero, then the game is tied.
		}

		// If the result is positive, Alice wins; otherwise, Bob wins.
		return result > 0 ? "Alice" : "Bob";
	}

	// Depth-First Search with memoization to calculate the optimal result.
	private int dfs(int index) {
		// Base case: if the index is out of the right boundary of array.
		if (index >= totalStones) {
			return 0;
		}

		// Return the already computed result if present, avoiding redundant computation.
		if (memoization[index] != null) {
			return memoization[index];
		}

		int maxDifference = Integer.MIN_VALUE; // Initialize to the smallest possible value.
		int sum = 0; // Sum to store the total values picked up until now.

		// Try taking 1 to 3 stones starting from the current index 'i' and calculate
		// the maximum score difference taking the subproblem (i+j+1) into account.
		for (int j = 0; j < 3 && index + j < totalStones; ++j) {
			sum += stoneValues[index + j]; // Increment sum with stone value.
			// Update maxDifference with the maximum of its current value and the score
			// difference. The score difference is current sum - result of dfs(i + j + 1).
			maxDifference = Math.max(maxDifference, sum - dfs(index + j + 1));
		}

		// Store the result in memoization and return it.
		return memoization[index] = maxDifference;
	}
}

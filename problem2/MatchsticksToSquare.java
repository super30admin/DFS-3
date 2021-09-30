// Time Complexity : O(4^n), n -> Number of matchsticks
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
package problem2;

public class MatchsticksToSquare {
	public boolean makesquare(int[] matchsticks) {
		if (matchsticks == null || matchsticks.length < 4) {
			return false;
		}

		int sum = 0;

		for (int matchstick : matchsticks) {
			sum += matchstick;
		}

		if (sum % 4 != 0) {
			return false;
		}

		int side = sum / 4;

		return backtrack(matchsticks, 0, new int[4], side);
	}

	private boolean backtrack(int[] matchsticks, int index, int[] square, int side) {
		// Base
		if (square[0] == side && square[1] == side && square[2] == side && square[3] == side) {
			return true;
		}
		if (index == matchsticks.length) {
			return false;
		}
		// Logic
		for (int i = 0; i < 4; i++) {
			int curr = matchsticks[index];
			if (curr + square[i] <= side) {
				square[i] += curr;
				if (backtrack(matchsticks, index + 1, square, side)) {
					return true;
				}
				square[i] -= curr;
			}
		}

		return false;
	}

	public static void main(String[] args) {
		MatchsticksToSquare obj = new MatchsticksToSquare();
		int[] matchsticks = { 1, 1, 2, 2, 2 };

		System.out.println("Can a square be formed using the given matchstick lengths? "
				+ (obj.makesquare(matchsticks) == true ? "Yes" : "No"));
	}

}

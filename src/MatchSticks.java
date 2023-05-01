import java.util.Arrays;
//Time Complexity : O(4^N)
//Space Complexity : O(N)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No

/**
 * Apply DFS and backtracking. Pick the last index and add it to any of the 4
 * directions and see if it is still under perimeter/4. If so, move to next
 * index and check if this can be repeated until index is reached the end. If
 * not return false.
 *
 */
class Solution {
	int[] sums = new int[4];

	public boolean makesquare(int[] nums) {
		if (nums == null || nums.length == 0)
			return false;

		int perimeter = 0;
		for (int i = 0; i < nums.length; i++)
			perimeter += nums[i];

		int side = perimeter / 4;
		if (side * 4 != perimeter)
			return false;
		Arrays.sort(nums);
		return dfs(nums, nums.length - 1, side);
	}

	public boolean dfs(int[] nums, int idx, int side) {
		if (idx == -1)
			return true;
		for (int i = 0; i < 4; i++) {
			if (sums[i] + nums[idx] <= side) {
				sums[i] += nums[idx];
				if (dfs(nums, idx - 1, side)) {
					return true;
				}
				sums[i] -= nums[idx];
			}
		}
		return false;
	}
}

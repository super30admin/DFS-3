// Time Complexity : O(4^n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Time limit exceeded error, 177 / 195 testcases are passing


// Your code here along with comments explaining your approach

class Solution {
    public boolean makesquare(int[] matchsticks) {
        if (matchsticks == null || matchsticks.length < 4)
            return false;
        int sum = 0;
        for (int num : matchsticks)
            sum += num;
        if (sum % 4 != 0)
            return false;
    	return dfs(matchsticks, new int[4], 0, sum / 4);
    }
    private boolean dfs(int[] matchsticks, int[] sums, int index, int target) {
    	if (index == matchsticks.length) {
    	    if (sums[0] == target && sums[1] == target && sums[2] == target) {
    		    return true;
    	    }
    	    return false;
    	}
    	for (int i = 0; i < 4; i++) {
    	    if (sums[i] + matchsticks[index] > target)
                continue;
    	    sums[i] += matchsticks[index];
            if (dfs(matchsticks, sums, index + 1, target))
                return true;
    	    sums[i] -= matchsticks[index];
        }
    	return false;
    }
}
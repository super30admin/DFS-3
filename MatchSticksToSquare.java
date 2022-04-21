package dfs3;

import java.util.Arrays;

public class MatchSticksToSquare {
	//Time Complexity : O(4^n), where n is length of matchsticks array
	//Space Complexity : O(1)
	//Did this code successfully run on Leetcode : Yes
	//Any problem you faced while coding this : No
	public boolean makesquare(int[] matchsticks) {
        // null
        if(matchsticks == null || matchsticks.length == 0)
            return false;
        
        int sum = 0;
        for(int match: matchsticks)
            sum += match;
        
        if(sum % 4 != 0)
            return false;
        
        Arrays.sort(matchsticks);
        reverse(matchsticks);
        int[] sides = new int[4];
        return backtrack(matchsticks, sides, sum / 4, 0);
    }
    
    private boolean backtrack(int[] matchsticks, int[] sides, int side, int idx) {
        // base
        if(idx == matchsticks.length)
            return sides[0] == sides[1] && sides[1] == sides[2] && sides[2] == sides[3];
        
        // logic
        for(int i=0; i<sides.length; i++) {
            if(matchsticks[idx] + sides[i] <= side) {
                    sides[i] += matchsticks[idx];
                if(backtrack(matchsticks, sides, side, idx + 1))
                    return true;
                sides[i] -= matchsticks[idx];
            }
        }
        
        return false;
    }
    
    private void reverse(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while(left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }
}

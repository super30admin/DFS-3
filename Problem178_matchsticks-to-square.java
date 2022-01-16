
// Time Complexity: O(nP4)
// Spcae Complexity: O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach


class Solution {
    private int[] square;
    public boolean makesquare(int[] matchsticks) {
        int sum = 0;
        for(int match: matchsticks) {
            sum += match;
        }
        if(sum % 4 != 0) return false;
        int side = sum / 4;
        square = new int[4];
        Arrays.sort(matchsticks);
        reverse(matchsticks);
        return backtrack(matchsticks, side, 0);
    }
    
    private boolean backtrack(int[] matchsticks, int side, int i) {
        // base
        if(square[0] == side && square[1] == side && square[2] == side && square[3] == side)
            return true;
        
        // logic
        for(int j = 0; j < 4; j++) {
            if(square[j] + matchsticks[i] <= side) {
                // actions
                square[j] += matchsticks[i];
                // recurse
                if(backtrack(matchsticks, side, i+1)) return true;
                // backtrack
                square[j] -= matchsticks[i];
            }
        }
        return false;
    }
    
    private void reverse(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while(left <= right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }
}
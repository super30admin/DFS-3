// Time Complexity : O(4^n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Solution {
    public boolean makesquare(int[] matchsticks) {
        if(matchsticks.length < 4) {
            return false;
        }
        
        int sum = 0;
        
        for(int n: matchsticks) {
            sum += n;
        }
        
        if(sum % 4 != 0) {
            return false;
        }
        
        int side = sum / 4;
        
        Arrays.sort(matchsticks);
        reverse(matchsticks);
        
        return backtrack(matchsticks, 0, new int[4], side);
    }
    
    private boolean backtrack(int[] matchsticks, int index, int[] square, int side) {
        
        // base case
        if(index == matchsticks.length) {
            if(square[0] == side && square[1] == side && square[2] == side && square[3] == side) {
                return true;
            }   
        }

        //logic
        
        for(int i = 0; i < 4; i++) {
            if(matchsticks[index] + square[i] <= side) {
                // action
                square[i] += matchsticks[index];
                
                // recurse
                if(backtrack(matchsticks, index + 1, square, side)) {
                    return true;
                }
                
                // backtrack
                square[i] -= matchsticks[index];
            }
        }
        
        return false;
    }
    
    private void reverse(int[] matchsticks) {
        int start = 0, end = matchsticks.length - 1;
        
        while(start <= end) {
            swap(matchsticks, start, end);
            start++;
            end--;
        }
    }
    
    private void swap(int[] matchsticks, int start, int end) {
        int temp = matchsticks[start];
        matchsticks[start] = matchsticks[end];
        matchsticks[end] = temp;
    }
}
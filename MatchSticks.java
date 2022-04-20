// Time Complexity : O(exponential)    
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Approach

// We make use of backtracking to solve this problem

class Solution {
    int side;
    public boolean makesquare(int[] matchsticks) {
        if(matchsticks == null || matchsticks.length == 0)return false;
        
        int sum =0;
        for(int match : matchsticks)
            sum += match;
        if(sum %4 !=0)return false;
        side = sum/4;
        int[] result = new int[4];
        Arrays.sort(matchsticks);
        reverse(matchsticks);
        
        return backtrack(matchsticks, result, 0);
    }
    
    private boolean backtrack(int[] matchsticks, int[] result, int i){
        if(i == matchsticks.length){
            if(result[0] == side && result[1] == side && result[2] == side && result[3] == side)
                return true;
            return false;
        }
        for(int j = 0; j<4 ; j++){
            if(result[j] +matchsticks[i] <=side){
                result[j] = result[j] + matchsticks[i];
                if(backtrack(matchsticks, result, i+1))
                    return true;
                result[j] = result[j] - matchsticks[i];
            }
        }
        return false;
    }
    
    private void reverse(int[] matchsticks){
        int left = 0, right = matchsticks.length-1;
        while(left<= right){
            swap(matchsticks, left, right);
            left++;
            right--;
        }
        
    }
    private void swap(int[] matchsticks, int l, int r){
        int temp = matchsticks[l];
        matchsticks[l] = matchsticks[r];
        matchsticks[r] = temp;
        
    }
}
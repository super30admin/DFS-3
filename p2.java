// Time Complexity :O(O(4^n))
// Space Complexity :O(n) recursive stack
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach

class Solution {
    public boolean makesquare(int[] matchsticks) {
        int max = 0;
        int sum = 0;
        for(int match: matchsticks){
            max = Math.max(max, match);
            sum += match;
        }
        
        if(sum % 4 != 0) return false; 
        if(max > sum) return false;
        Arrays.sort(matchsticks);
        int n = matchsticks.length;
        for (int i = 0; i < n / 2; i++) { 
            int t = matchsticks[i]; 
            matchsticks[i] = matchsticks[n - i - 1]; 
            matchsticks[n - i - 1] = t; 
        }
        // System.out.println(Arrays.toString(matchsticks));

        int[] sq = new int[4];
        return backtrack(matchsticks, sq, 0, sum/4);
        // return false;
    }

    private boolean backtrack(int[] matchsticks, int[] sq, int idx, int side){
        //base
        if(sq[0] == side && sq[1] == side && sq[2] == side) return true;

        for(int i=0; i<4;i++){
            if(sq[i] + matchsticks[idx] <= side){
                sq[i] += matchsticks[idx];
                if(backtrack(matchsticks, sq, idx+1, side)) return true;
                sq[i] -= matchsticks[idx];
            }
        }

        return false;
    }
}
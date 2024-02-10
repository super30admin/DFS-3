
// Time Complexity : O(4^n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None
class Solution {
    public boolean makesquare(int[] matchsticks) {
        int sum = 0;
        for(int match : matchsticks)
            sum += match;
        if(sum%4 != 0)
            return false;
        int side = sum / 4;
        for(int match : matchsticks){
            if(match > side)
                return false;
        }
        return backtrack(matchsticks,0,new int[4],side);
    }
    public boolean backtrack(int[] matchsticks, int i, int[] square, int side){
        //base
        if(i == matchsticks.length){
            if(square[0] == side && square[1] == side && square[2] == side && square[3] == side)
            return true;
            else
            return false;
        }
        //logic
        for(int idx = 0; idx < 4; idx++){
            if(square[idx] + matchsticks[i] <= side){
                square[idx] += matchsticks[i];
                if(backtrack(matchsticks,i+1,square,side))
                    return true;
                square[idx] -= matchsticks[i];
            }
        }
        return false;
    }
}

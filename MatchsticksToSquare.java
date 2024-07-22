//Time Complexity : O(4^n)
//Space Complexity : O(1)
//Did this code run successfully on leetcode: Yes
//Have you face any issue while writing this code: No
class MatchSticksToSquare {
    public boolean makesquare(int[] matchsticks) {
        int total = 0;
        int max = 0;

        for(int i : matchsticks) {
            total += i;
            max = Math.max(max, i);
        }

        if(total%4 != 0) return false;
        if(max > total/4) return false;

        int sum = total/4;

        return helper(matchsticks, 0, new int[4], sum);
    }

    private boolean helper(int[] matchsticks, int idx, int[] sides, int sum) {
        //base case
        if(idx == matchsticks.length) return true;

        //logic
        for(int i = 0; i < 4; i++) {
            if(sides[i] + matchsticks[idx] <= sum) {
                //action
                sides[i] = sides[i] + matchsticks[idx];
                //recurse
                if(helper(matchsticks, idx+1, sides, sum)) return true;
                //backtrack
                sides[i] -= matchsticks[idx];
            } 
        }
        return false;
    }
}
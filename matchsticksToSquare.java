// Time Complexity : Exponential / O(4^n), where n=no. of matchstricks, since there are 4 choices for each matchstick
// Space Complexity : O(n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
// We use backtracking to try out all the combinations, since greedy approach does not work here
class Solution {
    int side;
    public boolean makesquare(int[] matchsticks) {
        if (matchsticks == null || matchsticks.length == 0) return false;
        int n = matchsticks.length;

        // total the amount by adding all the matchsticks
        int total=0;
        for (int i=0; i<n; i++) {
            total += matchsticks[i];
        }

        // if the total is not divisible by 4 we return false
        if(total%4 != 0) {
            return false;
        }
        side = total/4;

        // Optimization: We will sort the values of matchsticks in descending order, so that the backtracking function perform optimally by entering maximum sized values first.
        Arrays.sort(matchsticks);
        reverse(matchsticks);

        int[] result = new int[4];
        return backtrack(matchsticks, result, 0);
    }

    private void reverse(int[] matchsticks) {
        int l=0, r=matchsticks.length-1;
        while (l<=r) {
            int temp = matchsticks[l];
            matchsticks[l] = matchsticks[r];
            matchsticks[r] = temp;

            l++;
            r--;
        }
    }

    private boolean backtrack(int[] matchsticks, int[] result, int i) {
        //base
        if (result[0] == side && result[1] == side && result[2] == side && result[3] == side) {
            return true;
        }
        if (i == matchsticks.length) {
            return false;
        }

        //logic
        for (int j=0; j<4; j++) {
            if (result[j] + matchsticks[i] <= side) {
                // action
                result[j] += matchsticks[i];

                // recurse
                if(backtrack(matchsticks, result, i+1)) {
                    return true;
                }

                // backtrack
                result[j] -= matchsticks[i];
            }
        }
        return false;
    }
}
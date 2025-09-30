// Time Complexity: O(4^n) // Each matchstick can be tried on 4 sides; pruning helps in practice but worst-case remains exponential.
// Space Complexity: O(n) // Recursion depth equals number of matchsticks; the 4-slot side array is O(1) extra.

// Using Backtracking: compute sum and target side = sum/4; fail fast if sum%4!=0 or any stick > target.
// Recurse over sticks by index, try placing current stick on any side that stays ≤ target; add → recurse → remove (backtrack).
// If idx reaches n, all sticks placed → return true; if no side works for some stick, backtrack up and ultimately return false.

class Solution {
    public boolean makesquare(int[] matchsticks) {
        int sum = 0;
        int maxLength = 0;

        for(int num : matchsticks){
            sum += num;
            maxLength = Math.max(maxLength, num);
        }

        int lengthOfEachSide = sum / 4;

        if(sum % 4 != 0) return false;
        if(maxLength > lengthOfEachSide) return false;

        return helper(matchsticks, 0, new int[4], lengthOfEachSide);
    }

    private boolean helper(int[] matchsticks, int idx, int[] square, int lengthOfEachSide){

        if(idx == matchsticks.length) return true;

        for(int i=0; i<4; i++){
            if(square[i] + matchsticks[idx] <= lengthOfEachSide){

                square[i] += matchsticks[idx];

                if(helper(matchsticks, idx+1, square, lengthOfEachSide)) return true;

                square[i] -= matchsticks[idx];
            }
        }

        return false;
    }
}

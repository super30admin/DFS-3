// Problem 473. Matchsticks to Square
// Time Complexity : O(4^n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
class Solution {
    public boolean makesquare(int[] matchsticks) {
        int sum = 0;
        for (int match : matchsticks) {
            sum += match;
        }
        if (sum % 4 != 0) return false;
        int side = sum / 4;
        int[] square = new int[4];
        Arrays.sort(matchsticks);
        reverse(matchsticks);
        return backtrack(matchsticks, square, side, 0);
    }

    private boolean backtrack(int[] matchsticks, int[] square, int side, int index) {
        if (square[0] == side && square[1] == side && square[2] == side && square[3] == side) {
            return true;
        }
        if (index == matchsticks.length) return false;
        for (int i = 0; i < 4; i++) {
            if (square[i] + matchsticks[index] <= side) {
                square[i] += matchsticks[index];
                if (backtrack(matchsticks, square, side, index + 1)) return true;
                square[i] -= matchsticks[index];
            }
            if (square[i] == 0) break;
        }
        return false;
    }
    
    private void reverse(int[] matchsticks) {
        int left = 0, right = matchsticks.length - 1;
        while (left < right) {
            int temp = matchsticks[left];
            matchsticks[left] = matchsticks[right];
            matchsticks[right] = temp;
            left++;
            right--;
        }
    }
}
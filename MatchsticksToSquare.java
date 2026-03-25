// Time Complexity : O(4^n)
// Space Complexity : O(4^n) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// first we need to check from the total sum is divisble by 4 to make sure we can form a square
// each number has 4 options as side and we iterate through every side and if it deosn't fit, we backtrack
// In order to reduce the backtracking we sort the array in descending to make sure larger numbers gets fitted first

class Solution {
    public boolean makesquare(int[] matchsticks) {
        int[] square = new int[4];
        long total = 0l;
        for (int size : matchsticks)
            total += size;

        if (total % 4 != 0)
            return false;
        Arrays.sort(matchsticks);
        reverse(matchsticks);
        int side = (int) (total / 4);
        return backtrack(square, matchsticks, 0, side);
    }

    private boolean backtrack(int[] square, int[] matchsticks, int idx, int side) {
        if (square[0] == side && square[1] == side && square[2] == side) {
            return true;
        }

        for (int i = 0; i < 4; i++) {
            if (square[i] + matchsticks[idx] <= side) {
                square[i] += matchsticks[idx];
                if (backtrack(square, matchsticks, idx + 1, side))
                    return true;
                square[i] -= matchsticks[idx];
            }
        }

        return false;
    }

    private void reverse(int[] array) {
        int left = 0;
        int right = array.length - 1;
        while (left < right) {
            int temp = array[left];
            array[left] = array[right];
            array[right] = temp;
            left++;
            right--;
        }
    }
}
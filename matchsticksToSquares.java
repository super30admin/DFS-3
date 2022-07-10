/*
Problem: https://leetcode.com/problems/matchsticks-to-square/
*/
class Solution {
    public boolean makesquare(int[] matchsticks) {
        if (matchsticks == null || matchsticks.length < 4)
            return false;
        
        int length = 0;
        
        for (int matchstickLen : matchsticks) {
            length += matchstickLen;
        }
        
        if (length % 4 != 0) {
            return false;
        }
        
        int squareSide = length / 4;
        
        // If we don't sort it in reverse order, we will get TLE.
        Arrays.sort(matchsticks);
        reverse(matchsticks);

        return backtrack(matchsticks, new int[4], squareSide, 0);
    }
    
    private boolean backtrack(int matchsticks[], int square[], int side, int index) {
        if (index == matchsticks.length) {
            return squareHasEqualSides(square, side);
        }
        
        for (int i = 0; i < 4; ++i) {
            if (square[i] + matchsticks[index] <= side) {
                square[i] = square[i] + matchsticks[index];
                if (backtrack(matchsticks, square, side, index + 1)) {
                    return true;
                }
                square[i] = square[i] - matchsticks[index];
            }
        }
        return false;
    }
    
    private boolean squareHasEqualSides(int square[], int side) {
        return (square[0] == side && square[1] == side && square[2] == side);
    }
    
    private void reverse(int matchsticks[]) {
        int n = matchsticks.length;
        
        for (int i = 0; i < n / 2; ++i) {
            int temp = matchsticks[i];
            matchsticks[i] = matchsticks[n - i - 1];
            matchsticks[n - i - 1] = temp;
        }
    }
}
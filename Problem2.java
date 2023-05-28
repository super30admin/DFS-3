import java.util.Arrays;

/*
Matchsticks to Square
approach: we can see that, if sum of all numbers is divisible by 4 then there's a possibility that we can form a square. we try to form all combinations which is exponential,
we try to form from the bigger number by sorting the given array.
time: O(n log n)
space: O(4)
 */
public class Problem2 {
    public boolean makesquare(int[] matchsticks) {
        int rsum = 0;
        for (int n:matchsticks) {
            rsum+=n;
        }
        if (rsum%4!=0) return false;
        int[] square = new int[4];
//        return backtrack(square, 0, rsum/4, matchsticks);
        Arrays.sort(matchsticks);
        reverse(matchsticks);
        return backtrackOpt(square, 0, rsum/4, matchsticks);
    }

    private boolean backtrackOpt(int[] square, int i, int side, int[] matchsticks) {

        if (square[0]==side && square[1]==side && square[2]==side) {
            return true;
        }
            for (int j=0;j<4;j++) {
                if (matchsticks[i]+square[j]<=side) {
                    square[j] = matchsticks[i]+square[j];
                    if (backtrack(square, i+1, side, matchsticks)) return true;
                    square[j] = square[j]-matchsticks[i];
                }
            }

        return false;
    }

    private void reverse(int[] matchsticks) {
        int i = 0, j = matchsticks.length-1;
        while (i<=j) {
            int t = matchsticks[i];
            matchsticks[i] = matchsticks[j];
            matchsticks[j] = t;
            i++;j--;
        }
    }

    private boolean backtrack(int[] square, int i, int side, int[] matchsticks) {

        if (square[0]==side && square[1]==side && square[2]==side) {
            return true;
        }

            for (int j=0;j<4;j++) {
                if (matchsticks[i]+square[j]<=side) {
                    square[j] = matchsticks[i]+square[j];
                    if (backtrack(square, i+1, side, matchsticks)) return true;
                    square[j] = square[j]-matchsticks[i];
                }
            }


        return false;
    }
}

// Time Complexity : O(4 ^ n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes

import java.util.Arrays;

public class MatchSticksToSqURE {

    int[] square;
    public boolean makesquare(int[] matchsticks) {
        square = new int[4];
        int sum = 0;
        for(int stick : matchsticks){
            sum += stick;
        }

        if(sum % 4 != 0) return false;
        int side = sum / 4;

        Arrays.sort(matchsticks);
        reverse(matchsticks); //inorder to use largest elements first

        return backtrack(matchsticks, side, 0);
    }

    public static void reverse(int[] array)
    {

        int n = array.length;
        // Swaping the first half elements with last half elements
        for (int i = 0; i < n / 2; i++) {

            // Storing the first half elements temporarily
            int temp = array[i];

            // Assigning the first half to the last half
            array[i] = array[n - i - 1];

            // Assigning the last half to the first half
            array[n - i - 1] = temp;
        }
    }
    private boolean backtrack(int[] matchsticks, int side, int index){
        //base
        if(index == matchsticks.length){
            if(square[0] == side && square[1] == side && square[1] == side) return true;
        }
        //logic
        //squares [0,0,0,0]
        for(int i = 0; i < 4; i++){
            if(matchsticks[index] + square[i] <= side){
                //action - add
                square[i] += matchsticks[index];
                //recurse
                if(backtrack(matchsticks, side, index +1)) return true;

                //backtrack
                square[i] -= matchsticks[index];
            }
        }

        return false;
    }
}

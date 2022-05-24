import java.util.Arrays;
/*
Time Complexity: O(4^N), N is the number of elements in the matchsticks array, and for every element we have 4
possibilities
Space Complexity: O(N), N is the number of elements in the matchsticks array
Run on leetcode: Yes
Any difficulties: No

Approach:
1. Calculate the perimeter by the given matchsticks array, if the perimeter is not a factor of 4 than I can directly return
false as there is no possibility to build a square then
2. Now if the reqSize is divisible by the 4 then recursively make combinations for sides and see if one can get each side of
the length of reqSize, action, recursion and backtrack would involve in this process
3. Important note: sorting the array in the descending order to optimize the solution
 */
public class MatchSticksToSquare {
    public static boolean makesquare(int[] matchsticks){

        int perimeter = 0;

        for(int len: matchsticks){
            perimeter+= len;
        }
        if(perimeter%4!= 0){
            return false;
        }
        int reqSize = perimeter/4;
        Arrays.sort(matchsticks);
        reverseArray(matchsticks);

        return makesquare(matchsticks, 0, reqSize, new int[4]);

    }

    public static boolean makesquare(int[] matchsticks, int index, int reqSize, int[] sides){
        if(index == matchsticks.length){
            return reqSize == sides[0];
        }

        if(matchsticks[index]> reqSize){
            return false;
        }

        boolean ans = false;

        for(int i =0; i<4; i++){
            // Action
            sides[i]+= matchsticks[index];

            // Recursion
            if(sides[i]<= reqSize){
                ans = makesquare(matchsticks, index+1, reqSize, sides);
            }

            // Backtrack
            sides[i]-= matchsticks[index];
        }
        return ans;
    }
    public static void reverseArray(int[] nums){
        int start = 0;
        int end = nums.length-1;
        while(start<= end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args){
        System.out.println("Can make square?: "+makesquare(new int[]{1,1,2,2,2}));
        System.out.println("Can make square?: "+makesquare(new int[]{3,3,3,3,4}));
    }
}

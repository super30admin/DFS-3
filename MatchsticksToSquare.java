package S30.DFS_3;

/*
Time Complexity : O(4^side) - 4 options at each level, number of levels = length of side
Space Complexity : O(side) - recursive stack will go as deep as the length of the side of the square
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : None
*/

import java.util.Arrays;

public class MatchsticksToSquare {

    public boolean makesquare(int[] nums) {

        if(nums == null || nums.length == 0) return false;
        int sum = 0;
        for(int num : nums){
            sum += num;
        }
        if(sum % 4 != 0) return false;
        int side = sum/4;

        //Sorting array in reverse order
        Arrays.sort(nums); // extra optimization, will remove randomness from the array
        reverse(nums);
        int[] square = new int[4];
        return backtrack(nums,square,0,side);


    }

    private boolean backtrack(int[] nums, int[] square, int index, int side){

        if(index == nums.length){
            if(square[0] == side && square[1] == side && square[2] == side && square[3] == side) return true;
            return false;
        }

        //logic
        for(int i = 0; i < square.length; i++){
            if(square[i] + nums[index] <= side){
                square[i] = square[i] + nums[index];
                if(backtrack(nums,square,index+1,side)) return true;
                square[i] = square[i] - nums[index];

            }
        }
        return false;
    }

    private void reverse(int[] nums){
        for(int i = 0; i < nums.length/2; i++){
            int temp = nums[i];
            nums[i] = nums[nums.length - 1 - i];
            nums[nums.length - 1 - i] = temp;
        }
    }
}

//Time Complexity : O(4^N) for DFS
//Space Complexity : O(N) for Stack Size
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No

//Your code here along with comments explaining your approach
/* 
1. depth first approach to solve this problem. So, we have a function that takes the current matchstick index we are to process and also the number of sides of the square that are completely formed till now.
2.If all of the matchsticks have been used up and 4 sides have been completely formed, that implies our square is completely formed. This is the base case for the recursion.
3.For the current matchstick we have 4 different options. This matchstick at indexindex can be a part of any of the sides of the square. We try out the 4 options by recursing on them.
If any of these recursive calls returns True, then we return from there, else we return False
*/

public class MakeSquare {
    public boolean makesquare(int[] nums) {
        if(nums == null || nums.length < 4){
            return false;
        }
        int perimeter = 0;
        for(int num : nums){
            perimeter += num;
        }
        int side = perimeter / 4;
        if(perimeter % 4 != 0 )
            return false;
        Arrays.sort(nums);
        reverse(nums);
        return dfs(nums,new int[4],0,side);
    }
    
    public boolean dfs(int nums[],int square[],int index,int target){
        //base condition
        if(index >= nums.length){
            if(square[0] == target && square[1] == target && square[2] == target ){
                return true;
            }
            return false;
        }
        //
        for(int i = 0; i < 4; i++){
            if((nums[index] + square[i]) > target){
                continue;
            }
            //actions
            square[i] += nums[index];
            if(dfs(nums,square,index + 1,target)){
                return true;
            }
            square[i] -= nums[index];
        }
        return false;
    }

    public static void reverse(int[] input) {
         int last = input.length - 1; 
         int middle = input.length / 2; 
         for (int i = 0; i <= middle; i++) { 
             int temp = input[i]; 
             input[i] = input[last - i]; 
             input[last - i] = temp; 
        } 
    }

}
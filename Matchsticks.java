
// Time Complexity : O(n^n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
// Backtracking

class Solution {
    public boolean makesquare(int[] nums) {
        if(nums==null || nums.length <4){
            return false;
        }  
        int sum = 0;
        for(int num: nums){
            sum += num;
        }
        
        if(sum % 4 != 0){
            return false;
        }
        
        int target = sum / 4;
        
        return backtracking(0, nums, target, new int[4]);
    }
    
    private boolean backtracking(int index, int[] nums, int target, int[] square){
        //base case
        if(index >= nums.length){
            if(square[0] == target && square[1]==target && square[2]==target&& square[3]==target){
                return true;
            }
            return false;
        }
        
        // Recursive case
        for(int i=0; i<4; i++){
            if(square[i] + nums[index] > target){
                continue;
            }
            square[i] += nums[index];
            if(backtracking(index+1, nums, target, square)){
                return true;
            }
            square[i] -= nums[index];
        }
        return false;
        
        
    }
}
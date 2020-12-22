// Time Complexity - O(4^n +nlogn)
// Space Complexity - O(1)
// This solution worked on LeetCode


class Solution {
    public boolean makesquare(int[] nums) {
        if(nums.length == 0)    return false;
        int sum = 0;
        for(int i=0; i < nums.length;i++){
            sum+=nums[i];
        }
        if(sum % 4 != 0) return false;
        Arrays.sort(nums);
        return dfs(nums,new int[4],nums.length-1,sum/4);
    }
    
    private boolean dfs(int[] nums,int[] square,int index,int target){
        // Base Case
        if(index < 0){
            if(square[0] == target && square[1] == target && square[2] == target)
                return true;
            return false;
        }
        // Logic
        for(int i=0;i<4;i++){
            if(square[i] + nums[index] > target)
                continue;
            square[i] += nums[index];
            if(dfs(nums,square,index-1,target)) return true;
            square[i] -= nums[index];
        }
        return false;
    }
}

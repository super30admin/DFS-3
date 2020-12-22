// Time Complexity : O(4^n), n is length of nums
// Space Complexity : O(n), worst case recursion call stack 
// Did this code successfully run on Leetcode : yes

// Your code here along with comments explaining your approach
// bruteforce is try adding nums[i] to either of the 4 groups and check if possible to form square, sum of groups is equal at the end
// recursively this is 4^n, we could sort the array and stop when groupSums[i] reaches overallSum/4

class Solution {
    
    public boolean makesquare(int[] nums) {
        if(nums==null || nums.length<4)
            return false;
        
        long sum = 0;
        for(int i=0; i<nums.length; i++){
            sum += nums[i];
        }
        
        if(sum%4 != 0)
            return false;
        
        int cur = nums.length-1;
        long[] groupSums = new long[4];
        long target = sum/4;
        
        Arrays.sort(nums);      
        return dfs(cur, nums, groupSums, target);
    }
    
    private boolean dfs(int cur, int[] nums, long[] groupSums, long target){
        if(cur==-1){
            for(int i=1; i<groupSums.length; i++){
                if(groupSums[i]!=groupSums[i-1]){
                    return false;
                }
            }
            return true;
        }
        
        for(int i=0; i<groupSums.length; i++){
            if(groupSums[i]+nums[cur]>target)
                continue;
            
            groupSums[i] += nums[cur]; 
            if(dfs(cur-1, nums, groupSums, target))
                return true;
            groupSums[i] -= nums[cur];            
        }
        
        return false;
    }
}
// Time Complexity : O(4^n/4), n is length of nums
// Space Complexity : O(n), Integer[], O(n/4) recursion call stack 
// Did this code successfully run on Leetcode : yes

// Your code here along with comments explaining your approach
// bruteforce is try adding nums[i] to either of the 4 groups and check if possible to form square, sum of groups is equal at the end
// recursively this is 4^n, we could sort the array and stop when groupSums[i] reaches overallSum/4, hence reducing complexity to 4^n/4

class Solution {
    long overallSum = 0;
    
    public boolean makesquare(int[] nums) {
        if(nums==null || nums.length<4)
            return false;
        
        int cur = 0;
        long[] groupSums = new long[4];
        Integer[] sortedNums = new Integer[nums.length];
        
        for(int i=0; i<nums.length; i++){
            overallSum += nums[i];
            sortedNums[i] = nums[i];
        }
        
        Arrays.sort(sortedNums, (a,b) -> b.compareTo(a));      
        return dfs(cur, sortedNums, groupSums);
    }
    
    private boolean dfs(int cur, Integer[] nums, long[] groupSums){
        if(cur==nums.length){
            for(int i=1; i<groupSums.length; i++){
                if(groupSums[i]!=groupSums[i-1]){
                    return false;
                }
            }
            return true;
        }
        
        boolean isPossible = false;
        
        for(int i=0; i<groupSums.length; i++){
            groupSums[i] += nums[cur]; 
            if(groupSums[i]<=overallSum/4){
                isPossible = isPossible || dfs(cur+1, nums, groupSums);    
            }
            groupSums[i] -= nums[cur];            
        }
        
        return isPossible;
    }
}
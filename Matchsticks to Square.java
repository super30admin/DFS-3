//Time Complexity-O(4^n)
//Space Complexity-O(n)

class Solution {
    public boolean makesquare(int[] nums) {
        if(nums==null||nums.length<4)
        {
            return false;
        }
        int sum=0;
        for(int num:nums)
        {
            sum+=num;
        }
        if(sum%4!=0)
        {
            return false;
        }
        int target=sum/4;
        return backTrack(0,nums,target,new int[4]);
               
    }
    
    boolean backTrack(int index,int[] nums,int target,int[] output)
    {
        if(index==nums.length)
        {
            if(output[0]==target&&
               output[1]==target&&
               output[2]==target)
            {
                return true;
            }
        }
        for(int i=0;i<4;i++)
        {
            if(output[i]+nums[index]>target)
            {
                continue;
            }
            output[i]+=nums[index];
            if(backTrack(index+1,nums,target,output))
            {
                return true;
            }
            output[i]-=nums[index];
        }
        return false;
    }
}
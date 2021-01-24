/*
// Time Complexity :  O(4^n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this : nopes
 */

class SolutionTwo
{
    public boolean makesquare(int[] nums)
    {
        int sum = 0;

        if( nums==null || nums.length==0)
            return false;

        for(int no:nums)
        {
            sum = sum + no;
        }

        if(sum%4!=0)
            return false;

        int side = sum/4;

        return backtrack(nums, new int[4],0,side);

    }

    private boolean backtrack(int[] nums,int[] square,int index,int side)
    {
        //base
        if(index==nums.length)
        {
            if(square[0] == side && square[1]==side && square[2]==side)
                return true;
        }


        //logic
        for(int i=0;i<square.length;i++)
        {
            if(square[i]+nums[index] <= side)
            {
                square[i] = square[i] + nums[index]; //actions
                if(backtrack(nums,square,index+1,side))
                    return true;

                //backtrack
                square[i] = square[i] - nums[index];

            }
        }
        return false;
    }
}
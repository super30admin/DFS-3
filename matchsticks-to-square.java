// class Solution {
//     public boolean makesquare(int[] nums) {
//         if(nums == null || nums.length < 4) return false;
        
//         int sum=0;
//         for(int num:nums) sum+=num;
//         if(sum%4 != 0) return false;
        
//         Arrays.sort(nums);
        
//         return backtrack(nums, new int[4], 0, sum/4);
//     }
//     private boolean backtrack(int[] nums, int[] sides, int cursor, int target) {
//         //goal state
//         if(cursor == nums.length) {
//             if(sides[0] == target && sides[1] == target && sides[2] == target)
//                 return true;
//             return false;
//         }
        
//         for(int i=0;i<4;i++) {
//             if(sides[i]+nums[cursor] > target) continue;
            
//             sides[i]+=nums[cursor];
//             if(backtrack(nums, sides, cursor+1, target) == true) return true;
//             sides[i]-=nums[cursor];
//         }
//         return false;
//     }
// }

// Time Complexity : O(4^N)
// Space Complexity : O(4^N)
class Solution {
    public boolean makesquare(int[] nums) {
        if(nums == null || nums.length < 4) return false;
        
        int sum=0;
        for(int num:nums) sum+=num;
        if(sum%4 != 0) return false;
        
        Arrays.sort(nums);
        reverse(nums);
        
        return backtrack(nums, new int[4], 0, sum/4);
    }
    private boolean backtrack(int[] nums, int[] sides, int cursor, int target) {
        //goal state
        if(cursor == nums.length) {
            if(sides[0] == target && sides[1] == target && sides[2] == target)
                return true;
            return false;
        }
        
        for(int i=0;i<4;i++) {
            if(sides[i]+nums[cursor] > target) continue;
            
            sides[i]+=nums[cursor];
            if(backtrack(nums, sides, cursor+1, target) == true) return true;
            sides[i]-=nums[cursor];
        }
        return false;
    }
    private void reverse(int[] nums) {
        int start=0;
        int mid=nums.length/2;
        int end=nums.length-1;
        
        while(start <= mid) {
            int temp=nums[start];
            nums[start]=nums[end];
            nums[end]=temp;
            
            start++;
            end--;
        }
    }
}

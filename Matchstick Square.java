

class Solution {
    public boolean makesquare(int[] nums) {
        if(nums.length < 4) return false;
        int total = 0;
        for(int t : nums){
            total+= t;
        }
        if(total%4 != 0) return false;
        Arrays.sort(nums);
        reverse(nums);
        return backtracking(nums, 0, new int[4], total/4);
    }
    private boolean backtracking(int [] nums, int index, int[] square, int target){
        // base case
        if(index >= nums.length){
            for(int x =0 ; x<4; x++){
                if(square[x] != target){
                    return false;
                }
            }
        return true;
        }

        
        for(int x=0; x<4; x++){
            if(square[x]+ nums[index] > target)  {
                continue;
            }
        square[x] += nums[index];
            if(backtracking(nums, index+1,square, target)) return true;
            square[x]-= nums[index];
        }
        return false;
    }
    
    private void reverse(int[] nums){
        int i =0;
        int j=nums.length-1;
        while(i<j){
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }
}

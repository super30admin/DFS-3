class Solution {
    public boolean makesquare(int[] matchsticks) {
        if(matchsticks == null || matchsticks.length == 0) return false;
        int sum = 0;
        for(int match: matchsticks){
           sum += match; 
        }
        if(sum % 4 != 0) return false;
        Arrays.sort(matchsticks);
        reverse(matchsticks);
        
        return backtrack(matchsticks, new int[4], 0, sum/4);
        
    }
    
    private boolean backtrack(int[] matchsticks, int [] square, int index, int side){
        //base
        if(index == matchsticks.length){
            if(square[0] == side && square[1] == side && square[2] == side && square[3] == side){
                return true;
            }
        }
        //logic
        
        for(int i = 0 ; i < square.length; i++){
            if(square[i] + matchsticks[index] <= side){
                
                //action
                square[i] += matchsticks[index];
                
                //recurse
                if(backtrack(matchsticks, square, index+1, side)) return true;
                    
                //backtrack
                square[i] -= matchsticks[index];
            }
        }
        return false;
    }
    
    private void reverse(int [] nums){
        int left = 0;
        int right = nums.length - 1 ;
        while(left <= right){
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++; 
            right--;
        }
    }
}

//TC: O(n !) -> n factoriol as it is based matchsticks permutation.
//SC: O(1)

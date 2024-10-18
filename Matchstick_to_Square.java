// Time Complexity : O(4^n)/ nlog(n) for sorting
// Space Complexity : O(n) recursive array
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public boolean makesquare(int[] matchsticks) {
        if(matchsticks.length <4){
            return false;
        }
        int sum =0;
        for(int match : matchsticks){
            sum += match;
        }
        if(sum%4 != 0){
            return false;
        }
        Arrays.sort(matchsticks);
        reverse(matchsticks);
        int side = sum/4;
        int[] square = new int[4];
        return backtrack(matchsticks, 0, square , side);
    }
    private void reverse(int [] matchsticks){
        int left = 0;
        int right = matchsticks.length-1;
        while(left<right){
            swap(matchsticks, left, right);
            left++;
            right--;
        }
    }

    private void swap(int [] matchsticks, int left, int right){
        int temp = matchsticks[left];
        matchsticks[left]= matchsticks[right];
        matchsticks[right] = temp;
    }

    private boolean backtrack(int[] matchsticks, int index, int[] square, int side){
        //base
        if(index == matchsticks.length){
            if((square[0]==side) && (square[1]==side) && (square[2]==side) ){
                return true;
            }
            return false;
        }

        //logic
        for(int i=0; i<4; i++){
            
            if(square[i] + matchsticks[index] <= side){
                //action
                square[i] += matchsticks[index];
            
                //recurse
                if(backtrack(matchsticks, index+1, square, side)){
                    return true;
                }

                //backtrack
                square[i] -= matchsticks[index];
            }
        }
        return false;
    }
   
}
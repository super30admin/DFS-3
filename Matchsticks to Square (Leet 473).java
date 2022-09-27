// Time: Exponential
// Space: O(1)

class Solution {
    public boolean makesquare(int[] matchsticks) {
        int sum = 0;
        if (matchsticks == null || matchsticks.length == 0) return false;
        
        for(int match: matchsticks){
            sum += match;
        }
        
        if (sum%4 != 0) return false;
        Arrays.sort(matchsticks);
        reverse(matchsticks);
        int side = sum/4;
        return backtrack(matchsticks, 0, new int[4], side);
        
    }
    
    private boolean backtrack(int[] matchsticks, int i, int[] square, int side){
        // base
        if (square[0] == side && square[1] == side && square[2] == side && square[3] == side) return true;
        // logic
        
        for(int j = 0; j<4;j++){
            if(square[j]+matchsticks[i] <= side){
                square[j] += matchsticks[i];
                if(backtrack(matchsticks, i+1, square, side) == true) return true;
                square[j] -= matchsticks[i];
            }
        }
        return false;
    }
    
    private void reverse(int[] arr){
        int l = 0, r = arr.length-1;
        while (l < r){
            int temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            l++;
            r--;
        }
    }
    
}

//TC - exponential
//SC - O(1)
class Solution {
    int[] square;
    public boolean makesquare(int[] matchsticks) {
        if(matchsticks == null || matchsticks.length < 4)   return false;
        square = new int[4];
        int sum = 0, max = 0;
        
        for(int n : matchsticks){
            sum += n;
            max = Math.max(max, n);
        }
        
        if(sum % 4 != 0 && max > sum/4)   return false;
        
        int len = sum / 4;
        
        Arrays.sort(matchsticks);
        reverse(matchsticks);
        return helper(matchsticks, len, 0);
    }
    public void reverse(int[] matchsticks){
        int low = 0, high = matchsticks.length - 1;
        
        while(low < high){
            int t = matchsticks[low];
            matchsticks[low] = matchsticks[high];
            matchsticks[high] = t;
            low++; high--;
        }
    }
    public boolean helper(int[] matchsticks, int len, int pivot){
        if(pivot == matchsticks.length){
            if(square[0] == len && square[1] == len && square[2] == len && square[3] == len )   return true;
        }
        
        for(int j = 0; j< 4; j++){
            if(square[j] + matchsticks[pivot] <= len){
                square[j] += matchsticks[pivot];
                if(helper(matchsticks, len, pivot + 1))    return true;
                    
                square[j] -= matchsticks[pivot];
            }
        }
        
        return false;
    }
}

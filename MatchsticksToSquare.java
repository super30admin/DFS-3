//TC: O(exponential)
//SC : O(1);

class Solution {
    int[] sq;
    public boolean makesquare(int[] matchsticks) {
        if(matchsticks == null || matchsticks.length < 4)   return false;
        sq = new int[4];
        int sum = 0, max = 0;
        
        for(int n : matchsticks){
            sum += n;
            max = Math.max(max, n);
        }
        
        if(sum % 4 != 0 && max > sum/4)   return false;
        
        int len = sum / 4;
        //Sorting and reveresing the matchsticks array
        
        Arrays.sort(matchsticks);
        reverse(matchsticks);
        return backtrack(matchsticks, len, 0);
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
    public boolean backtrack(int[] matchsticks, int len, int pivot){
        if(pivot == matchsticks.length){
            if(sq[0] == len && sq[1] == len && sq[2] == len && sq[3] == len )   return true;
        }
        
        
        //for(int i = pivot; i< matchsticks.length; i++){
            for(int j = 0; j< 4; j++){
                if(sq[j] + matchsticks[pivot] <= len){
                    sq[j] += matchsticks[pivot];
                    //Recurse
                    if(backtrack(matchsticks, len, pivot + 1))    return true;
                        
                    sq[j] -= matchsticks[pivot];
                }
            }
        //}
        
        
        return false;
    }
}

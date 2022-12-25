//TC - O(4^N)
//SC - O(1)

public class matchsticks_square {
    class Solution {
        int edge;
        public boolean makesquare(int[] matchsticks) {
            if(matchsticks.length<4) return false;
    
            int sum = 0;
            for(int i : matchsticks)
                sum += i;
    
            if(sum%4 != 0) return false;
    
            edge  = sum/4;
            Arrays.sort(matchsticks);
            reverse(matchsticks);
    
            return backtracking(matchsticks,0,new int[4]);
    
        }
    
        private boolean backtracking(int[] matchsticks,int idx, int[] square){
            //base
            if(idx == matchsticks.length){
                if(square[0]==edge && square[1]==edge && square[2]==edge)
                    return true;
    
                return false;
            }
            //logic
            for(int i=0;i<4;i++){
                if(square[i] + matchsticks[idx] <= edge)
                {
                    square[i] = matchsticks[idx] + square[i];
                    if(backtracking(matchsticks,idx+1,square))
                        return true;
                    square[i] = square[i] - matchsticks[idx];
                }
            }
    
            return false;
        }
    
        private void reverse(int[] arr){
            int l = 0;
            int r = arr.length-1;
    
            while(r>=l)
            {
                swap(arr,l,r);
                l++;
                r--;
            }
        }
        private void swap(int[] arr,int l, int r){
            int temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
        }
    }
}

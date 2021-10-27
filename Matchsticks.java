//TC -O(n)
//SC - O(n)

class Solution {
    public boolean makesquare(int[] matchsticks) {
        
        if( matchsticks == null || matchsticks.length < 4) return false;
        
        int sum =0 ;
        for ( int match:matchsticks) {
            sum = sum + match ;
        }
        if (sum % 4 != 0){
            return false;
        }
        int side = sum / 4 ;
        Arrays.sort(matchsticks);
        reverse(matchsticks);
        return backtrack(matchsticks, new int[4] , side, 0);
    }
    
    private boolean backtrack( int[] matchsticks, int[] square , int side, int index){

    //base
    if(square[0] == side && square[1] == side && square[2] == side){
        return true ;
    }
        //logic
        for(int i = 0 ; i < 4 ; i ++) {
            if (matchsticks[index] + square[i] <= side){
                ///action 
                square[i] = square[i] + matchsticks[index];
                //recurse
                if(backtrack(matchsticks, square , side, index + 1)){
                    return true ;
                }//backtrack
                square[i] = square[i] - matchsticks[index];
                
            }
        }
        return false;
        
        }
    
    private void reverse(int[] matchsticks){
        int left = 0 , right = matchsticks.length -1 ;
        while (left <= right){
            int temp = matchsticks[left];
            matchsticks[left] = matchsticks[right];
            matchsticks[right] = temp ;
            left ++ ;
            right --;
        }
    }
}
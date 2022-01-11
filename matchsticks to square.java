//Timecomplexity:- O(4^n).
//spacecomplexity:- O(1).

class Solution {
    public boolean makesquare(int[] matchsticks) {
        int sum=0;
        for(int i=0;i<matchsticks.length;i++){
            sum=sum+matchsticks[i];
        }
        if(sum%4!=0){
            return false;
        }
        int[] square=new int[4];
        return backtracking(matchsticks,0,square,sum/4);
    }
    private boolean backtracking(int[] matchsticks,int index,int[] square,int target){
        if(index>=matchsticks.length){
            for(int s:square){
                if(s!=target){// if all elements of matchsticks are processed checking final square whether every element 
                               // is equal to target or not.
                    return false;
                }
            }
            return true;
        }
        for(int i=0;i<4;i++){
            if(square[i]+matchsticks[index]>target){
                continue;           // if particular element of square is greater than target skipping that position and continuing.
            }
            square[i]=square[i]+matchsticks[index];//backtracking operation.
            if(backtracking(matchsticks,index+1,square,target)){
                return true;
                
            }
            square[i]=square[i]-matchsticks[index];//backtracking undoing operation.
        }
       return false;  
    }
   
    
}
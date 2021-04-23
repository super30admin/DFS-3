//time complexity-O(4^n)
//Space complexity-O(4^n)
//Ran on leetcode-Yes
//Solution with comments-
class Solution {
    public boolean makesquare(int[] matchsticks) {
        int sum=0;
        for(int n: matchsticks)
            sum+=n;//finding the perimeter, since sum all ofall lengths of matchsticks=perimeter
        if(sum%4!=0)//if the perimeter can not be converted to an integer we cannot form a sqaure
            return false;
        int side=sum/4;
        int[] square= new int[4];
        return backtrack(matchsticks,square,0,side);
    }
    
    public boolean backtrack(int[] matchsticks, int[] square, int index, int side){
        if(index>=matchsticks.length){
           for(int n : square){
            if(n!=side)
                return false;//if all the sides inside sqaure matrix are not equal to required side
            }
            return true;
        }
        for(int i=0;i<4;i++){
           if(square[i]+matchsticks[index]>side){//when the combination of lengths in matchstick is more than requireed side.
               continue;
           }
            square[i]+=matchsticks[index];
            if(backtrack(matchsticks,square,index+1,side))
                return true;
            square[i]-=matchsticks[index];
                
        }
        return false;       
    }
    
}
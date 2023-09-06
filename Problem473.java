class Problem473 {
    public boolean makesquare(int[] matchsticks) {
        int sum=0;
        for(int matchstick: matchsticks){
            sum+=matchstick;
        }
        if(sum%4!=0)
            return false;
        int side=sum/4;
        int[] squareSide=new int[4];
        Arrays.sort(matchsticks);
        return backtrack(matchsticks,matchsticks.length-1,squareSide, side);
    }
    
    private boolean backtrack(int[] matchsticks,int idx, int[] squareSide, int side ){
        //base case
        if(idx<0){
           if(squareSide[1]==side && squareSide[2]==side && squareSide[3]==side && squareSide[0]==side)
               return true;
            
            return false;
        }
        //logic
        for(int i=0;i<4;i++){
            if(squareSide[i]+matchsticks[idx]<=side){
                //action
                squareSide[i]+=matchsticks[idx];
                //recurse
                if(backtrack(matchsticks,idx-1,squareSide, side))
                    return true;
                //backtrack
                squareSide[i]-=matchsticks[idx];
            }
        }
        return false;
    }
}

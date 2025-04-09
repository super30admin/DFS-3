// TC:4^n
class Solution {
    public boolean makesquare(int[] matchsticks) {
        if(matchsticks==null||matchsticks.length<4) return false;

        int sum=0;
        for(int i:matchsticks){
            sum+=i;
        }
        if(sum%4!=0) return false;
        for(int match:matchsticks){
            if(match>sum/4) return false;
        }
        return dfs(matchsticks,new int[4],0,sum/4);
    }

    private boolean dfs(int[] matchsticks,int[] square, int idx, int side){
        if(idx==matchsticks.length){
            if(square[0]==side&&square[1]==side&&square[2]==side) return true;
            else return false;
        }
        for(int i=0;i<4;i++){
            if(square[i]+matchsticks[idx]<=side){
                square[i]+=matchsticks[idx];
                if(dfs(matchsticks,square,idx+1,side)) return true;
                square[i]-=matchsticks[idx];
            }
        }
        return false;
    }
}
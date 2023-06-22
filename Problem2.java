//Time -> O(4^n)
//Space -> O(1)
class Solution {
    public boolean makesquare(int[] matchsticks) {
        int n = matchsticks.length;
        int sum = 0;
        for(int i: matchsticks){
            sum += i;
        }
        if(sum % 4 != 0)
            return false;
        int side = sum/4;
        Arrays.sort(matchsticks);
        int square[] = new int[4];
        return backtrack(matchsticks, square, n, n - 1, side);
    }
    private boolean backtrack(int matchsticks[], int square[], int n, int idx, int side)    {
        if(-1 == idx){
            if(square[0] == side && square[1] == side && square[2] == side && square[3] == side){
                return true;
            }
            else{
                return false;
            }
        }
        for(int i = 0; i < 4; i++){
            if(matchsticks[idx] + square[i] <= side){
                square[i] += matchsticks[idx];
                if(backtrack(matchsticks, square, n, idx - 1, side))
                    return true;
                square[i] -= matchsticks[idx];
            }
        }
        return false;
    }
}

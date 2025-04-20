public class Solution {
    // TC => O(4^n)
    // SC => O(n)
    public bool Makesquare(int[] matchsticks) {
        if(matchsticks == null || matchsticks.Length < 4){
            return false;
        }

        int sum = 0;
        for(int i = 0; i< matchsticks.Length; i++){
            sum += matchsticks[i];
        }

        if(sum % 4 != 0){
            return false;
        }

        int side = sum / 4;
        Array.Sort(matchsticks);
        Reverse(matchsticks);

        return Backtrack(matchsticks, 0, new int[4], side);
    }

    public bool Backtrack(int[] matchsticks, int index, int[] square, int side){
        // base
        if(index == matchsticks.Length && square[0] == side && square[1] == side && square[2] == side){
            return true;
        }

        //logic
        for(int i = 0;i < 4; i++){
            if(square[i]+matchsticks[index] <= side){
                //action
                square[i] += matchsticks[index];

                //recurse
                if(Backtrack(matchsticks, index + 1, square, side)){
                    return true;
                }
                square[i] -= matchsticks[index];
            }
        }

        return false;
    }

    public void Reverse(int[] matchsticks){
        int l = 0;
        int r = matchsticks.Length - 1;
        while(l < r){
            Swap(matchsticks, l, r);
            l++;
            r--;
        }
    }

    public void Swap(int[] matchsticks, int i , int j){
        var temp = matchsticks[i];
        matchsticks[i] = matchsticks[j];
        matchsticks[j] = temp;
    }
}
public class MatchsticksToSquare {
    public boolean makesquare(int[] matchsticks) {
        int sum = 0;
        for(int match:matchsticks){
            sum+=match;
        }
        if(sum%4!=0) return false;
        int[] square = new int[4];
        Arrays.sort(matchsticks);
        reverse(matchsticks);
        return backtrack(matchsticks,square,0,sum/4);
    }

    private boolean backtrack(int[] matchsticks, int[] square, int i, int side){
        // base
        if(square[0]==side && square[1]==side && square[2]==side) return true;

        // logic
            for(int j=0;j<4;j++){ // always choosing thematchsticks - 1 - case (no 0 case)
                if(square[j]+matchsticks[i]<=side){
                    // action
                    square[j] += matchsticks[i];

                    // recusre
                    if(backtrack(matchsticks, square, i+1, side)) return true;

                    // backtrack
                    square[j] -= matchsticks[i];
                }
            }
        return false;
    }

    private void reverse(int[] arr){
        int left = 0, right = arr.length-1;
        while(left<right){
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            ++left;
            --right;
        }
    }
}

// TC - exponential - 4^n - four choices for each matchstick
// SC - O(n)
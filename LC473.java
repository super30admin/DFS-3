// TC: O(4^(n))
// SC: O(n)
// where n is the number of matchsticks

import java.util.Arrays;

public class LC473 {
class Solution {
    private boolean check(int arr[], int i, int[] sides, int ms){
        // BC
        if(i<0) return true;
        // Logic
        for(int k=0;k<4;k++){
            if(sides[k]+arr[i]>ms) continue;
            sides[k] += arr[i];
            if(check(arr, i-1, sides, ms)) return true;
            sides[k] -= arr[i];
        }
        return false;
    }
    public boolean makesquare(int[] matchsticks) {
        int n = matchsticks.length;
        int sum = 0;
        for(int i=0;i<n;i++){
            sum += matchsticks[i];
        }
        if(sum%4 != 0) return false;
        for(int i=0;i<n;i++){
            if(matchsticks[i]>(sum/4)) return false;
        }
        Arrays.sort(matchsticks);
        return check(matchsticks, n-1, new int[4], sum/4);
    }
}

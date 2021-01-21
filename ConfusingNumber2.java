package S30.DFS_3;


/*
Time Complexity : N*5^(Number of digits in N)
Space Complexity : O(5^Number of Digits in N) - recursive stack space
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : None
*/

import java.util.HashMap;

public class ConfusingNumber2 {

    int count;
    HashMap<Integer,Integer> flipMap;
    public int confusingNumberII(int N) {
        this.count = 0;
        this.flipMap = new HashMap<>();
        flipMap.put(0,0);
        flipMap.put(1,1);
        flipMap.put(6,9);
        flipMap.put(8,8);
        flipMap.put(9,6);
        dfs(0L,N);
        return count;

    }

    private void dfs(long current, int N){

        //logic
        if(isValid(current)) count++;
        for(int key : flipMap.keySet()){
            long nextNumber = current*10 + key;
            if(nextNumber <= N && nextNumber != 0){
                dfs(nextNumber, N);
            }
        }
    }

    private boolean isValid(long n){
        long original = n;
        long result = 0;
        while(n > 0){
            int digit = (int)(n % 10);
            result = result*10 + flipMap.get(digit);
            n = n/10;
        }
        return result != original;
    }
}

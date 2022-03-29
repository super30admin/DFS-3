// Time Complexity : O(5^k) ; 5 - roattion map has 5 digits and k is length of given num
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes

import java.util.HashMap;
import java.util.Map;

public class ConfusingNumberII {

    Map<Integer, Integer> map;
    int count;
    public int confusingNumberII(int n) {
        map = new HashMap<>();
        map.put(0,0);
        map.put(1,1);
        map.put(6,9);
        map.put(8,8);
        map.put(9,6);

        dfs(n,0);
        return count;
    }

    private void dfs(int n, long curr){
        //base
        if(curr > n) return;

        //logic
        if(isConfusingNum(curr)) count++;
        for(int key: map.keySet()){
            long newNum = curr * 10 + key;
            if(newNum != 0){
                dfs(n, newNum);
            }
        }
    }

    private boolean isConfusingNum(long num){
        long result = 0;
        long orig = num;

        while(num > 0){
            result = result * 10 + map.get((int)num % 10);
            num = num/10;
        }
        return orig != result;
    }
}

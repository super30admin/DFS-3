// Time Complexity: O(6^n)
// Space Complexity: O(1)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach

import java.util.*;
class Solution {
    HashMap<Integer, Integer> map;
    int count;
    public int confusingNumberII(int n) {
        map = new HashMap<>();
        map.put(0, 0);
        map.put(1, 1);
        map.put(6, 9);
        map.put(9, 6);
        map.put(8, 8);
        dfs(n, 0);
        return count;
    }
    private void dfs(int n, long curr) {
        if(curr > n) return;
        if(isValid(curr)) count++;
        // logic
        for(int key: map.keySet()) {
            long next = curr * 10 + key;
            if(next != 0)
                dfs(n, next);
        }
    }
    
    private boolean isValid(long num) {
        long result = 0;
        long initial = num;
        while(num > 0) {
            result = result * 10 + map.get((int)(num % 10));
            num = num / 10;
        }
        return initial != result;
    }
}
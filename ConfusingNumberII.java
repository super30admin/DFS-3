// Problem 1088. Confusing Number II
// Time Complexity : O(5^n)
// Space Complexity : O(logn)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
class Solution {
    private HashMap<Integer, Integer> map;
    private int count;
    
    public int confusingNumberII(int n) {
        this.map = new HashMap<>();
        map.put(0, 0);
        map.put(1, 1);
        map.put(6, 9);
        map.put(8, 8);
        map.put(9, 6);
        this.count = 0;
        dfs(0, n);
        return count;
    }

    private void dfs(long curr, int n) {
        if (curr > n) return;
        if (isConfusing(curr)) {
            count++;
        }
        for (int digit : map.keySet()) {
            long newNum = curr * 10 + digit;
            if (newNum == 0) continue;
            if (newNum > n) break;
            dfs(newNum, n);
        }
    }

    private boolean isConfusing(long orig) {
        long temp = orig;
        long rotated = 0;
        while (temp > 0) {
            int digit = (int) (temp % 10);
            rotated = rotated * 10 + map.get(digit);
            temp /= 10;
        }
        return rotated != orig;
    }
}
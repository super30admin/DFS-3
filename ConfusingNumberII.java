// Time Complexity : O(5^n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class Solution {
    HashMap<Integer, Integer> map = new HashMap<>();
    int count = 0;
    public int confusingNumberII(int n) {
        map.put(0, 0);
        map.put(1, 1);
        map.put(6, 9);
        map.put(8, 8);
        map.put(9, 6);
        dfs(n, 0);
        return count;
    }

    public void dfs(int n, long curr) {
        if(curr > n) return;
        if(isConfusing(curr)) count++;
        for(int key : map.keySet()) {
            long next = curr*10 + key;
            if(next != 0) dfs(n, next);
        }
    }

    public boolean isConfusing(long num) {
        long orig = num;
        long newNum = 0;
        while(num > 0) {
            long rem = num%10;
            newNum = newNum*10 + map.get((int)rem);
            num = num/10;
        }
        return newNum != orig;
    }
}
//TC: O(n)
//SC: O(n)
//Running on leetcode: yes
class Solution {
    int total;
    HashMap<Integer, Integer> map;
    public int confusingNumberII(int n) {
        if(n == 0) return 0;
        map = new HashMap<>();
        map.put(0, 0);
        map.put(1, 1);
        map.put(6, 9);
        map.put(8, 8);
        map.put(9, 6);
        dfs(n, 0);
        return total;
    }
    private void dfs(int n, long curr) {
        //base
        if(curr > n) {
            return;
        }
        //logic
        if (isValid(curr)) {
            total++;
        }
        for(int key : map.keySet()) {
            long next = curr * 10 + key;
            if(next != 0) {
                dfs(n, next);
            }
        }
        }
    private boolean isValid(long num) {
            long original = num;
            long rev = 0;
            while(num > 0) {
                rev = rev * 10 + map.get((int)num % 10);
                num = num / 10;
            }
            return rev != original;
    }
}

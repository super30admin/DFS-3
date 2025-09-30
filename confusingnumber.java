//Time Complexity: O(5^k): we branch on 5 valid digits per position and explore up to k positions (numbers ≤ n), so generation dominates.
//Space Complexity: O(k): recursion depth is at most the number of digits in n.

// Using DFS: start from 0, try appending {0,1,6,8,9}, skip leading-zero case (newNum != 0), and prune when newNum > n.
// For each formed number, build its rotated value by mapping digits (0↔0,1↔1,6↔9,8↔8,9↔6) from right to left.
// If rotated != original, count it; continue DFS until further extension would exceed n.

class Solution {
    HashMap<Integer, Integer> map;
    int count = 0;
    public int confusingNumberII(int n) {
        this.map = new HashMap<>();
        this.count = 0;

        map.put(0, 0);
        map.put(1, 1);
        map.put(6, 9);
        map.put(8, 8);
        map.put(9, 6);

        dfs(0l, n);

        return count;
    }

    private void dfs(long currNum, int n){
        if(isConfusing((int)currNum)) count++;

        for(int key: map.keySet()){
            long newNum = currNum * 10 + key;

            if(newNum != 0 && newNum <= n){
                dfs(newNum, n);
            }
        }
    }

    private boolean isConfusing(int num){
        int temp = num;
        int result = 0;
        while(num > 0){
            int lastDigit = num % 10;
            result = result * 10 + map.get(lastDigit);
            num = num / 10;
        }

        return result != temp;
    }
}

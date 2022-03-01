// Time Complexity = Exponential / O(5^n)
// Space Complexity = O(L), where L=no. of digits present in n
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
class Solution {
    int count;
    HashMap<Integer, Integer> map;

    public int confusingNumberII(int n) {
        if (n==0) return 0;
        map = new HashMap<>();
        map.put(0, 0);
        map.put(1, 1);
        map.put(6, 9);
        map.put(8, 8);
        map.put(9, 6);

        dfs(n, 0);
        return count;
    }

    // We are creating more numbers using the valid numbers in the map till we reach n
    private void dfs(int n, long curr) {
        // base
        if (curr > n) return;

        // logic
        if (isValid(curr)) count++;

        for (int key: map.keySet()) {
            long newNumber = (curr * 10) + key;
            if (newNumber != 0) {
                dfs(n, newNumber);
            }
        }
    }

    // This function is rotating the number in 180 degree and checking if its valid by comparing with the original number and if they are different then its valid
    private boolean isValid (long curr) {
        long result = 0;
        long original = curr;

        while(curr > 0) {
            result = (result*10)+map.get((int)(curr%10));
            curr = curr/10;
        }
        return original != result;
    }
}
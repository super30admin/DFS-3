// Time Complexity : O(5^d) d-number of digits
// Space Complexity : O(5^d)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach
// we start with 0 and form new numbers by appending 0,1,6,8,9 to it
// we check if the new number formed is confusing and if it is we increase count 
// append count only if the number is less than n

public class ConfusingNumbers {

    HashMap<Integer, Integer> map;
    int count;

    public int confusingNumberII(int n) {
        map = new HashMap<>();
        count = 0;

        map.put(0, 0);
        map.put(1, 1);
        map.put(6, 9);
        map.put(8, 8);
        map.put(9, 6);
        dfs(0, n);

        return count;
    }

    private void dfs(int curr, int n) {
        if (curr > n)
            return;

        if (isConfusing(curr))
            count++;

        for (int digit : map.keySet()) {
            int newNumber = curr * 10 + digit;
            if (newNumber == 0)
                continue;
            dfs(newNumber, n);
        }
    }

    private boolean isConfusing(int num) {
        int result = 0;
        int temp = num;

        while (temp > 0) {
            result = result * 10 + map.get(temp % 10);
            temp /= 10;
        }

        return num != result;
    }

}

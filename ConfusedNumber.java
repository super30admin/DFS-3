// Time Complexity: O(5 ^ d), where d is the nubmer of digits of input number n
// Space Complexity: (d) where d is also the height of the tree, if 5 ^ d = m, d = logtobase5(m)
class Solution {
    HashMap<Integer, Integer> map;
    int count;
    public int confusingNumberII(int n) {
        if (n==0) return 0;

        map = new HashMap<>();

        map.put(0,0);
        map.put(1,1);
        map.put(6, 9);
        map.put(8,8);
        map.put(9,6);

        dfs(0,n);
        return count;
    }

    private void dfs(long currNumber, int n) {
        if (currNumber >n) return;

        if(isValidConfusingNumber(currNumber)){
            count++;
        }

        for (int digit : map.keySet()) {
            long newNumber = currNumber * 10 + digit;
            if (newNumber != 0) {
                dfs(newNumber, n);
            }
        }
    }

    private boolean isValidConfusingNumber(long num) {
        long temp = num;
        long result = 0;
        while (temp > 0) {
            int digit = (int) temp % 10;
            result = result * 10 + (long)map.get(digit);
            temp = temp / 10;
        }

        return result != num;
    }
}
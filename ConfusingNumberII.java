Time Complexity: O(5 ^ n)
Space Complexity: O(1)

class Solution {
    HashMap<Integer, Integer> map;
    private int count;
    public int confusingNumberII(int n) {
        this.map = new HashMap<>();
        map.put(0, 0);
        map.put(1, 1);
        map.put(6, 9);
        map.put(8, 8);
        map.put(9, 6);

        dfs(0l, n);
        return count;        
    }

    private void dfs(long curr, int n){
        //base
        if(curr > n)
            return;
        //logic
        if(isConfusing(curr)){
            count++;
        }
        
        for(int digit : map.keySet()) {
            long newNum = curr * 10 + digit;
            if(newNum != 0)  {
                dfs(newNum, n);
            }
        }
    }

    private boolean isConfusing(long curr) {
        long result = 0l;
        long temp = curr;

        while(temp > 0) {
            int digit = (int)(temp % 10);
            result = result * 10 + map.get(digit);
            temp /= 10;
        }

        return result != curr;
    }
}
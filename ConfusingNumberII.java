// Time Complexity : O(5^L)
// Space Complexity : O(L)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Solution {
    int count;
    Map<Integer, Integer> map;
    public int confusingNumberII(int n) {
        if(n <= 0) {
            return 0;
        }
        
        map = new HashMap<>();
        
        map.put(0, 0);
        map.put(1, 1);
        map.put(6, 9);
        map.put(8, 8);
        map.put(9, 6);
        
        dfs(n, 0);
        
        return count;
    }
    
    private void dfs(int n, long currentNumber) {
        if(currentNumber > n) {
            return;
        }
        
        
        if(confusing(currentNumber)) {
            count++;
        }
        
        for(int number : map.keySet()) {
            long newNumber = (currentNumber * 10) + number;
            
            if(newNumber != 0) {
                dfs(n, newNumber);
            }
        }
    }
    
    private boolean confusing(long n) {
        long original = n;
        long reversed = 0;
        
        while(n > 0) {
            reversed = (reversed * 10) + map.get((int)n % 10);
            n = n / 10;
        }
        
        return original != reversed;
    }
}
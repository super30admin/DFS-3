// Time Complexity : O(exponential)    
// Space Complexity : O(Number of digits in n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Approach

// We make use of hashmap for quering and dfs to solve this problem

class Solution {
    HashMap<Integer, Integer> map;
    int count;
    public int confusingNumberII(int n) {
        map = new HashMap<>();
        map.put(0,0);
        map.put(1,1);
        map.put(6,9);
        map.put(8,8);
        map.put(9,6);
        
        dfs(n, 0);
        return count;
        
    }
    private void dfs(int n, long curr){
        if(curr>n)return;
        if(isValid(curr))count++;
        for(int key : map.keySet()){
            long number = curr *10 +key;
            if(number !=0)
                dfs(n, number);
        }
    }
    private boolean isValid(long num){
        long result = 0;
        long initial = num;
        while(num > 0){
            result = result *10 +map.get((int)(num%10));
            num = num/10;
        }
        return initial != result;
    }
}
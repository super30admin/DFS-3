
// Time Complexity : O(n^n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
// Backtracking
class Solution {
    
    Map<Integer, Integer> map = new HashMap<>();
    int count =0;
    
    public int confusingNumberII(int N) {
        map.put(0, 0);
        map.put(1, 1);
        map.put(6, 9);
        map.put(8, 8);
        map.put(9, 6);
        
        backtracking(N, 0);
        return count;
    }
    
    private void backtracking(int N, long current){
        if(isConfusing(current)){
            count++;
        }
        
        for(int key: map.keySet()){
            long next = current *10 + key;
            if(next <= N && next != 0){
                backtracking(N, next);
            }
        }
    }
    
    private boolean isConfusing(long N) {
        long src = N;
        long dest =0;
        
        while(src >0){
            dest = dest*10 + map.get((int)src % 10);
            src = src /10;
        }
        if(N != dest){
            return true;
        }
        
        return false;
    }
}
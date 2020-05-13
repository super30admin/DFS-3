// Time Complexity : O(5^10) 
// Space Complexity : O(5^10)
class Solution {
    int count;
    Map<Integer, Integer> map = new HashMap<>();
    public int confusingNumberII(int N) {
        map.put(0,0);
        map.put(1,1);
        map.put(6,9);
        map.put(8,8);
        map.put(9,6);
        count=0;
        backtrack(N, 0);
    return count;    
    }
    private void backtracking(int N, long current) {
        if(isConfusing(current)) count++;
        for(Integer i:map.keySet()) {
            long next=current*10+i;
            if(next <= N && next != 0)
                backtrack(N, next);
        }
        
    }
    private boolean isConfusing(long n) {
        //1689 --> 6891
        long src=n;
        long dest=0;
        while(n > 0) {
            dest=dest*10+map.get((int)n%10);
            n=n/10;
        }
        return src != dest;
    }
}

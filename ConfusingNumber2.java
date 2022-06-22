//TC : O(N^2) for-loop recursion
//SC : O(N) - Using map

class Solution {
    int result;
    HashMap<Integer, Integer> map = new HashMap<>();
    public int confusingNumberII(int n) {
        if(n == 0)  return 0;
        
        map.put(0,0); map.put(1,1); map.put(6,9); map.put(8,8); map.put(9,6);
        helper(n, 0);
        return result; // # of confusing numbers
    }
    
    public void helper(int n, long curr){
        if(curr > n)    return;
        if(getRotatedNumber(curr))  result++; // If curr is confusingNumber
        
        for(Integer i : map.keySet()){ // For-Loop recursion on curr
            long temp = curr * 10 + i; 
            if(temp != 0){
                helper(n, temp);
            }
        }
    }
    public boolean getRotatedNumber(long n){
       long ans = 0;
       long prev = n;
        
       while(n > 0){
           int c = (int)n % 10;
           ans = ans * 10 + map.get(c);
           n = n / 10;
       }
      return prev != ans;
    }
}

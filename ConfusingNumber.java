//TC - O(n^2)
//SC - O(n)
class Solution {
    int ans;
    HashMap<Integer, Integer> map = new HashMap<>();
    public int confusingNumberII(int n) {
        if(n == 0)  return 0;
        
        map.put(0,0); map.put(1,1); map.put(6,9); map.put(8,8); map.put(9,6);
        helper(n, 0);
        return ans;
    }
    
    public void helper(int n, long curr){
        if(curr > n)    return;
        if(rotatedNumber(curr))  ans++;
        
        for(Integer i : map.keySet()){
            long temp = curr * 10 + i; 
            if(temp != 0){
                helper(n, temp);
            }
        }
    }
    public boolean rotatedNumber(long n){
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

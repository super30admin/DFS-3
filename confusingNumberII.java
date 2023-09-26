// TC: O(5^k) k → number of digits in values of n, and 5 is total digits in map so at each place worst case we have 5possibilities
class Solution {
    HashMap<Integer, Integer> map;
    int count;
    public int confusingNumberII(int n) {
        if(n == 0) return 0;
        map = new HashMap<>();
        map.put(0,0);
        map.put(1,1);
        map.put(6,9);
        map.put(8,8);
        map.put(9,6);
        
        dfs(0, n);
        return count;
    }
    
    private void dfs(long currNum, int n){
        //base
        if(currNum > n) return;
        
        if(isConfusing(currNum)){
            count++;
        }
        
        //logic
        //form all possible numbers from hashmap
        for(int digit: map.keySet()){
            long newNum = currNum * 10 + digit;
            if(newNum == 0) continue; //as this will not move ahead of zero
            dfs(newNum, n);
        }
    }
    
    private boolean isConfusing(long num){
        long temp = num;
        int result = 0;
        while(num > 0){
            int lastDigit = (int)num % 10;
            result = result * 10 + map.get(lastDigit);
            num = num/10;
        }
        return temp != result;
    }
}

// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

class ConfusingNumbers {
      int count = 0;
        Map<Integer,Integer> map = new HashMap<>();
       
    public int confusingNumberII(int n) {
       map.put(0,0);
        map.put(1,1);
        map.put(6,9);
        map.put(9,6);
        map.put(8,8);
        dfs(0l,n);
        return count;
    }
    private void dfs(long currNum, int n){
        if(currNum>n)
            return;
        if(isConfusing(currNum)){
            count++;
        }
        for(int digit: map.keySet()){
            long newNum = currNum*10+digit;
            if(newNum!=0){
                dfs(newNum,n);
            }
        }
    }
    private boolean isConfusing(long num){
        long result = 0l;
        long temp = num;
        while(num>0){
            int digit = (int)num % 10;
            result = result*10 + map.get(digit);
            num = num/10l;
        }
        return result!=temp;
    }
}
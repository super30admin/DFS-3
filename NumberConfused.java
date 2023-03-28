public class NumberConfused {
    HashMap<Integer,Integer> map;
    List<Long> li;
    int result;
    public int confusingNumberII(int n) {
        map = new HashMap<>();
        map.put(0,0);
        map.put(1,1);
        map.put(6,9);
        map.put(8,8);
        map.put(9,6);
        dfs(0,n);
        return result;
    }
    private void dfs(long currNum, int n){
        // base
        if(currNum>n) return;

        if(isConfusing(currNum)) result++;
        // logic
        for(int dig: map.keySet()){
            long newNum = currNum*10+dig;
            if(newNum==0) continue;
            dfs(newNum,n);
        }
    }

    private boolean isConfusing(long num){
        long result = 0;
        long temp = num;
        while(num>0){
            int lastDigit = (int)num%10;
            result = result*10 + map.get(lastDigit);
            num = num/10;
        }
        return temp!=result;
    }
}

// TC - O(5^k) k - number of digits in given range
// SC - O(1)
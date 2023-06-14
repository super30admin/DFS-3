class Solution{
    HashMap<Integer, Integer> map;
    int count = 0;
    public int confusingNumber2(int n){
       map = new HashMap<>();
       map.put(0, 0);
       map.put(1, 1);
       map.put(6, 9);
       map.put(9, 6);
       map.put(8, 8);
       dfs(0l, n);
       return count;
    }
    private void dfs(int num, int n){
        if(count > n)
            return ; 
        if(isConfusing(num))
            count++;
        for(int digit: map.keySet()){
            long newNum = num * 10 + digit;
            if(newNum != 0)
                dfs(newNum, n);
        }
    }
    private boolean isConfusing(long num){
        long temp = num; 
        long result = 0;
        while(num > 0){
            int currDigit = (int)num % 10; 
            result = result * 10 + map.get(currDigit);
            num = num / 10;
        }
        return result != temp;
    }
}

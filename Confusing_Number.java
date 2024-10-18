// Time Complexity : O(n*5^l) ; l = number of digits in number
// Space Complexity : O(l)
// Did this code successfully run on Leetcode : No, Premium Question
// Any problem you faced while coding this : No

    int cnt;
    HashMap<Long, Long> map;
    public int countConfusingNum(int n){
        map = new HashMap<>();
        map.put((long)0,(long)0);
        map.put((long)1,(long)1);
        map.put((long)6,(long)9);
        map.put((long)8,(long)8);
        map.put((long)9,(long)6);
        
        dfs(0, n);
        return cnt;
    }
    private void dfs(long curr, int n){
        //base
        if(curr > n){
            return;
        }

        if(revPossible(curr)){
            cnt++;
        }

        for(long key : map.keySet()){
            long num = curr * 10 + key;
            dfs(num, (int)key);
        } 
    }

    private boolean revPossible(long num){
        long rev = 0;
        long temp = num;
        while(temp >0){
            long rem = temp %10;
            rev = rev*10 + map.get(rem);
            temp = temp/10;
        }
        return rev != num; 
    }
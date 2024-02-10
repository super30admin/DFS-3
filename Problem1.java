// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class Solution {
    HashMap<Integer,Integer> map;
    int count;
    public int confusingNumberII(int n) {
        this.map = new HashMap<>();
        map.put(0,0);map.put(1,1);map.put(6,9);map.put(8,8);map.put(9,6);
        dfs(0l,n);
        return count;
    }
    public void dfs(long curr, int n){
        if(curr > n)
            return;
        if(isConfusing(curr))
            count++;
        for(int num : map.keySet()){
            long newNum =  curr*10 + num;
            if(newNum != 0)
                dfs(newNum,n);
        }
    }
    public boolean isConfusing(long curr){
        long temp = curr;
        long res = 0;
        while(temp > 0){
            int digit = (int)temp%10;
            res = res*10 + map.get(digit);
            temp = temp/10;
        }
        return res != curr;
    }
}

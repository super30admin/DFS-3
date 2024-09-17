// Time Complexity :O(5^n) where n is the number of digits in input
// Space Complexity :O(n) where n is the number of digits in input
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :int was giving error for 10^9. Had to use long


// Your code here along with comments explaining your approach

class Solution {
    int count;
    HashMap<Integer, Integer> map;
    public int confusingNumberII(int n) {
        count = 0;
        map = new HashMap<>();
        map.put(0,0);
        map.put(1,1);
        map.put(6,9);
        map.put(9,6);
        map.put(8,8);
        dfs(0, n);
        return count;
    }

    private void dfs(long num, int n){
        //base
        if(num > n) return;
        //logic
        if(check(num)){
            count++;
        }
        for(int key: map.keySet()){
            long baby = num*10 + key;
            if(baby != 0 && baby <= n){
                dfs(baby, n);
            }
        }
    }

    private boolean check(long num){
        long temp = num;
        long res = 0;
        while(temp > 0){
            int mo = (int)(temp%10);
            res = (res * 10) + map.get(mo);
            temp = temp/10;
        }
        return res != num;
    }
}
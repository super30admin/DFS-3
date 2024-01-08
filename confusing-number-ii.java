// Time Complexity : O(d), where d is the number of digits in n
// Space Complexity : O(d), where d is the number of digits in n
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : -

// Your code here along with comments explaining your approach

class Solution {
    HashMap<Integer, Integer> map;
    int count;
    List<Long> li;
    public int confusingNumberII(int n) {
        map = new HashMap<>();
        li = new ArrayList<>();
        map.put(0,0);
        map.put(1,1);
        map.put(6,9);
        map.put(8,8);
        map.put(9,6);
        dfs(0l, n);
        return count;
    }
    private void dfs(long num, int n){
        //base
        if(num >= n)
            return;
        //logic
        for(int key: map.keySet()){
            long newNum = num * 10 + key;
            if(newNum <= n && newNum != 0){
                if(isConfusing(newNum)){
                    count++;
                    li.add(newNum);
                }
                dfs(newNum, n);
            }
        }
    }
    private boolean isConfusing(long num){
        long temp = num;
        long result = 0;
        while(num > 0){
            int digit = (int) (num % 10);
            result = result * 10 + map.get(digit);
            num = num / 10;
        }
        return result != temp;
    }
}
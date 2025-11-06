// This solution uses a DFS based logic where we start with the initial set of keys that can actually rotate
// We keep generating the combinations and if its valid then add it to the queue
// We continue this process until we are able to generate elements <=n
class Solution {

    Map<Integer, Integer> map;
    int total = 0;

    public int confusingNumberII(int n) {
        int number = n;
        map = new HashMap();
        map.put(0, 0);
        map.put(1, 1);
        map.put(6, 9);
        map.put(8, 8);
        map.put(9, 6);

        dfs(0l, n);
        return total;
    }

    private void dfs(long num, int n) {

         for(int i:map.keySet()) {
            long temp=num*10+i;
            if(temp!=0 && temp<=n) {
                int rev = getReverse((int)temp);
                if(rev!=temp) total++;
                dfs(temp, n);
            }
        }
    }

    private int getReverse(int num) {
        int rev = 0;

        while(num!=0) {
            rev = rev*10+(map.get(num%10));
            num=num/10;
        }
        return rev;
    }
}

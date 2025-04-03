class Solution {
    int count=0;
    Map<Integer, Integer> m =null;
    public int confusingNumberII(int n) {
        m = new HashMap<>();
        m.put(0,0);
        m.put(1,1);
        m.put(6,9);
        m.put(9,6);
        m.put(8,8);
        dfs(0, n);
        return count;
    }
    private void dfs(long number, int limit) {
        if (number > limit) {
            return;
        }
        if(ifConfusing(number)) {
            count++;
        }
        for(int key:m.keySet()) {
            long newnumber = number * 10 + key;
            //if(newnumber <= limit && ifConfusing(newnumber)) {
                //count++;
                if (newnumber != 0) {
                    dfs(newnumber, limit);
                }
            //}
        }
    }

    private boolean ifConfusing(long newnumber) {
        long rev=0;
        long num=newnumber;
        while(num > 0) {
            int rem=(int)(num %10);
            rev=rev * 10 + m.get(rem);
            num=num/10;
        }
        if (rev != newnumber) {
            return true;
        }
        return false;
    }
}

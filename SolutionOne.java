/*
// Time Complexity :  O(10^5)
// Space Complexity : O(n) for extra HashMap but digits are fixed so not sure
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this : nopes
 */

class Solution {
    public int confusingNumberII(int N)
    {
        map = new HashMap<>();

        map.put(0,0);
        map.put(1,1);
        map.put(6,9);
        map.put(8,8);
        map.put(9,6);

        dfs(N,0);

        return count;
    }
    private void dfs(int N,long current)
    {
        //logic
        if(isValid(current))
        {
            count++;
        }

        //get all the 5 keys and perform dfs on those keys
        for(Integer key:map.keySet())
        {
            long next = current * 10 + key;

            if(next!=0 && next<=N)
            {
                dfs(N, next);
            }
        }

    }

    private boolean isValid(long N)
    {
        long no=0;
        long src=N;

        while(N>0)
        {
            no = no*10 + map.get((int)N%10);

            N = N/10;
        }

        return no != src;
    }
}
// Time Complexity: O(5^L) since 5 options from map where max L digits
// Space Complexity: O(L) where the stack space would be for L digits 
public class ConfusingNumberII {
    Map<Integer, Integer> map;
    int count = 0;

    public int confusingNumberII(int n) {
        if(n == 0)
            return count; // 0 180 rotated would 0 which is not different no hence not confusing

        // create a map of valid numbers to generate all numbers in range n
        map = new HashMap<>();
        map.put(0,0);
        map.put(1,1);
        map.put(6,9);
        map.put(8,8);
        map.put(9,6);


        // use DFS to recursively generate all numbers
        dfs(n, 0);

        return count;
    }

    // generate all valid numbers in range of n
    // check if it is confusing number
    // use long for curr to avoid integer overflow
    private void dfs(int n, long curr)
    {
        if(curr > n)
            return; // since this moves us out of range
        
        if(isConfusingNo(curr))
            count++;

        // generate the next num
        for(int key : map.keySet())
        {
            long newNo = curr * 10 + key;
            if(newNo == 0)
                continue;
            dfs(n, newNo);
        }
    }

    private boolean isConfusingNo(long num)
    {
        long reverse = 0;
        long actual = num;

        while(num > 0)
        {
            reverse = reverse * 10 + map.get((int)(num%10));
            num = num/10;
        }

        return reverse != actual;
    }
}

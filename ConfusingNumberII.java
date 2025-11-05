import java.util.HashMap;
//Time Complexity: O(5^k)
//Space Complexity: O(k)
//We build numbers using only the digits {0,1,6,8,9} using DFS and explore all such combinations up to n.
//For each valid number, we check if its rotated version is different to count it as confusing.
class Solution{
    HashMap<Integer, Integer> hm;
    int count = 0;
    public int confusingNumberII(int n)
    {
        this.hm = new HashMap<>();
        this.count = 0;
        hm.put(0,0);
        hm.put(1,1);
        hm.put(6,9);
        hm.put(8,8);
        hm.put(9,6);

        dfs(0l,n);
        return count;

    }

    private void dfs(long currNum, int n){
        if(isConfusing((int)currNum)) count++;
        for(int key: hm.keySet())
        {
            long newNum = currNum * 10 + key;
            if(newNum != 0 && newNum <= n);{
                dfs(newNum, n);
            }
        }
    }

    private boolean isConfusing(int num)
    {
        int temp = num;
        int result = 0;
        while(num>0)
        {
            int lastdigit = num % 10;
            result = result * 10 + hm.get(lastdigit);
            num = num/10;
        }
        return result != temp;
    }
}
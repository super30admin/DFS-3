public class Solution {
    // TC => O(5 ^L) L is total digits in n
    // SC => O(L)
    Dictionary<int, int> lookup;
    int count = 0;
    public int ConfusingNumberII(int n) {
        if(n == 0){
            return 0;
        }
        lookup = new Dictionary<int, int>();
        lookup.Add(0,0);
        lookup.Add(1,1);
        lookup.Add(6,9);
        lookup.Add(8,8);
        lookup.Add(9,6);
        Dfs(0, n);
        return count;
    }

    public void Dfs(long current, int end){
        //base
        if(current > end){
            return;
        }

        //logic
        if(IsConfusing(current)){
            count++;
        }
        foreach(var kv in lookup){
            long newNumber = current * 10 + kv.Key;
            if(newNumber != 0){
                Dfs(newNumber, end);
            }
        }
    }

    public bool IsConfusing(long num){
        long rev = 0;
        long temp = num;
        while(num > 0){
            int rem = (int)num % 10;
            rev = rev * 10 + lookup[rem];
            num = num / 10;
        }
        return temp != rev;
    }
}
//time complexity- O(5^m) where m is the number of digits in n
//space complexity- O(n)
import java.util.*;
public class NumberConfused {

    static int count = 0;
    static int confusingNumber(int n) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,0);
        map.put(1, 1);
        map.put(6, 9);
        map.put(8, 8);
        map.put(9, 6);
        dfs(0l, n, map);
        return count;
    }
    private static void dfs(long curr, int n, HashMap<Integer, Integer> map) {
        if(curr > n) return;
        if(isConfusing(curr, map)) count++;
        for(int i : map.keySet()){
            long newN = curr*10 + (long)(i);
            if(newN == 0) continue;
            dfs(newN, n, map);
        }
    }
    private static boolean isConfusing(long num, HashMap<Integer, Integer> map) {
        long temp = num;
        long ans = 0;
        while(num > 0) {
            int rem = (int)(num%10);
            ans = (ans*10) + (long)(map.get(rem));
            num /= 10;
        }
        if(temp == ans) return false;
        return true;
    }
    public static void main(String[] args) {
        int  n = 10000;
        System.out.println("Total Confused Numbers till "+ n+ " is "+ confusingNumber(n));
    }
}

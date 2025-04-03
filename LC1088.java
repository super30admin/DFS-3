// TC: O(5^(log10(n)) * log10(n))
// SC: O(log10(n))
// where m is the number of digits in n

import java.util.*;

public class LC1088 {
    HashMap<Integer, Integer> map;
    int count;
    private boolean isConfusing(long org){
        long rev = 0, temp = org;
        while(temp>0){
            int rem = (int)(temp%10);
            rev = rev*10 + map.get(rem);
            temp /= 10;
        }
        return rev!=org;
    }
    private void countConfusingNums(long num, int n){
        //BC
        if(num>n) return;
        //Logic
        if(isConfusing(num)) count++;
        for(int key: map.keySet()){
            long nn = num * 10 + key;
            if(nn!=0) countConfusingNums(nn, n);
        }
    }
    public int confusingNumberII(int n) {
        map = new HashMap<>();
        map.put(0,0);
        map.put(1,1);
        map.put(6,9);
        map.put(8,8);
        map.put(9,6);
        countConfusingNums(0, n);
        return count;
    }
}

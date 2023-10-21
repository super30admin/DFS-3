import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

// Time Complexity : O(5^k) k is the number of digits in the number n;
// Space Complexity : O(5+k)
// Did this code successfully run on Leetcode : Yes

public class ConfusingNumbersII {
    HashMap<Integer, Integer> map ;
    List<Integer> confusingNumbers;
    int result;
    public int confusingNumberII(int n) {
        confusingNumbers = new ArrayList<>();
        map = new HashMap<>();
        map.put(0,0);
        map.put(1,1);
        map.put(6,9);
        map.put(8,8);
        map.put(9,6);

        helper(0l,n);
        System.out.println(confusingNumbers);
        return result;
    }

    private void helper(long currNum, int n){
        if(currNum > n) return;
        if(isConfusing(currNum)){
            confusingNumbers.add((int)currNum);
            result++;
        }
        for(int i: map.keySet()){
            long nextNum = currNum*10 + i;
            if(nextNum != 0)
                helper(nextNum,n);
        }
    }

    private boolean isConfusing(long num){
        long temp = num;
        long currNum=0;
        while(num > 0){
            int lastDigit = (int)num%10;
            num = num/10;
            currNum = currNum*10 + map.get(lastDigit);
        }
        return currNum != temp;
    }
}
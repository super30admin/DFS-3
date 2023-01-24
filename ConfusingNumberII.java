package s30.DFS1.DFS3;

import java.util.HashMap;
import java.util.Map;


//Algo:- utility method to find the confusing number. Generate numbers recursively
// and check the validity until the number is greater than the limit.

//TC: O ( 5 ^ n * log n)
//SC: O(logn)
public class ConfusingNumberII {
    Map<Integer, Integer> map;
    int count;
    public int confusingNumberII(int n) {

        map = new HashMap();

        map.put(0,0);
        map.put(1,1);
        map.put(6,9);
        map.put(8,8);
        map.put(9,6);

        confusingNumberII(0, n);

        return count;

    }


    private void confusingNumberII(long curr, int n){
        //base
        if(curr > n) return;

        if(isConfusing(curr)) count++;

        // System.out.println(curr + " "+ isConfusing(curr));

        //recurse
        for(int key : map.keySet()){

            long num = curr * 10 + key;

            if(num !=0)
                confusingNumberII(num, n);

        }
    }


    private boolean isConfusing(long number){

        long orig = number;
        long reverse=0;

        while(number > 0){

            int temp = (int) (number % 10);

            if(!map.containsKey(temp)) return false;

            reverse = reverse * 10 + map.get(temp);
            number /= 10;
        }

        return reverse != orig;

    }
    public static void main(String[] args) {

    }
}

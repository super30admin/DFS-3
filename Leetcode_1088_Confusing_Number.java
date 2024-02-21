/*
Approach: 
Brute force
1. Tke number from 1 to n and check each if that's the confusing number or not. 
TC: O(n*9) - 9 digit check at max.for n numbers

Optimized Approach: 

1. We'll make a  map for original and rotated array combination
2. perform DFS operation over all these numbers, 
3. So instead of going over all n numbers and checking them, I will go over the available confusing number and make different combination numbers out of it and check if that make a confusing number
4. even if I can make a number with confusingdigits - 182 - it will generate an invalid combination when 2 is rotated.

1st level - 0,1,6,8,9 . . 
2nd level has 0, 10,11,16,18,19 . . .
3rd level - 100, 101, 106, 108, 109 . . ./

TC: O(5^k) ; only 5 choices at a level, k = total digits in a number
sc: O(k) - height of the tree.*/


class Solution {
    
    Map<Long, Long> map;
    int result =0;
    public int confusingNumberII(int n) {
        if(n ==0) return 0;
    
        map = new HashMap<>();
        map.put(1l,1l);
        map.put(6l,9l);
        map.put(9l,6l);
        map.put(8l,8l);
        map.put(0l,0l);
        
        
        dfs(0,n);
        return result;
         
    }
    
    private void dfs(long currNum, int bound)
    {
        //base case
        if(currNum > bound)
            return;
        
        if((isConfusingNumber(currNum)))
        {
            result++;
        }
        //logic
        //go over key set to make all combinations possible
        
        for(long n : map.keySet())
        {
            long newNum = currNum *10 + n;
            if(newNum != 0) //to avoid the infinite loop condition where number is 00000 and never exiting dfs as it's always less than given n
            {
                dfs(newNum, bound);
            }
        }
    }
    
    private boolean isConfusingNumber(long num)
    {
        long temp =num;
        long curr =0;
        
        while(num >0)
        {
            int lastDigit = (int)num%10;
            curr = curr*10 + map.get((long)lastDigit);
            num=num/10;
        }
        // System.out.println("curr : "+curr+ " old: "+temp);
        return curr != temp;
    }
}
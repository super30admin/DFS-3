// Time Complexity : O(5^d) where d is the (log n) base 10
// Space Complexity : O(d) for the backtrack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// Create hashmap of the numbers which are valid on inversion
// Now create a isConfusing method that would check if the number after the 180 degree rotation is different
// We will now call the backtrack method to generate all possible numbers and check each of the 
// If the no. is confusing then we will incerement the count and finally return the count
class Solution {
    Map<Integer, Integer> hm;
    int count;
    int[] arr = {0,1,6,8,9};
    public int confusingNumberII(int n) {
        count = 0;
        hm = new HashMap<>();
        hm.put(0,0);
        hm.put(1,1);
        hm.put(8,8);
        hm.put(9,6);
        hm.put(6,9);
        backtrack(n,0);
        return count;
    }
    void backtrack(int n, long num){
        //base
        if(num > n)
            return;
        //recurse
        if(isConfusing(num))
            count++;
        for(int i = 0; i < 5; i++){
            long number = 10 * num + arr[i];
            if(number > 0)
                backtrack(n, number);
        }
    }
    boolean isConfusing(long num){
        long temp = num;
        long newNum = 0;
        while(temp > 0){
            long digit = temp % 10;
            temp /= 10;
            newNum = newNum * 10 + hm.get((int)digit);
        }
        return num != newNum;
    }
}
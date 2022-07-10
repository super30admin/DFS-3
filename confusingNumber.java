/*
Problem: https://leetcode.com/problems/confusing-number-ii/

A confusing number is a number that when rotated 180 degrees becomes a different number with each digit valid.
We can rotate digits of a number by 180 degrees to form new digits.

When 0, 1, 6, 8, and 9 are rotated 180 degrees, they become 0, 1, 9, 8, and 6 respectively.
When 2, 3, 4, 5, and 7 are rotated 180 degrees, they become invalid.
Note that after rotating a number, we can ignore leading zeros.

For example, after rotating 8000, we have 0008 which is considered as just 8.
Given an integer n, return the number of confusing numbers in the inclusive range [1, n].
*/

/*
0, 1, 8, 11, 111 etc are not confusing numbers because their rotation gives the same number.The question says we need a different number.
*/

// Approach 1: DFS
// TC: O(exponential) but still less than O(n) because in case of brute force, we could check if each number from 0 - n is confusing
// SC: O(number of digits in n)
class Solution {
    int count = 0;
    public int confusingNumberII(int n) {
        if (n == 0)
            return 0;
        
        HashMap<Integer, Integer> numberRotationMap = populateMap();
        dfs(n, 0, numberRotationMap);
        return count;
    }
    
    private void dfs(int n, long curNumber, HashMap<Integer, Integer> map) {
        if (curNumber > n)
            return;
        
        if (isValidConfusingNumber(curNumber, map)) {
            ++count;
        }
        
        for (int key : map.keySet()) {
            long newNumber = curNumber * 10 + key;
            // Needed so that we don't keep multiplying 0 with 0
            // Would lead to stack overflow error.
            if (newNumber != 0)
                dfs(n, newNumber, map);
        }
    }
    
    private boolean isValidConfusingNumber(long number, HashMap<Integer, Integer> map) {
        long original = number;
        long reversedNumber = 0;
        
        while (number > 0) {
            reversedNumber = reversedNumber * 10 + map.get((int)number % 10);
            number = number / 10;
        }
        
        return (original != reversedNumber);
    }
    
    private HashMap<Integer, Integer> populateMap() {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);
        map.put(1, 1);
        map.put(6, 9);
        map.put(8, 8);
        map.put(9, 6);
        
        return map;
    }
}
// Confusing Number II
// Time Complexity: O(5 ^ n) where n = number of digits
// Space Complexity: O(1)

class Solution {
    HashMap<Integer, Integer> map;
    int count;
    public int confusingNumberII(int N) {
        map = new HashMap<>();
        count = 0;
        // creating map with confusing number and their rotated number
        map.put(0, 0);
        map.put(1, 1);
        map.put(6, 9);
        map.put(8, 8);
        map.put(9, 6);
        // calling backtracking
        backtracking(N, 0);
        
        return count;
    }
    
    private void backtracking(int N, long current) {
        // base condition
        if (isConfusing(current)) {
            count += 1;
        }
        // looping over map
        for (int key : map.keySet()) {
            // getting next number
            long next = current * 10 + key;
            // if number is less than equal to given N and not equal to 0, then call backtracking
            if (next <= N && next != 0) {
                backtracking(N, next);
            }
        }
    }
    // method to check if the number is confusing number
    private boolean isConfusing(long current) {
        long src = current;
        int dest = 0;
        // while condition
        while (src > 0) {
            // System.out.println(src);
            // getting 180 degree rotation of the number 
            dest = dest * 10 + map.get((int)src % 10);
            src = src / 10;
        }
        // if original number not equals rotated confusing number, then return true
        if (current != dest) {
            return true;
        }
        // else return false
        return false;
    }
}

// Matchsticks to Square
// Time Complexity: O(4 ^ n)
// Space Complexity: O(4) => O(1)

class Solution {
    public boolean makesquare(int[] nums) {
        if (nums == null || nums.length < 4) {
            return false;
        }
        
        int sum = 0;
        // get the sum of all the numbers
        for (int num : nums) {
            sum += num;
        }
        // if sum mod 4 is 0, then proceed
        if (sum % 4 != 0) {
            return false;
        }
        // calling backtracking
        return backtracking(nums, 0, sum/4, new int[4]);
    }
    
    private boolean backtracking(int[] nums, int index, int target, int[] square) {
        // base condition
        if (index == nums.length) {
            // if all 4 sides are equal to target, then square is possible
            if (square[0] == target && square[1] == target && square[2] == target && square[3] == target) {
               return true; 
            }
            // else return false
            return false;
        }
        // loop over all 4 sides
        for (int i=0; i<square.length; i++) {
            // if current side + additional exceeds target, then continue to next side
            if (square[i] + nums[index] > target) {
                continue;
            }
            // calculate current side
            square[i] += nums[index];
            // if backtracking returns true, then directly return true
            if (backtracking(nums, index + 1, target, square)) {
                return true;
            }
            // else remove the current side
            square[i] -= nums[index];
        }
        
        return false;
    }
}

// Time Complexity: O(nlogN) + O(5 ^ n) where n is the length of the input string
// Space Complexity: o(n) where n is the lenght of the array
class Solution {
    public boolean makesquare(int[] matchsticks) {
        if(matchsticks == null || matchsticks.length == 0) return false;

        int sum = 0;

        for (int match : matchsticks) {
            sum += match;
        }

        if (sum % 4 != 0) {
            return false;
        }
        int [] sides = new int[4];
        int side = sum / 4;
        int index = 0;
        // Sort the array in descending order
        Arrays.sort(matchsticks);
        reverse(matchsticks);

        return backtrack(matchsticks, side, index, sides);
    }

    private boolean backtrack(int[] matchsticks, int side, int index, int[] sides) {
        // base
        if (index == matchsticks.length) {
            if (sides[0] == side && sides[1] == side && sides[2] == side) {
                return true;
            }
            return false;
        }

        // logic
        for (int i=0; i < 4; i++) {
            if (sides[i] + matchsticks[index] <= side) {
                sides[i] += matchsticks[index];
                if (backtrack(matchsticks, side, index+1, sides)) {
                    return true;
                }
                sides[i] = sides[i] - matchsticks[index];
            }
        }
        return false;
    }

    private void reverse (int[] nums) {
        int left = 0;
        int right = nums.length-1;
        while (left <= right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }

    private void swap (int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}
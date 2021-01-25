// Time Complexity - O(4^n +nlogn)
// Space Complexity - O(1)

class Solution {
    public boolean makesquare(int[] nums) {
        if(nums == null || nums.length < 4) return false;

        int sum = 0;
        for(int num : nums) sum += num;
        if(sum % 4 != 0) return false;

    	Arrays.sort(nums);
    	reverse(nums);

    	return backtrack(nums, new int[4], 0, sum/4);
    }

    private boolean backtrack(int[] nums, int[] sides, int cursor, int target) {
    	// goal state check
    	if(cursor == nums.length) {
    		if(sides[0] == target && sides[1] == target && sides[2] == target) {
    			return true;
    		}
    		return false;
    	}

    	for(int i = 0; i < 4; i++) {
    		if(sides[i] + nums[cursor] > target) continue;

    		sides[i] += nums[cursor];
    		if(backtrack(nums, sides, cursor + 1, target)) return true;
    		sides[i] -= nums[cursor];
    	}

    	return false;
    }

    public static void reverse(int[] input) {
    	int start = 0;
    	int end = input.length - 1;
    	int mid = input.length / 2;

    	while(start <= mid) {
    		int temp = input[start];
    		input[start] = input[end];
    		input[end] = temp;

    		start++;
    		end--;
    	}
    }

}
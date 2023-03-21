//time complexity: O(4^N)
//sapce compelxity:O(N)
//ran on leetcode: Yes
//sum of all lenght divided by 4 should give the length of each side of the square. Use an array to track lenghts of the 4 sides. Recursively add elements to these 4 indexes in arrays and see if the desired lenghts can be obtained.
public class Solution {

    public boolean makesquare(int[] nums) {

    	if (nums == null || nums.length < 4) return false;

        int sum = 0;

        for (int num : nums) sum += num;

        if (sum % 4 != 0) return false;

        Arrays.sort(nums);
        int i=0;
        int j=nums.length-1;
        while(i<j){
            int temp=nums[i];
            nums[i]=nums[j];
            nums[j]=temp;
            i+=1;
            j-=1;
        }

    	return dfs(nums, new int[4], 0, sum / 4);

    }

    

    private boolean dfs(int[] nums, int[] sums, int index, int target) {

    	if (index == nums.length) {

    	    if (sums[0] == target && sums[1] == target && sums[2] == target) {

    		return true;

    	    }

    	    return false;

    	}

    	

    	for (int i = 0; i < 4; i++) {

    	    if (sums[i] + nums[index] > target) continue;

    	    sums[i] += nums[index];

            if (dfs(nums, sums, index + 1, target)) return true;

    	    sums[i] -= nums[index];

    	}

    	

    	return false;

    }

}

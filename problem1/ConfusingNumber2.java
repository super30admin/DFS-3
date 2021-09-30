// Time Complexity : O(5^d), d -> Number of digits
// Space Complexity : O(d)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
package problem1;

import java.util.HashMap;
import java.util.Map;

public class ConfusingNumber2 {
	Map<Integer, Integer> map;
	int cnt;

	public int confusingNumberII(int n) {
		if (n < 6) {
			return 0;
		}

		map = new HashMap<>();
		map.put(0, 0);
		map.put(1, 1);
		map.put(6, 9);
		map.put(8, 8);
		map.put(9, 6);
		cnt = 0;
		helper(n, 0L);

		return cnt;
	}

	private void helper(int n, long num) {
		// Base
		if (num > n) {
			return;
		}
		// Logic
		if (isConfusing(num)) {
			cnt++;
		}

		for (int key : map.keySet()) {
			long next = num * 10 + key;
			if (next != 0) {
				helper(n, next);
			}
		}
	}

	private boolean isConfusing(long num) {
		long rotatedNum = 0;
		long temp = num;
		while (temp != 0) {
			rotatedNum = rotatedNum * 10 + map.get((int) temp % 10);
			temp /= 10;
		}

		return rotatedNum != num;
	}

	public static void main(String[] args) {
		ConfusingNumber2 obj = new ConfusingNumber2();
		int n = 1000000000;

		System.out.println("Number of confusing numbers in the range [1.." + n + "] = " + obj.confusingNumberII(n));
	}

}

package dfs3;

import java.util.HashMap;
import java.util.Map;

public class ConfusingNumberII {
	//Time Complexity : O(5^k), where k is digits in n
	//Space Complexity : O(1)
	//Did this code successfully run on Leetcode : Yes
	//Any problem you faced while coding this : No
	int count = 0;
	Map<Integer, Integer> map;
	public int confusingNumberII(int n) {
		map = new HashMap<>();
		map.put(0, 0);
		map.put(1, 1);
		map.put(6, 9);
		map.put(8, 8);
		map.put(9, 6);
		dfs(n, 0);
		return count;
	}

	private void dfs(int n, long start) {
		// base
		if(start > n)
			return;

		// logic
		if(isConfusing(start))
			count++;
		for(int i: map.keySet()) {
			long num = (start * 10) + i;
			if(num != 0)
				dfs(n, num);
		}
	}

	private boolean isConfusing(long num) {
		long n = num;
		long res = 0;
		while(n > 0) {
			res = (res * 10) + map.get((int)n % 10);
			n /= 10;
		}

		return res != num;
	}
}

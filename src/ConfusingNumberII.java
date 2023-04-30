import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
//Time Complexity : Not able to calculate
//Space Complexity : Not able to calculate
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No

/**
 * Push all the single digit numbers which are valid after rotating, to a queue.
 * Then pop each one and check if it is confusing. Confusing means after
 * reversing the number and each digit with its corresponding rotated number, it
 * is not equal to the original number. If so, increment the count and then
 * update that number with multiplying by 10 and adding all the single digits
 * which are valid. Push these numbers to queue if they are less than n. finally
 * return count. Since we are using only the limited digits which are valid, the
 * numbers formed will also be valid.
 *
 */
class Solution {
	public int confusingNumberII(int n) {
		Queue<Long> q = new LinkedList<>();
		q.addAll(Arrays.asList(new Long[] { 1L, 6L, 8L, 9L }));
		int count = 0;
		while (!q.isEmpty()) {
			long num = q.poll();
			if (num > n)
				continue;
			if (num != check(num))
				count++;
			if (num * 10 <= n)
				q.add(num * 10);
			if (num * 10 + 1 <= n)
				q.add(num * 10 + 1);
			if (num * 10 + 6 <= n)
				q.add(num * 10 + 6);
			if (num * 10 + 8 <= n)
				q.add(num * 10 + 8);
			if (num * 10 + 9 <= n)
				q.add(num * 10 + 9);
		}

		return count;
	}

	private long check(long num) {
		long newNum = 0;
		while (num > 0) {
			long rem = num % 10;
			if (rem == 6)
				rem = 9;
			else if (rem == 9)
				rem = 6;
			newNum = newNum * 10 + rem;
			num /= 10;
		}
		return newNum;
	}
}
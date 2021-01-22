import java.util.HashMap;
//time complexity : O(5^length of the number given)
public class ConfusingNumber {
	HashMap<Integer, Integer> map;
	int count = 0;

	public int confusingNo(int N) {
		map = new HashMap<Integer, Integer>();

		map.put(0, 0);
		map.put(1, 1);
		map.put(6, 9);
		map.put(8, 8);
		map.put(9, 6);

		dfs(N, 0);
		return count;
	}

	private void dfs(int N, long current) {
		// TODO Auto-generated method stub

		// logic
		if (isValid(current)) {
			count++;
		}
		for (Integer keyEle : map.keySet()) {
			long next = current * 10 + keyEle;
			if (next != 0 && next <= N) {
				dfs(N, next);
			}
		}

	}

	private boolean isValid(long n) {
		long result = 0;
		long src = n;

		while (n > 0) {
			result = result * 10 + map.get(((int)n % 10));
			n = n / 10;
		}

		return result != src;
	}

	public static void main(String[] args) {
		ConfusingNumber c = new ConfusingNumber();
		System.out.println(c.confusingNo(20));
	}

}

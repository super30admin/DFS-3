// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

/*
The intuition is there are more confusing number than strobogrammatic number,
and it is fairly staightforward to calculate the total number.
For example, in the extreme case,
N=1e9, total=1953126, confusing=1950627, strobogrammatic=2499

The dfs() function is almost the same as this one. There are two things to notice while performing the dfs:

Use char[] or StringBuilder, instead of generating lots of strings, which is a waste of memory
For numbers to be valid, leading zero is not allowed
Time complexity: O(5^M)
Space complexity: O(M)
*/
public class ConfusingNumber {
    static char flipN[][] = { { '0', '0' }, { '1', '1' }, { '6', '9' }, { '8', '8' }, { '9', '6' } };

	public int confusingNumberII(int N) {
		String num = Integer.toString(N);
		int totalValids = calculateValid(num);
		int size = num.length();
		for (int len = 1; len <= size; len++) {
			// len 1 -> 1 digit number
			// len 2 -> 2 digit number
			char array[] = new char[len];
			totalValids -= backtrack(array, 0, len - 1, num);
		}
		return totalValids;
	}

	// Backtracking function to find all non confusing numbers of len 1,2...N
	private int backtrack(char array[], int left, int right, String num) {

		int res = 0;
		// base case
		if (left > right) {
			String current = new StringBuffer().append(array).toString();
			if (current.length() < num.length() || current.compareTo(num) <= 0) {
				res  = res + 1;
			}
			return res;
		}
		// logic
		for (char[] pair : flipN) {
			// action
			array[left] = pair[0];
			array[right] = pair[1];
			if ((array[0] == '0' && array.length > 1) || (left == right && pair[0] != pair[1])) {
				continue;
			}
			// recurse
			res += backtrack(array, left + 1, right - 1, num);

		}
		return res;
	}

	public int calculateValid(String num) {
		int res = 0;
		if (num.length() == 0) {
			return 1;
		}
		char first = num.charAt(0);
		int validLessThanFirst = validsLessThanFirstDigit(first);
		// First digit is not among valid numbers
		res = validLessThanFirst * (int) (Math.pow(5, num.length() - 1));

		if (first == '0' || first == '1' || first == '6' || first == '8' || first == '9') {
			res += calculateValid(num.substring(1));
		}
		return res;
	}

	private int validsLessThanFirstDigit(char first) {
		int res = 0;
		for (char pair[] : flipN) {
			if (first > pair[0]) {
				res++;
			}
		}
		return res;
	}
	
	public static void main(String args[]){
        ConfusingNumber number = new ConfusingNumber();

        int N = 100;
        System.out.println(number.confusingNumberII(N));
        N = 20;
		System.out.println(number.confusingNumberII(N));
    }
}
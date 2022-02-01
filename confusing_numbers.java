// Time Complexity : O(5^(l)) [ l- number of digits in n as we need only the values that are less than n]
// Space Complexity : Recursive Stack : O(l) no of digits in the n. 

class Solution {

	int count;

	public int confusingNumberII(int n){

		count = 0;
		HashMap<Integer, Integer> map = new HashMap<>();

		// Store the possible digits in the valid number
		map.put(0,0);
		map.put(6,9);
		map.put(8,8);
		map.put(1,1);
		map.put(9,6);

		helper(n, 0, map);

		return count;
	}


	private void helper(int n, long curr, HashMap<Integer, Integer> map){

		// Number not in the range
		if (curr > n){
			return; 
		}

		// Valid number so increase the count
		if (isValid(curr, map)){
			count++;
		}

		// Try all the combinations 
		for (int key : map.keySet()){

			long newNum = curr * 10 + key;

			// For 0 number, no need to do any recursion as it will lead to 0 again.
			if (newNum != 0){
				helper(n, newNum , map);
			}

		}
	}


	// IsValid function

	private boolean isValid(long curr, HashMap<Integer, Integer> map){

		long reversal = 0;
		long temp = curr;

		// Reverse it and map to the reversed digit
		while (temp > 0){

			long digit = temp % 10;
			reversal = reversal * 10 + map.get(digit);
			temp = temp /10;

		}

		// different number 
		return reversal != curr;
	}
}
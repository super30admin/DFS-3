//Time:O(5^(logN)); Space: O(logN)
class Solution {
public int confusingNumberII(int n) {
        //stack space: O(N)
        return helper(String.valueOf(n), 0, "");
    }

    private static final char[] digits = new char[]{'0', '1', '6', '8', '9'};
    private static final char[] rotated_digits = new char[]{'0', '1', '-', '-', '-', '-', '9', '-', '8', '6'};
    private int helper(String str, int begin, String currStr){
        int res = 0;
        if (str.length() == currStr.length()) {
            if (currStr.compareTo(str) > 0) return res;
            if (!isSame(currStr)) res = 1;
            return res;
        }

        for (char c : digits) {//01689
            String tmp = currStr + c;
            if (tmp.compareTo(str.substring(0, begin + 1)) > 0) break;
            res += helper(str, begin + 1, tmp);
        }
        return res;
    }

    private boolean isSame(String str) {
        int left = 0, right = str.length() - 1;
        while (left <= right && str.charAt(left) == '0')
            left++;

        while (left <= right) {
            if (rotated_digits[str.charAt(left++)-'0'] != str.charAt(right--))
                return false;
        }
        return true;
    }
}
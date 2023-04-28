// Approach: DFS
// Time: O(n^log5).logn
// Space: O(logn)

class ConfusingNumber_2 {
    final char[] digits = new char[] {'0', '1', '6', '8', '9'};

    private char other(char c) {
        return switch (c) {
            case '0', '1', '8' -> c;
            case '6' -> '9';
            case '9' -> '6';
            default -> '?';
        };
    }

    private int dfs(String s, boolean smaller, StringBuilder num) {
        if (num.length() == s.length()) {
            int zeros = 0;
            while (zeros < num.length() && num.charAt(zeros) == '0') {
                ++zeros;
            }
            // Remove the leading 0s.
            final String temp = num.substring(zeros);
            for (int i = 0, j = temp.length() - 1; i <= j; ++i, --j) {
                if (temp.charAt(i) != other(temp.charAt(j))) {
                    return 1;
                }
            }
            return 0;
        }
        int ans = 0;
        for (char c : digits) {
            if (!smaller && c > s.charAt(num.length())) {
                break;
            }
            num.append(c);
            ans += dfs(s, smaller || c < s.charAt(num.length() - 1), num);
            num.setLength(num.length() - 1);
        }
        return ans;
    }

    public int confusingNumberII(int n) {
        return dfs(String.valueOf(n), false, new StringBuilder());
    }
}
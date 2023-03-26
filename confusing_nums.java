class Solution {
    public int confusingNumberII(int n) {
        dfs(0, 0, 1, n);
        return count;
    }
    private int count = 0;
    private static final int[] digit = {0, 1, 6, 8, 9};
    private static final int[] rotate = {0, 1, -1, -1, -1, -1, 9, -1, 8, 6};
    private void dfs(long n, long rotated, int base, int limit) {
        if (n > limit) return;
        if (n != rotated) count++;
        for (int d : digit) {
            if (n == 0 && d == 0) continue;
            dfs(n * 10 + d, base * rotate[d] + rotated, base * 10, limit);
        }
    }
}
//TC O(n2)
//SC O(n2)
class Solution {
        public boolean makesquare(int[] matchsticks) {
            if(matchsticks.length < 4) return false;
            int sum = Arrays.stream(matchsticks).sum();
            if (sum % 4 != 0) return false;
            Arrays.sort(matchsticks);
            reverse(matchsticks);

            int side = sum / 4;
            if (matchsticks[0] > side) return false;
            int cnt = 0;
            while (cnt < 4) {
                if (back(matchsticks, 0, 0, side)) {
                    cnt++;
                } else {
                    return false;
                }
            }
            return true;
        }

        public static void reverse(int[] input) {
            int last = input.length - 1;
            int middle = input.length / 2;
            for (int i = 0; i <= middle; i++) {
                int temp = input[i];
                input[i] = input[last - i];
                input[last - i] = temp;
            }
        }

        public boolean back(int matchsticks[], int pos, int sum, int side) {
            if (side == sum) {
                return true;
            } else if (sum > side) {
                return false;
            }

            for (int i = pos; i < matchsticks.length; i++) {
                if (matchsticks[i] < 0) continue;
                int tsum = sum + matchsticks[i];
                matchsticks[i] = -matchsticks[i];
                if (back(matchsticks, i + 1, tsum, side)) {
                    return true;
                }
                matchsticks[i] = -matchsticks[i];
            }
            return false;
        }
    }
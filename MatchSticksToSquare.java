// Time Complexity : O(4^N) ->N is the number of matchsticks
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes


public class MatchSticksToSquare {
        public boolean makesquare(int[] matchsticks) {

            int sum = 0;
            int max = 0;
            for(int i=0; i<matchsticks.length; i++){
                sum += matchsticks[i];
                max = Math.max(max,matchsticks[i]);
            }
            if(sum % 4 != 0) return false;
            int length = sum/4;
            if(max > length) return false;
            return helper(matchsticks, 0, new int[4], length);
        }

        private boolean helper(int[] matchsticks, int idx, int[] side, int length){

            if(idx == matchsticks.length)
            {
                if(side[0] == length && side[1]==length && side[2] == length) return true;
                return false;
            }

            for(int i=0; i<4; i++){
                if(side[i]+matchsticks[idx] <= length)
                {
                    side[i]+= matchsticks[idx];
                    if(helper(matchsticks,idx+1,side,length)) return true;
                    side[i] -= matchsticks[idx];
                }
            }
            return false;
        }
    }
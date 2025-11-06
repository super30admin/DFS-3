// This solution uses setting up matchsticks with 4 edges
class Solution {
    public boolean makesquare(int[] matchsticks) {
        int total = 0, max = 0;
        // Add total size of the matchsticks
        for(int i:matchsticks) {
            total+=i;
            // calculate max sized stick
            max=Math.max(max,i);
        }

        // if any edge crosses max allowed return false
        if(max>total/4) return false;
        // // if sum is not divisble by 4 return false
        if(total%4!=0) return false;

        // Sort the array so that it optimizes the placing and reverse it
        Arrays.sort(matchsticks);
        reverse(matchsticks);

        int[] set = new int[4];

        return checkSquare(matchsticks, set, total/4, 0);
     }

     private void reverse(int[] matchsticks) {
        int i=0, j=matchsticks.length-1;
        while(i<=j) {
            int temp = matchsticks[i];
            matchsticks[i] = matchsticks[j];
            matchsticks[j] = temp;
            i++;
            j--;
        }
     }

     private boolean checkSquare(int[] matchsticks, int[] set, int target, int index) {

        // if index reaches the last length, then return true
        if(index==matchsticks.length) {
            return true;
        }

        // Place the stick in each slot by backtracking
        for(int j=0;j<4;j++) {
            if((set[j]+matchsticks[index])<=target) {
                set[j]+=matchsticks[index];
                if(checkSquare(matchsticks, set, target, index+1)) return true;
                set[j]-=matchsticks[index];
            }
        }
        return false;
     }
}



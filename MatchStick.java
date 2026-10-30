/**
 * Time Complexity:  O(4 ^ n), where n is the size of the array
 * Space Complexity: O(n)
 *
 */
class Solution {
    public boolean makesquare(int[] matchsticks) {

        int sizeOfSquare = 0;
        for(int stick : matchsticks){
            sizeOfSquare += stick;
        }
        if(sizeOfSquare % 4 !=0) return false;
        sizeOfSquare = sizeOfSquare/4;

        Arrays.sort(matchsticks);
        reverse(matchsticks);
        int[] square = new int[4];

        return backTrack(0, matchsticks, square, sizeOfSquare);

    }

    boolean backTrack(int idx, int[] matchsticks, int[] square, int sizeOfSquare) {
        //base case
        if (idx == matchsticks.length) {
            if (square[0] == sizeOfSquare && square[1] == sizeOfSquare &&
                    square[2] == sizeOfSquare && square[3] == sizeOfSquare) {
                return true;
            }
            return false;
        }
        //recursive
        for (int i = 0; i < 4; i++) {
            if (square[i] + matchsticks[idx] <= sizeOfSquare) {
                square[i] += matchsticks[idx];
                if (backTrack(idx + 1, matchsticks, square, sizeOfSquare))
                    return true;
                square[i] -= matchsticks[idx];
            }
        }
        return false;
    }

    void reverse(int[] arr){
        int len = arr.length;
        for(int i=0; i<arr.length/2; i++){
            int temp = arr[i];
            arr[i] = arr[len - i -1];
            arr[len - i -1] = temp;
        }
    }
}
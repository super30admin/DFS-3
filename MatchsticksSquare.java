import java.util.Arrays;

public class MatchsticksSquare {
    public boolean squareMatchsticks(int[] matchsticks){

        int sum =0;
        int n = matchsticks.length;
        int max =0;

        for( int num: matchsticks){
            sum+= num;
            max = Math.max(max, num);
        }
        int lengthOfEachSide = sum/4;
        if(sum %4 !=0 || max > lengthOfEachSide) return false;
        Arrays.sort(matchsticks);
        reverse(matchsticks);
        int [] square = new int[4];
        return helper(matchsticks, 0, lengthOfEachSide, square);

    }

    private boolean helper(int[] matchsticks, int idx, int lengthOfEachSide, int [] square){
        // base case
        if(idx == matchsticks.length) return true;

        for(int i =0; i <4; i++){
            if( square[i] + matchsticks[idx] <= lengthOfEachSide) { // action
                square[i] += matchsticks[idx];
               if( helper(matchsticks,idx+1, lengthOfEachSide, square)) return true; // recurse
                square[i] -= matchsticks[idx]; // backtrack
            }
            if(square[0] == 0) break;
        }
        return false;
    }

    private void reverse ( int [] matchsticks){
        int low =0, high = matchsticks.length -1;
        while( low < high){
            int temp = matchsticks[low];
            matchsticks[low] = matchsticks[high];
            matchsticks[high] = temp;
            low++;
            high--;
        }

    }
     public static void main( String [] args){
        MatchsticksSquare solution = new MatchsticksSquare();
        int [] matchsticks1 = {1,1,2,2,2,};
        boolean  result1 = solution.squareMatchsticks(matchsticks1);
        System.out.println(result1);

         int [] matchsticks2 = {3,3,3,3,4,};
         boolean  result2 = solution.squareMatchsticks(matchsticks2);
         System.out.println(result2);
     }

}

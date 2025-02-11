// Time Complexity : O(5^10) O(log n)
// Space complexity : O(log n) recursive stack space 
import java.util.Map;

public class ConfusedNumber {
    private final Map<Integer,Integer> map = Map.of(0,0,1,1,6,9,8,8,9,6);
    private static final int [] digits = {0,1,6,8,9};
    private  int count =0;
    public int confusedNumber(int  n){
        dfs(0,0, 1, n);
        return count;
    }

    private void dfs(long num, long rotated, long place, int n){
        if( num > n) return;

        if( num != rotated) count++; // if number is not equal to rotated number then count the number

        for( int digit: digits){
            if(num ==0 && digit ==0) continue; // avoid leading zero

            long newNum = num * 10 + digit;
            long newRotatedNum = map.get(digit) * place + rotated ;

            dfs(newNum, newRotatedNum,place*10, n);

        }
    }

    public static void main( String [] args){

        ConfusedNumber solution = new ConfusedNumber();
        int n = 20;

        int result = solution.confusedNumber(n);

        System.out.println(result);
    }
}

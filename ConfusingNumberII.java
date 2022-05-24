import java.util.HashMap;
/*
Time Complexity: O(5^logN), where N is the given number
Space Complexity: O(N)
Run on leetcode: Yes
Any difficulties: No

Approach:
1. Making all sort of confusing numbers and checking them recursively- Attempted once discussed in the class
 */
public class ConfusingNumberII {
    public static  HashMap<Integer, Integer> map = new HashMap<>();
    public static int[] nums = {0, 1, 6, 8, 9};
    public static int confusingNumberII(int N) {
        map.put(0, 0);
        map.put(1, 1);
        map.put(6, 9);
        map.put(8, 8);
        map.put(9, 6);
        int[] count = new int[1];
        recursivelyMakeNumber(0, N, nums, count);
        return count[0];
    }
    private static void recursivelyMakeNumber(long start, int N, int[] nums, int[] count){
        if(start > N){
            return;
        }
        if(start <= N && isConfusedNumber(start, map)){
            count[0]++;
        }
        int i = start == 0 ? 1 : 0;
        for(; i < 5; i++){
            recursivelyMakeNumber(start * 10 + nums[i], N, nums, count);
        }
    }
    private static boolean isConfusedNumber(long s, HashMap<Integer, Integer> map){
        long rem = 0, x = s;
        while(x > 0){
            int i = (int) (x % 10);
            if(i == 2 || i == 3 || i == 4 || i == 5 || i == 7){
                return false;
            }
            long digit = map.get(i);
            rem = rem * 10 + digit;
            x = x / 10;
        }
        return rem != s;
    }
    public static void main(String[] args){
        System.out.println("Confusing Number II: "+ confusingNumberII(20));
    }
}

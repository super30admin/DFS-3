import java.util.HashMap;
import java.util.Map;

public class ConfusingNumbers {

    // TC : O(5 ^ l) 5 choices based on the map of valid numbers. l is the number of digits
    // SC : O(l) l - number of digits while forming numbers up to n
    int count;
    Map<Integer, Integer> map;
    public int confusingNumber(int n){
        if(n == 0) return 0;

        // To hold the map of valid numbers
        map = new HashMap<>();
        map.put(0,0);
        map.put(1,1);
        map.put(6,9);
        map.put(8,8);
        map.put(9,6);

        dfs(n, 0);
        return count;
    }

    private void dfs(int n, int currNumber) {
        // Base
        if(currNumber > n) return;

        if(isConfusingNumberValid(currNumber)) count++;

        for(int key : map.keySet()){
            int newNumber = currNumber * 10 + key;
            if(newNumber != 0){
                dfs(n, newNumber);
            }
        }
    }

    private boolean isConfusingNumberValid(long currNumber) {
        long originalNumber = currNumber;
        long reversedNumber = 0;
        while(currNumber > 0){
            reversedNumber = reversedNumber * 10 + map.get((int)currNumber % 10);
            currNumber = currNumber / 10;
        }

        return originalNumber != reversedNumber;
    }
}

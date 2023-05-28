import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/*
Confusing Numbers
approach: we have to form the numbers till n with the 5 invertible numbers which are 0,1,6,8,9 and for each number formed
check if it is a confusing number
time: O(5^k) since we need all permutations until we reach the number
space: same as time
 */
public class Problem1 {
    HashMap<Integer, Integer> map;
    List<Long> res;
    private List<Long> confusingNumbers(int n) {
        res = new ArrayList<>();
        map = new HashMap<>();
        map.put(1,1);
        map.put(9,6);
        map.put(6,9);
        map.put(8,8);
        map.put(0,0);
        dfs(0L, n);
        return res;
    }

    private void dfs(Long currNumber, int n) {
        //base
        if (currNumber>n) return;

        if (isConfusing(currNumber)) {
            res.add(currNumber);
        }

        //logic
        for (int dig:map.keySet()) {
            long newNumber = currNumber*10+dig;
            if (newNumber==0) continue;
            dfs(newNumber, n);
        }
    }

    private boolean isConfusing(long currNumber) {
        long temp = currNumber;
        int formedNumber = 0;
        while (currNumber>0) {
            int dig = (int) currNumber%10;
            formedNumber = formedNumber*10+map.get(dig);
            currNumber /= 10;
        }

        return formedNumber!=temp;
    }

    public static void main(String []args) {
        Problem1 problem1 = new Problem1();
        problem1.confusingNumbers(100);
    }
}

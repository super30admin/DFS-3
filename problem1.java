import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class problem1 {

    // Time Complexity: O(5^k)
    // Space Complexity:O(n)
    HashMap<Integer, Integer> map;
    public int confusingNumberII(int n) {
        int count=0;
        map =new HashMap<>();
        map.put(0,0);
        map.put(1,1);
        map.put(6,9);
        map.put(8,8);
        map.put(9,6);

        Queue<Long> q= new LinkedList<>();
        q.add(0l);

        while(!q.isEmpty())
        {
            long curr= q.poll();
            if(isConfusing((int)curr))
            {
                count++;
            }
            for(int key: map.keySet())
            {
                long newNum= curr*10+key;
                if(newNum!=0 &&newNum<=n)
                {
                    q.add(newNum);
                }
            }
        }
        return count;
    }
    private boolean isConfusing(int num)
    {
        int temp=num;
        int result=0;
        while(num>0)
        {
            int lastDigit= num%10;
            result = result *10+map.get(lastDigit);
            num/=10;

        }
        return result!=temp;
    }
}

//Time Complexity-n*5^n
//Space-O(n)
class Solution {
    HashMap<Long,Long> map=new HashMap();
    int count=0;
    public int confusingNumberII(int N) {
        map.put(0L,0L);
        map.put(1L,1L);
        map.put(6L,9L);
        map.put(8L,8L);
        map.put(9L,6L);
        backTrack(N,0L);
        return count;        
    }
    void backTrack(int N,long currentNumber)
    {
        if(isConfusing(currentNumber))
        {
            count=count+1;
        }
        for(Long key:map.keySet())
        {
            long next=currentNumber*10+key;
            if(next<=N && next!=0)
            {
                backTrack(N,next);
            }
        }
        
    }
    boolean isConfusing(long currentNumber)
    {
        long src=currentNumber;
        long des=0;
        while(src>0)
        {
            des=des*10+map.get(src%10);
            src=src/10;
        }
        if(currentNumber!=des)
        {
            return true;
        }
        return false;
    }
        
}
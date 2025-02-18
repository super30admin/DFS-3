public class problem2 {
    // Time Complexity: O(4^n)
    // Space Complexity:O(1)
    public boolean makessquare(int[] matchSticks)
    {
        int n= matchSticks.length;
        int sum=0, max=0;
        for (int num:matchSticks)
        {
            sum+=num;
            max= Math.max(sum, max);
        }
        int lengthEachSide=sum/4;

        if (sum%4!=0){return false;}
        if (sum/4<max){return false;}

        int[] sqare= new int[4];
        return helper(matchSticks,0,lengthEachSide,sqare);
    }
    public boolean helper(int[] matchsticks, int index, int lengthEachSide, int[] sqare)
    {
        if(index==matchsticks.length)
        {
            return true;
        }
        for (int i=0;i<4;i++)
        {
            if (sqare[i] + matchsticks[index]<=lengthEachSide)
            {
                sqare[i]+=matchsticks[index];
                if (helper(matchsticks, index+1, lengthEachSide, sqare))
                {
                    return true;
                }
                sqare[i]-=matchsticks[index];
            }
        }
        return false;
    }

}

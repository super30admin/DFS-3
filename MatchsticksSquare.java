// Time Complexity: O(4^N) since 4 side and total N sticks
// Space Complexity: O(N) where the stack space would be for all N matchsticks 
public class MatchsticksSquare {
    public boolean makesquare(int[] matchsticks) {
        if(matchsticks == null || matchsticks.length == 0)
            return false;
        
        // get the total size of the square
        int total = 0;
        for(int n : matchsticks)
        {
            total += n;
        }
        
        // check if this total it is possible to form a square
        if(total % 4 != 0)
            return false;
        
        // get how long each side will be
        int side = total / 4;
        
        // create a bucket to mark each if the matchsticks of each side is found
        int [] sides = new int[4];
        
        // reverse sort so that we fill bigger values first
        // if there is no solution, trying a longer matchstick first will get to negative conclusion earlier.
        Arrays.sort(matchsticks);
        reverseNumbers(matchsticks);
        
        // exhaustive search to places matchsticks
       return backtrack(side, 0, sides, matchsticks);
    }
    
    
    private void reverseNumbers(int [] matchsticks)
    {
        int left = 0 , right = matchsticks.length-1;
        while( left <= right)
        {
            int temp = matchsticks[left];
            matchsticks[left] = matchsticks[right];
            matchsticks[right] = temp;
            left++;
            right--;
        }
    }
    
    // try all number combination to make on side of square
    private boolean backtrack(int side, int index, int[] sides, int [] matchsticks)
    {
        if(sides[0] == side && sides[1] == side && sides[2] == side && sides[3] == side)
            return true;
        
        if(index == matchsticks.length) // placed all matchsticks and could not get side
            return false;
        
        // place a single matchstick everywhere side
       for(int i = 0 ; i < 4 ; i ++)
       {
           if(sides[i] + matchsticks[index] <= side)
           {
               // action
               sides[i] = sides[i] + matchsticks[index];
               // recurse
               if(backtrack(side, index+1, sides, matchsticks))
                   return true;
               // backtrack
               sides[i] = sides[i] - matchsticks[index];
           }
       }
        return false;
    }
}

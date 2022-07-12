// Time Complexity : O(4^n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach


public bool Makesquare(int[] matchsticks) {
    if(matchsticks.Length < 4)
        return false;
    
    int sum = 0;
    
    foreach(int match in matchsticks)
    {
        sum = sum + match;
    }
    
    //if modulo is not 0, it means square cannot be formed
    if(sum % 4 != 0)
        return false;
    
    //get size of each side
    int side = sum /4;
    Array.Sort(matchsticks);
    reverse(matchsticks);
    
    return backtrackingMakesquare(matchsticks, side, 0, new int[4]);
}

private bool backtrackingMakesquare(int[] matchsticks, int side, int index, int[] square)
{
    //base
    if(index == matchsticks.Length){
        if(square[0] == side && square[1] == side && square[2] == side)
            return true;
        
        return false;
    }
    
    
    //logic
    for(int i = 0; i < 4; i++)
    {
        if(matchsticks[index] + square[i] <= side)
        {
            //action
            square[i] = square[i] + matchsticks[index];
            //recurse
            if(backtrackingMakesquare(matchsticks, side, index + 1, square))
                return true;            
            //backtrack
            square[i] = square[i] - matchsticks[index];
        }
        
    }
    
    return false;
}

private void reverse(int[] matchsticks){
    int left = 0, right = matchsticks.Length - 1;
    while(left <= right)
    {
        swap(matchsticks, left, right);
        left++;
        right--;
    }
}

private void swap(int[] matchsticks, int left, int right)
{
    int temp = matchsticks[left];
    matchsticks[left] = matchsticks[right];
    matchsticks[right] = temp;
}
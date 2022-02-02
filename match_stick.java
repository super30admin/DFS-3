// Time complexity : exponential : 4^n (Four choices for each matchstick)
// Space Complexity : O(n) - Recursive Stack

class Solution {
    public boolean makesquare(int[] matchsticks) {
        
        // Square : Each side will be sum of all matchsticks/4.
        int sum = 0;
        
        // Calculate the sum
        for (int i = 0 ; i < matchsticks.length; i++){
            
            sum += matchsticks[i];
        }
        
        // Cannot be a square
        if (sum % 4 != 0){
            return false;
        }
        
        // calculate the side from sum
        int side = sum/4;
        
        // 4 sides each should have side 
        int[] sides = new int[4];
        
        
        return helper(side, matchsticks, sides, 0);
    }
    
    
    public boolean helper(int side, int[] matchsticks, int[] sides, int index){
        
        // all the four elements should be the side
        if (sides[0] == side && sides[1] == side && sides[2] == side && sides[3] == side){
            // we found the 4 subsets with side as length
            return true;
        }
        
        
        if (index == matchsticks.length){
            
            return false;
        }
        // Subset sum : Compute the sides array 
        
        // Take one element from matchstick and try to add it into sides array
        
        for ( int i = 0; i < sides.length; i++){
            
             if (matchsticks[index] + sides[i] <= side){
                
                 // add to the sides[i]
                 sides[i] += matchsticks[index];
                 
                 // Matchstick can be used only once , so index must be updated as its next
                 if (helper(side, matchsticks, sides, index + 1)){
                     return true;
                 }
                 
                 // back track (undo the addition for the new child)
                 sides[i] -= matchsticks[index];
             }
        }
       
        
        return false;
    }
}
# Time complexity : O(4^n)
# Space complexity : O(N)
# Leetcode : Solved and submitted

class Solution:
    def makesquare(self, matchsticks: List[int]) -> bool:
        # make an array of size 4
        square = [0]*4
        sum_val = 0
        
        # find the sum of all the numbers present in the array
        for i in range(len(matchsticks)):
            sum_val += matchsticks[i]
            
        # if the sum is not divisble by 4, then return False
        if sum_val %4 != 0:
            return False
          
        # sort the array in descending order
        matchsticks.sort(reverse = True)
        
        # call the backtrack function with side as total sum divided by 4
        return self.backtrack(matchsticks, square, 0, sum_val//4)
    
    def backtrack(self, matchsticks, square, idx, side):
      
        # if 3 sides have the same value then return True
        if square[0] == side and square[1] == side and square[2] == side:
            return True
        
        # if we have reached to the end of the array then return False
        if idx == len(matchsticks):
            return False
          
        # for loop based recursion on square array to see if we can add value to any side to make it a square
        for i in range(4):
            if square[i] + matchsticks[idx] <= side:
                # action
                # add value to the side of the square
                square[i] += matchsticks[idx]
                
                # recurse
                # check if the recursie of this will work, then return True
                if self.backtrack(matchsticks, square, idx+1, side):
                    return True
                
                # backtrack
                # remove the added value from the side of the square
                square[i] -= matchsticks[idx]
        
        # return False as none of the combinations worked
        return False

# Time complexity : O(2^n)
# Space complexity : O(2^n)
# Leetcode : TLE

class Solution:
    def makesquare(self, matchsticks: List[int]) -> bool:
        # make an array of size 4 having size 0
        square = [0]*4
        
        # find the sum of the array and see if it's divisible by 4
        sum_val = 0
        for i in range(len(matchsticks)):
            sum_val += matchsticks[i]
            
        # if we don't get a whole number, then square is not possible
        if sum_val %4 != 0:
            return False
        
        # call the dfs function with side as sum // 4
        return self.backtrack(matchsticks, square, 0, sum_val//4)
    
    def backtrack(self, matchsticks, square, idx, side):
        # if 3 sides have same value, then 4th will also be same and hence return True
        if square[0] == side and square[1] == side and square[2] == side:
            return True
        
        # go over each square value and check if it adds up to a square
        for i in range(4):
            if square[i] + matchsticks[idx] <= side:
                # action
                # add the current value to square at ith index
                square[i] += matchsticks[idx]
                
                # recurse
                # if the backtrack is true then return True
                if self.backtrack(matchsticks, square, idx+1, side):
                    return True
                
                # backtrack the step by removing the ith value from the square
                square[i] -= matchsticks[idx]
        
        # return False otherwise
        return False

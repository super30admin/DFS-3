class Solution(object):
    def makesquare(self, matchsticks):
        if matchsticks == None or len(matchsticks) == 0:
            return False
        summation = 0
        for i in range(len(matchsticks)):
            summation += matchsticks[i]
        if summation % 4 != 0 or len(matchsticks) < 4:
            return False
        square = [0] * 4
        matchsticks.sort()
        matchsticks = matchsticks[::-1]
        if matchsticks[0] > summation//4:
            return False
        return self.backtrack(matchsticks, square, 0, summation//4)
    
        
    def backtrack(self, matchsticks, square, index, side):
        if index == len(matchsticks):
            if square[0] == side and square[1] == side and square[2] == side:
                return True
        for i in range(len(square)):
            if square[i] + matchsticks[index] <= side:
                # action
                square[i] += matchsticks[index]
                #recurse
                if self.backtrack(matchsticks, square, index+1, side):
                    return True
                # backtrack
                square[i] -= matchsticks[index]
                
        return False
            
            
        
            
# Time Complexity: O(4^n)
# Space Complexity: O(n)
            
        
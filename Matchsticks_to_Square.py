class Solution:
    def makesquare(self, matchsticks: List[int]) -> bool:
        
        if not matchsticks:
            return False
        totalsum = sum(matchsticks)
        
        if (totalsum % 4) != 0:
            return False
        
        side = totalsum // 4 
        square = [0] * 4
        matchsticks = sorted(matchsticks, reverse=True)
        
        return self.backtrack(matchsticks,0,side,square)
    
    def backtrack(self,matchsticks, index, side,square):
        
        #base
        if index == len(matchsticks):
            if square[0] == side and square[1] == side and square[2] == side:
                return True
            return False
                
        #logic
        
        for i in range(len(square)):
            if square[i] + matchsticks[index] <= side:
                square[i] = square[i] + matchsticks[index]
                if self.backtrack(matchsticks, index+1, side,square):
                    return True
                square[i] = square[i] - matchsticks[index]
                
        return False
                
            
            

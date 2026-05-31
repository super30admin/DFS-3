# problem 2 

class Solution:
    def makesquare(self, matchsticks: List[int]) -> bool:
        total_sum = 0 
        maxLength = 0
        for stick in matchsticks:
            total_sum += stick 
            maxLength = max(maxLength,stick)

        length_of_side = total_sum // 4 

        if total_sum % 4 !=0:
            return False 
        if maxLength > length_of_side:
            return False
        matchsticks.sort()
        matchsticks.reverse()
        square = [0]*4

        def helper(idx):
            if idx == len(matchsticks):
                return True 
            for i in range(4):
                if square[i] + matchsticks[idx] <= length_of_side:
                    square[i] += matchsticks[idx]
                    if helper(idx+1):
                        return True 
                    square[i] -= matchsticks[idx]
            return False  
        
        return helper(0)
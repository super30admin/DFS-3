# Time Complexity : O(4^N)
# Space Complexity : O(N)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Explanation:
# Sum must be divisible by 4.
# Use backtracking to assign each matchstick to one of four sides.
# Ensure no side exceeds target length.

class Solution:
    def makesquare(self, matchsticks: List[int]) -> bool:
        
        total = sum(matchsticks)
        
        if total % 4 != 0:
            return False
        
        target = total // 4
        
        sides = [0]*4
        
        matchsticks.sort(reverse=True)
        
        def dfs(i):
            
            if i == len(matchsticks):
                return True
            
            for j in range(4):
                
                if sides[j] + matchsticks[i] <= target:
                    
                    sides[j] += matchsticks[i]
                    
                    if dfs(i+1):
                        return True
                    
                    sides[j] -= matchsticks[i]
            
            return False
        
        return dfs(0)
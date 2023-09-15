# Time Complexity : O(nlogn)
# Space Complexity :O(n)
# Passed on Leetcode: yes

class Solution:
    def makesquare(self, matchsticks: List[int]) -> bool:
        total_length = sum(matchsticks)
        
        if total_length % 4 != 0:
            return False
        
        matchsticks.sort(reverse=True)
        
        sides = [0] * 4
        
        def dfs(index):
            if index == len(matchsticks):
                return all(side == sides[0] for side in sides)
            
            for i in range(4):
                if sides[i] + matchsticks[index] <= total_length // 4:
                    sides[i] += matchsticks[index]
                    if dfs(index + 1):
                        return True
                    sides[i] -= matchsticks[index]
            
            return False
        
        return dfs(0)

        
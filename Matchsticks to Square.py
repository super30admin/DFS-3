#Time Complexity : O(4^n) Although sorting adds an extra O(n log n) time, it does not affect the overall complexity of O(4ⁿ), as the exponential DFS dominates. However, it helps improve practical runtime efficiency by reducing DFS calls. Similar to sorting, the O(n) sum operation is negligible compared to the exponential time complexity of the DFS.
#Space Complexity : O(N) (Recursive Stack) + O(N) for sides list --> O(2*N) --> O(N)
class Solution:
    def makesquare(self, matchsticks: List[int]) -> bool:
        length = sum(matchsticks) // 4
        if(sum(matchsticks)%4!=0):
            return False
        n = len(matchsticks)
        matchsticks.sort(reverse=True)
        sides = [0] * 4
        def dfs(i):
            if(i==n):
                return True
            for j in range(0,4):
                if(sides[j] + matchsticks[i] <= length):
                    sides[j]+=matchsticks[i]
                    if(dfs(i+1)==True):
                        return True
                    sides[j]-=matchsticks[i]
            return False
        return dfs(0)


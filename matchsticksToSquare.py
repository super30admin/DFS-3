class Solution:
    # dfs approach
    # TC : O(4**n)
    # SC : O(h) -- recursive stack height
    def makesquare(self, matchsticks: List[int]) -> bool:
        if sum(matchsticks) % 4 != 0:
            return False
        matchsticks.sort(reverse = True)
        sides = [0]*4
        sidelen = sum(matchsticks)//4
        def backtrack(i):
            # base
            if i==len(matchsticks):
                return True
            # logic
            for j in range(4):
                if sides[j]+matchsticks[i] <= sidelen:
                    # action
                    sides[j]+=matchsticks[i]
                    # recurse call
                    if backtrack(i+1):
                        return True
                    # undo
                    sides[j]-=matchsticks[i]
            return False
        return backtrack(0)
        
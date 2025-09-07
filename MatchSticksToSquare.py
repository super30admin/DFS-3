from typing import List
class Solution:
    def makesquare(self, matchsticks: List[int]) -> bool:
        maxlen = float("-inf")
        totallen = 0
        for i in range(len(matchsticks)):
            maxlen = max(maxlen, matchsticks[i])
            totallen+=matchsticks[i]
        if totallen%4!=0: return False
        sidelen = totallen//4
        if maxlen>sidelen: return False
        # try all the combinations for all four sides 
        square = [0]*4
        matchsticks.sort()
        matchsticks.reverse()
        return self.helper(0,square,matchsticks,sidelen)

    def helper(self, idx, square, matchsticks, sidelen):  
        # base
        if idx == len(matchsticks): return True
        # logic loop all the sides and try to include matchsticks
        for i in range(4):
            if square[i]+matchsticks[idx]<=sidelen:
                # action
                square[i]+=matchsticks[idx]
                # recurse
                if self.helper(idx+1,square,matchsticks, sidelen):
                    return True
                # backtrack
                square[i]-=matchsticks[idx]
        return False





        
        
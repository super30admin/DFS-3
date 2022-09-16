""""// Time Complexity : O(4^n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :
"""

class Solution:
    def makesquare(self, matchsticks: List[int]) -> bool:
        if matchsticks == None or len(matchsticks) == 0:
            return False
        totalsum = 0
        for i in range(len(matchsticks)):
            totalsum += matchsticks[i]

        if totalsum % 4 != 0 or len(matchsticks) < 4:
            return False

        matchsticks.sort()
        matchsticks = matchsticks[::-1]
        if matchsticks[0] > totalsum // 4:
            return False
        return self.backtrack(matchsticks, [0] * 4, 0, totalsum // 4)

    def backtrack(self, matchsticks, square, i, side):
        if i == len(matchsticks):
            if square[0] == side and square[1] == side and square[2] == side:
                return True
        for j in range(len(square)):
            if square[j] + matchsticks[i] <= side:
                # action
                square[j] += matchsticks[i]
                # recurse
                if self.backtrack(matchsticks, square, i + 1, side):
                    return True
                # backtrack
                square[j] -= matchsticks[i]

        return False

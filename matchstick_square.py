# Time complexity : O(4^n)
# Space complexity : O(n)

class Solution:
    def makesquare(self, matchsticks: List[int]) -> bool:
        square = [0 for i in range(4)]

        def backtrack(side, idx) -> bool:
            if idx == len(matchsticks):
                print(square, side)
                if square[0] == side and square[1] == side and square[2] == side and square[3] == side:
                    return True
                else:
                    return False
            for i in range(4):
                if matchsticks[idx] + square[i] <= side:
                    square[i] += matchsticks[idx]
                    if backtrack(side, idx+1):
                        return True
                    square[i] -= matchsticks[idx]

        matchsticks.sort(key=lambda x: -x)
        x = sum(matchsticks)
        if x % 4 != 0:
            return False
        side = x//4
        return backtrack(side, 0)

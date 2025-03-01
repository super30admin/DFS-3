"""
TC: O(4^N)
SP: O(N)
use backtracking to find if array can be partitioned to equal length sides. same as Partition to K Equal Sum Subsets
"""
class Solution:
    def makesquare(self, matchsticks: List[int]) -> bool:
        sum_ = sum(matchsticks)
        if sum_ % 4 != 0:
            return False
        side_length = sum_ // 4
        placement = [0] * 4
        n = len(matchsticks)
        matchsticks.sort(reverse=True)

        def backtrack(i):
            if i == n:
                return True
            for j in range(4):
                if placement[j] + matchsticks[i] <= side_length:
                    placement[j] += matchsticks[i]
                    if backtrack(i + 1):
                        return True
                    placement[j] -= matchsticks[i]
            return False

        return backtrack(0)

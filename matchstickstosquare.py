# Time Complexity: O(4^n)
# Space Complexity: O(n)

class Solution:
    def makesquare(self, matchsticks: List[int]) -> bool:

        total_val = 0
        max_length = 0

        for i in matchsticks:
            total_val += i
            max_length = max(max_length, i)

        each_side = total_val // 4

        if total_val % 4 != 0:
            return False

        if max_length > each_side:
            return False

        matchsticks.sort()
        matchsticks.reverse()

        square = [0] * 4

        def helper(idx):
            if idx == len(matchsticks):
                return True

            for i in range(4):
                if square[i] + matchsticks[idx] <= each_side:
                    square[i] += matchsticks[idx]

                    if helper(idx + 1):
                        return True

                    square[i] -= matchsticks[idx]

            return False

        return helper(0)



class Solution:
    square = 0

    # side = 0
    def makesquare(self, matchsticks: List[int]) -> bool:
        s = 0
        for i in matchsticks:
            s += i

        if s % 4 != 0:
            return False

        side = s // 4
        self.square = [0 for i in range(4)]
        matchsticks.sort()
        self.reverse(matchsticks)
        return self.backtrack(matchsticks, side, 0)

    def backtrack(self, matchsticks, side, i):
        if i == len(matchsticks):
            return self.square[0] == self.square[1] == self.square[2] == side

        for j in range(4):
            if self.square[j] + matchsticks[i] <= side:
                # action
                self.square[j] += matchsticks[i]
                # recurse
                if self.backtrack(matchsticks, side, i + 1):
                    return True
                # backtrack
                self.square[j] -= matchsticks[i]
        return False

    def reverse(self, nums):
        left = 0
        right = len(nums) - 1

        while left <= right:
            temp = nums[left]
            nums[left] = nums[right]
            nums[right] = temp

            left += 1
            right -= 1

        return nums

# Backtracking
# Time Complexity: O(np4) we have 4 side and for each side we have n combinations to explore ie. 4 permutation for each n
# Space Complexity: O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
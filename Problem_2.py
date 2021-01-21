"""
Time Complexity : O(4^n) 
Space Complexity : O(n) hasmap and queue
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

We would first check if sum of the array is divisible by 4 or not. If not, we cannot make a square. If its possible, we would
find the possible side and try to group those values to make that side. We would perform backtracking for that purpose as below.
"""


class Solution:
    def makesquare(self, nums: List[int]) -> bool:
        if not nums or len(nums) < 4 or sum(nums) % 4 != 0 or max(nums) > sum(nums) // 4:
            return False

        side = sum(nums)//4
        square = [0 for i in range(4)]
        nums.sort(reverse=True)
        return self.backtrack(square, nums, 0, side)

    def backtrack(self, square, nums, index, side):
        if index == len(nums):
            return square[0] == square[1] == square[2] == side

        for i in range(4):
            if (square[i] + nums[index]) <= side:
                square[i] += nums[index]
                if self.backtrack(square, nums, index+1, side):
                    return True
                square[i] -= nums[index]
        return False

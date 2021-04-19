'''
Time Complexity: O(4^n)
Space Complexity: O(n)
Did this code successfully run on Leetcode : Yes
Explanation: Use Backtracking to find all combinations of a particular side such that the sum of each side should the totalSUm/2
Hence find all combinations which gives each side equal to the total sum/4
'''
class Solution:
    def backTrack(self, nums, sides, cursor, target):

        if cursor == len(nums):
            if sides[0] == target and sides[1] == target and sides[2] == target and sides[3] == target:
                return True
            else:
                return False

        for i in range(0, 4):
            if (sides[i] + nums[cursor]) > target:
                continue

            sides[i] += nums[cursor]
            if self.backTrack(nums, sides, cursor + 1, target):
                return True

            # remove value
            sides[i] -= nums[cursor]

        return False

    def makesquare(self, nums: List[int]) -> bool:

        nums = sorted(nums, reverse=True)
        if nums == None or len(nums) < 4:
            return False

        sum1 = sum(nums)

        if sum1 % 4 != 0:
            return False

        return self.backTrack(nums, [0 for i in range(4)], 0, sum1 // 4)
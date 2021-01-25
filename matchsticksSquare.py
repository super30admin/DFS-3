#Time Complexity : Exponential
#Space Complexity : O(n) 
#Did this code successfully run on Leetcode : Yes

class Solution:
    def backtrack(self, nums, square, index):
        if index == len(nums):
            for i in range(4):
                if square[i] != self.sides:
                    return False
            return True

        for i in range(4):
            if (square[i] + nums[index]) <= self.sides:
                square[i] += nums[index] #action
                if self.backtrack(nums, square, index+1): #recurs
                    return True
                square[i] -= nums[index] #recurse
        return False

    def makesquare(self, nums: List[int]) -> bool:
        if not nums:
            return False

        total = sum(nums)
        if total%4 != 0:
            return False
        nums.sort(reverse=True)
        self.sides = total//4
        return self.backtrack(nums, [0 for _ in range(4)], 0)

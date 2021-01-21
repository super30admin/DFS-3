'''
Time Complexity : O(4^n) 
Space Complexity : O(n)
'''

class Solution:
    def makesquare(self, nums: List[int]) -> bool:
        if len(nums) == 0:
            return False
        
        count = sum(nums)
        
        if count%4 != 0 or len(nums)<4 or sum(nums) % 4 != 0 or max(nums) > sum(nums):
            return False
        
        side = count//4
        square = [0 for i in range(4)]
        nums.sort(reverse=True)
        return self.backtrack(nums, 0, square, side)
    
    def backtrack(self, nums, index, square, side):
        if index == len(nums):
            return square[0] == square[1] == square[2] == side
        
        for i in range(len(square)):
            if nums[index] + square[i] <= side:
                square[i] += nums[index]
                if self.backtrack(nums, index+1, square, side):
                    return True
                square[i] -= nums[index]
                
        return False
        
        
        
        
        
        
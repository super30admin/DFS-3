# TIME COMPLEXITY: Exponential
# SPACE COMPLEXITY: O(N)
class Solution(object):
    def makesquare(self, nums):
        """
        :type nums: List[int]
        :rtype: bool
        """
        if not nums:
            return False
        nums.sort(reverse=True)
        _sum = sum(nums)
        if _sum % 4 != 0:
            return False
        
        sq_side = sum(nums)//4
        
        def dfs(square, index, sq_side):
            # Base Case
            if index == len(nums):
                if square[0] == sq_side and square[1] == sq_side and square[2] == sq_side:
                    return True
            
            # Logic
            for i in range(len(square)):
                if nums[index] + square[i] <= sq_side:
                    # Action
                    square[i] += nums[index] 
                    # Recurse
                    if (dfs(square, index + 1, sq_side)): return True
                    # Backtrack
                    square[i] -= nums[index]
            return False
        
        return dfs([0,0,0,0], 0, sq_side)
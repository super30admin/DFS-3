"""
Time Complexity : O()
Space Complexity : O()
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

Explaination
we have to divide the array in such a way that the four parts have equal sum
1. if sum is not divisible by 4 then we return False
2. create res array with length 4
3. use backtrack to fill this res array 
4. backtrack will try to add numbers in each house if its lesser than n/4
5. if we 4 locations are filled and each location has sum equal to n/4 we append that to the res



"""

class Solution:
    def makesquare(self, nums: List[int]) -> bool:
        if len(nums) == 0: return False
        h = sum(nums)
        if h%4 != 0:
            return False
        sqr = [0]*4
        target = h/4
        nums.sort(reverse=True)
        return self.backtrack(sqr, nums, 0, target)
    
    def backtrack(self, sqr, nums, index, target):
        #base
        if index == len(nums):
            if sqr[0] == target and sqr[1] == target and sqr[1] == target:
                return True
            return False
        
        #logic
        for i in range(4):
            if sqr[i] + nums[index] <= target:
                sqr[i] += nums[index]
                if(self.backtrack(sqr, nums, index+1, target)): return True
                #backtrack
                sqr[i] -= nums[index]
        return False
        
        

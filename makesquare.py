"""
TC O(exponential)
SC o(1)

Backtracking solution

"""


class Solution:
    def makesquare(self, nums: List[int]) -> bool:
        
        self.nums=nums
        
        if not self.nums:
            return False
        
        sum1 = sum(self.nums) #add all the nums
        if sum1 % 4 != 0: #if divisible by 4 , then will be a square
            return False
        self.nums.sort(reverse=True) 
        sq_side = sum1//4
        return self.dfs([0,0,0,0], 0, sq_side)#side_list ,idex,sq_side
    
    
    def dfs(self,sq,idx,sq_side):
        #base
        if idx == len(self.nums):
            if sq[0] == sq_side and sq[1] == sq_side and sq[2] == sq_side:#if 3 side is qual to sq_side, 4th side will be also equal.
                    return True
            
        #logic
        for i in range(len(sq)):
            if self.nums[idx] + sq[i] <=sq_side:
                sq[i] += self.nums[idx] #action
                if (self.dfs(sq, idx + 1, sq_side)): #recurse
                    return True
                sq[i] -= self.nums[idx]#backtrack
        return False
        
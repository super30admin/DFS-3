#As tught in class using backtrcking to solve this problem
#Space Complexity: O(n)
class Solution:
    def makesquare(self, nums: List[int]) -> bool:
        if nums is None or len(nums)==0:
            return False
        sum = 0
        for num in nums:
            sum+= num
        if sum % 4 !=0:
            return False
        side = sum/4
        return self.backtrack(nums,[0,0,0,0],0,side)
    
    def backtrack(self,nums,square,index,side):
        if index == len(nums):
            if square[0] == side and square[1] == side:
                return True
            return False
        for i in range(0,len(square)):
            if (square[i]+nums[index]<side):
                square[i] = square[i] + nums[index]
                if self.backtrack(nums,square,index+1, side):
                    return True
                square[i] = square[i] - nums[index]    
        return False
        
    
            
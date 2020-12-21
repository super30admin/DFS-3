class Solution:
    def makesquare(self, nums: List[int]) -> bool:
        def dfs(nums, pos, target):
            if pos == len(nums): 
                return True
            for i in range(4):
                if target[i] >= nums[pos]:
                    target[i] -= nums[pos]
                    if dfs(nums, pos+1, target): 
                        return True
                    target[i] += nums[pos]
            return False
        
        
        if len(nums) < 4 : 
            return False
        
        numSum = sum(nums)
        nums.sort(reverse=True)
        if numSum % 4 != 0: 
            return False
        
        target = [numSum/4] * 4;
        return dfs(nums,0, target)
        
        
        # o(4^N) tc
        # sc  o(n)

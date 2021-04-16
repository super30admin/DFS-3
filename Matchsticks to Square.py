class Solution:
    def makesquare(self, nums: List[int]) -> bool:
        #Approach: Backtracking
        #Time Complexity: O(4^n)
        #Space Complexity: O(n)
        #where, n is the length of nums // total number of matchsticks
        
        self.total = sum(nums)
        self.sides = [0, 0, 0, 0]
        self.result = False
        
        if not nums or self.total % 4 != 0:
            return self.result
        self.side = self.total // 4
        
        nums.sort(reverse=True)
        self.dfs(nums, 0)
        
        return self.result
    
    def dfs(self, nums, idx):
        #base
        if self.result:
            return
        
        if idx == len(nums):
            if self.sides[0] == self.sides[1] == self.sides[2] == self.sides[3]:
                self.result = True
            return
        
        #logic
        for side in range(4):
            if self.sides[side] + nums[idx] <= self.side:
                self.sides[side] += nums[idx]       #action
                self.dfs(nums, idx + 1)             #recursion
                self.sides[side] -= nums[idx]       #backtracking
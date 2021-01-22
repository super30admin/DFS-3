class Solution:
    def makesquare(self, nums: List[int]) -> bool:
        if not nums or len(nums) < 4 or sum(nums) % 4 != 0 or max(nums) > sum(nums) // 4:
            return False

        side = sum(nums)//4
        square = [0 for i in range(4)]
        nums.sort(reverse = True)
        return self.backtrack(nums, square,  0, side)
    
    def backtrack(self, nums, square, index, side):
        #so we have 4 spots to fill up, each number at index can go to one of these 4 spots, how do we decide if they can? check if they are less than the side value permitted
        
        #base condition
        if index == len(nums):
            return all(square[i]==side for i in range(len(square)))
        else:
            #change the spots among the 4 available
            for i in range(4):
                if square[i]+nums[index]<=side: #current index + 4 different square spots
                    # we backtrack
                    square[i]+=nums[index]
                    if self.backtrack(nums, square, index+1, side):
                        return True
                    square[i]-=nums[index]
            
        return False
                    
Time: O(4^N)
Space: O(N )

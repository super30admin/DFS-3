class Solution:
    def makesquare(self, nums: List[int]) -> bool:
        ### TIme comp - exponential
        ## space- O(n)
        ### Desc- find the sum if its odd then return false, if its even then use backtracking to still the array with size 4 where each value should be equal to the size of a squre, if its not then backtrack (action->recurse->backtrack)
        def backtrack(nums,arr,ind,side):
            if ind==len(nums):
                if arr[0]==side and arr[1]==side and arr[2]==side:
                    return True
            for i in range(len(arr)):
                if arr[i]+nums[ind]<=side:
                    arr[i]=arr[i]+nums[ind] #actions
                    if backtrack(nums,arr,ind+1,side):
                        return True
                    arr[i]=arr[i]-nums[ind]
            return False
        if len(nums)==0:
            return False
        if sum(nums)%4!=0:
            return False
        ## desc sorting decrease the time complecity
        side=sum(nums)/4
        nums.sort(reverse=True)
        return backtrack(nums,[0]*4,0,side)
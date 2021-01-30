# Time:- O(2^n)
# Space:- O(2^n)
# Approach:- Typical Backtracking to find a side of a fixed length using the sides given. The length of each side is sum of the sides/4. If we can backtrack and form 4 sides of this length then we can make a square. To avoid repeated computations memoize

class Solution:
    def makesquare(self, nums: List[int]) -> bool:
        visited=[False]*len(nums)
        nums.sort(reverse=True)
        if sum(nums)%4>0:
            return False
        # eachside will be sum(lengths)/4
        eachside=sum(nums)//4
        @lru_cache(maxsize=None)
        # we have to make 4 side of length eachside
        def ms(side,eachside):
            # we have formed one side increase the side count
            if eachside==0:
                side+=1
            # we have formed all the side of equal length we are done
            if side==4 and eachside==0:
                return True
            # we have formed one side of equal length reset eachside count
            if eachside==0:
                eachside=sum(nums)//4
            # we have formed a side greater than what we want return 
            if eachside<0:
                return False
            for i in range(len(nums)):
                # visited array to keep track of which matchstick we have used till now
                if not visited[i]:
                    # action
                    visited[i]=True
                    eachside-=nums[i]
                    # recurse
                    if ms(side,eachside):
                        return True
                    # backtrack
                    eachside+=nums[i]
                    visited[i]=False
        return ms(0,eachside)
        
                    
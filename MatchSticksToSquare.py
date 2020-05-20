'''
Solution:
1.  First, check whether the total sum is divisible by 4, sort the array (reverse order).
2.  For each sub-group, checking the base condition to be satisified, perform backtracking if the potential sum is
    less than the target sum for that sub-group.
3.  If the conditions for all 4 sub-groups aren't satisfied => return False, else return True

Time Complexity:    O(N.logN + 4 ^ N) ~ O(4 ^ N) -- exponential
Space Complexity:   O(H) for recursive stack space + O(1) -- maintain array of size 4 with the sum in each index getting updated by backtracking
                    ~ O(H) where H is the Height of the Recursive Tree
                    
--- Passed all testcases successfully on leetcode.
'''


class Solution:

    def __checkHelper(self, nums: List[int], sides: List[int], cursor: int, target: int) -> bool:

        #   base case check and return true if satisfied
        if (cursor == len(nums)):
            baseCaseBool = True
            for i in range(3):
                baseCaseBool = baseCaseBool and (sides[i] == target)
            return baseCaseBool

        #   for each group
        for i in range(4):

            #   if the sum exceeds => continue
            if (sides[i] + nums[cursor] > target):
                continue

            #   otherwise, add the current number to the sum and perform backtracking
            sides[i] += nums[cursor]
            if (self.__checkHelper(nums, sides, cursor + 1, target)):
                return True
            sides[i] -= nums[cursor]

        #   return False as if reached here => condition not satisfied
        return False

    def makesquare(self, nums: List[int]) -> bool:

        #   edge case check
        if (nums == None or len(nums) < 4):
            return False

        #   sort the array and calculate the target for each group out of 4
        nums.sort(reverse=True)

        totalSum = sum(nums)
        if (totalSum % 4 != 0):
            return False

        target = totalSum / 4

        sides = [0 for i in range(4)]

        #   call backtracking
        return self.__checkHelper(nums, sides, 0, target)
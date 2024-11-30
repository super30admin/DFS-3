class Solution:
    '''
    Accepted on leetcode(473)
    time - O(4^N)
    space - O(1)
'''

    def makesquare(self, nums) -> bool:
        # edge case
        if len(nums) < 4:
            return False

        # calculate perimeter of square
        total = sum(nums)

        # if not divisible by 4, cannot form a square
        if total % 4 != 0:
            return False

        # descending order sort.
        nums.sort(reverse=True)

        # call backtracking function
        return self.backtracking(nums, 0, [0 for _ in range(4)], total / 4)

    def backtracking(self, nums, index, square, target):
        # base case
        if index >= len(nums):  # index out of bounds of given nums array
            for i in range(4):
                # After traversing all elements, if all the values in the square array are not                 equal to target return false.
                if square[i] != target:
                    return False
            return True

        # recursive case
        for i in range(4):
            if (square[i] + nums[index] > target):
                continue  # continue to next iteration

            # add element to square array and test and backtrack and check again.
            square[i] += nums[index]
            if self.backtracking(nums, index + 1, square, target):  # if any one case returns true
                return True
            square[i] -= nums[index]

        return False
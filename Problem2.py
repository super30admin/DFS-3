# This approach uses backtracking to solve the problem of forming a square with matchsticks.
# It checks if the matchsticks can be divided into four equal-length sides.
# Time Complexity: O(4^n) in the worst case, where n is the number of matchsticks.
# Space Complexity: O(1) for the square array, but O(n) for the recursion stack in the worst case.

class Solution:
    def makesquare(self, matchsticks: List[int]) -> bool:
        if not matchsticks or len(matchsticks) < 4:
            return False
        total = 0
        for i in range(len(matchsticks)):
            total = total + matchsticks[i]
        if total % 4 == 0:
            req_sum = total // 4
        else:
            return False
        matchsticks.sort(reverse = True)
        return self.backtrack(matchsticks, 0, [0] * 4, req_sum)
    
    def backtrack(self, matchsticks, index, square, side):
        if index == len(matchsticks):
            return True

        for i in range(4):
            if square[i] + matchsticks[index] <= side:
                square[i] = square[i] + matchsticks[index]

                if self.backtrack(matchsticks, index + 1, square, side):
                    return True
                square[i] = square[i] - matchsticks[index]
        return False

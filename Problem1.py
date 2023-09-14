class Solution:
    def makesquare(self, matchsticks: List[int]) -> bool:
        '''
        Time complexity- O(4^N), N --> number of matchsticks. In the worst case, we explore all possible combinations.

        Space Complexity- O(N), as it uses recursion with a depth of at most N and some additional space for the square array and function calls. 
        '''
        # Calculate the total sum of matchstick lengths
        total_sum = sum(matchsticks)

        # Check if it's possible to divide the matchsticks into 4 equal sides
        if total_sum % 4 != 0:
            return False

        # Calculate the length of each side of the square
        side_length = total_sum // 4

        # Create an array to represent the four sides of the square
        square = [0] * 4

        def backtrack(matchsticks, square, idx, side):
            # If we've successfully placed all matchsticks into the four sides, return True
            if idx == len(matchsticks):
                return all(side == side_length for side in square)

            # Try placing the current matchstick in each side
            for i in range(4):
                if square[i] + matchsticks[idx] <= side:
                    square[i] += matchsticks[idx]
                    if backtrack(matchsticks, square, idx + 1, side):
                        return True
                    square[i] -= matchsticks[idx]
            return False

        # Start the backtracking process
        return backtrack(matchsticks, square, 0, side_length)

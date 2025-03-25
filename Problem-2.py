'''
    Time Complexity: O(4^n)
    Space Complexity: O(n)
'''
class Solution:
    def makesquare(self, matchsticks: List[int]) -> bool:
        n = len(matchsticks)

        if n < 4:
            return False

        sum = 0
        maximum = -1
        for match in matchsticks:
            sum += match
            maximum = max(maximum, match)

        if sum % 4:
            return False

        side = sum / 4

        if maximum > side:
            return False

        sides = [0, 0, 0, 0]

        matchsticks.sort(reverse=True)

        return self.helper(matchsticks, 0, sides, side)

    def helper(self, matchsticks, i, sides, side):
        # base case 
        if i == len(matchsticks):
            return True

        # logic
        for j in range(4):
            if sides[j] + matchsticks[i] <= side:
                sides[j] += matchsticks[i]

                if self.helper(matchsticks, i+1, sides, side):
                    return True

                sides[j] -= matchsticks[i]

        return False

            
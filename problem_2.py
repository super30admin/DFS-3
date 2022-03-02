# TC:O(4^L) where l is the matchsticks length
# SC:O(l)

class Solution:
    def makesquare(self, matchsticks: List[int]) -> bool:
        if matchsticks is None or len(matchsticks) == 0:
            return False

        _sum = 0
        matchsticks.sort(reverse=True)

        for m in matchsticks:
            _sum += m

        if _sum % 4 != 0:
            return False

        self.side = _sum // 4

        return self.helper(matchsticks, 0, [0] * 4)

    def helper(self, m, i, arr):
        # base case
        if arr[0] == self.side and arr[1] == self.side and arr[2] == self.side and arr[3] == self.side:
            return True

        if i == len(m):
            return False

        # logic

        for j in range(0, 4):
            if arr[j] + m[i] <= self.side:
                arr[j] = arr[j] + m[i]
                if self.helper(m, i + 1, arr):
                    return True
                arr[j] = arr[j] - m[i]
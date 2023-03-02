# Time complexity: O(5 ^ k)
# Space complexity : O(5^k)


class Solution:
    def __init__(self):
        self.map = {0: 0, 1: 1, 6: 9, 8: 8, 9: 6}
        self.count = 0

    def confusingNumberII(self, n: int) -> int:
        # For Loop Recursion
        self.helper(n, 0)
        return self.count

    def helper(self, n, curr):
        if curr > n:
            return
        if self.checker(curr):
            self.count += 1
        for key, val in self.map.items():
            next_val = curr * 10 + key
            if next_val != 0:
                self.helper(n, next_val)

    def checker(self, num):
        res = 0
        init = num
        while num > 0:
            res = res * 10 + self.map[num % 10]
            num = num//10
        return init != res

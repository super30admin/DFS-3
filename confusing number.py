# Time Complexity : O(1)
# Space Complexity :O(1)


class Solution:
    def __init__(self):
        self.map = {0: 0, 1: 1, 6: 9, 8: 8, 9: 6}
        self.res = 0

    def confusingNumberII(self, N: int) -> int:
        self.helper(N, 0)
        return self.res

    def helper(self, N: int, cur: int):
        if self.isConfusingNumber(cur):
            self.res += 1

        for i in self.map:
            next_num = cur * 10 + i
            if next_num <= N and next_num != 0:
                self.helper(N, next_num)

    def isConfusingNumber(self, n: int) -> bool:
        src = n
        result = 0
        while n > 0:
            result = result * 10 + self.map[n % 10]
            n //= 10
        return result != src

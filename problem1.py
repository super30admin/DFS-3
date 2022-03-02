# TC:O(5^L) where l is the n length
# SC:O(l)

class Solution:
    def confusingNumberII(self, n: int) -> int:
        if n == 0:
            return 0

        self.hmap = {
            0: 0,
            1: 1,
            8: 8,
            6: 9,
            9: 6
        }
        self.count = 0

        self.dfs(n, 0)
        return self.count

    def dfs(self, n, curr):
        if curr > n:
            return

        if self.isValid(curr):
            self.count += 1

        for num in self.hmap:
            newNum = curr * 10 + num

            if newNum != 0:
                self.dfs(n, newNum)

    def isValid(self, n):
        temp = n
        res = 0
        while n > 0:
            res = res * 10 + self.hmap.get(n % 10)
            n = n // 10

        return res != temp


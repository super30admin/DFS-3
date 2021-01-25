#Time Complexity : O(5^(num of digits in maximum number))
#Space Complexity : O(n) where n is the length of the number
#Did this code successfully run on Leetcode : Yes

class Solution:
    def isValid(self, num):
        res, original = 0, num
        while num > 0 :
            if num%10 in self.mapping:
                res = res*10 + self.mapping[num%10]
                num //= 10
        return res != original

    def dfs(self, N, currentNumber):

        if self.isValid(currentNumber):
            self.result += 1

        for n in self.mapping.keys():
            nextNumber = currentNumber * 10 + n
            if nextNumber != 0 and nextNumber <= N:
                self.dfs(N, nextNumber)

    def confusingNumberII(self, N: int) -> int:
        self.mapping = {0:0, 1:1, 6:9, 8:8, 9:6}
        self.result = 0

        self.dfs(N, 0)
        return self.result

class Solution:
    def isvalid(self, n):
        ### TIme - O(5**(no. of digits in n))
        ### Space - O(1)
        result = 0
        src = n
        while n > 0:
            result = result * 10 + self.dic[n % 10]
            n = n // 10
        return result != src

    def dfs(self, N, current):
        if self.isvalid(current):
            self.count += 1
        for key in self.dic:
            nex = current * 10 + key
            if nex <= N and nex != 0:
                self.dfs(N, nex)

    def confusingNumberII(self, N: int) -> int:

        self.dic = {}
        self.count = 0
        self.dic[1] = 1
        self.dic[6] = 9
        self.dic[8] = 8
        self.dic[9] = 6
        self.dic[0] = 0
        self.dfs(N, 0)
        return self.count
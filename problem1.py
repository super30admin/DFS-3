# problem 1 


class Solution:

    def __init__(self):
        self.confuse_map = {
            1:1,
            0:0,
            6:9,
            8:8,
            9:6
        }
        self.count = 0

    def confusingNumberII(self, n: int) -> int:
        self.count = 0
        self.dfs(0,n)
        return self.count
    
    def dfs(self, currNum, n):
        if self.isConfusing(currNum):
            self.count += 1
        for key in self.confuse_map:
            newNum = currNum * 10 + key
            if newNum != 0 and newNum <= n:
                self.dfs(newNum, n)

    def isConfusing(self,number):
        re = 0
        temp = number
        while(number>0):
            last_digit = number%10
            re = re*10 + self.confuse_map.get(last_digit,0)
            number = number//10 
        return re != temp
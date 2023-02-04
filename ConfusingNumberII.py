#Time Complexity: O(5^L)
#Space Complexity: O(L)
#Successfully ran on leetcode

class Solution:
    def __init__(self):
        self.map = {0:0,1:1,6:9,8:8,9:6}
        self.count = 0
    def confusingNumberII(self, n: int) -> int:
        if n==0:
            return False
        self.dfs(0,n)
        return self.count
    def dfs(self,curr,n):
        if curr>n:
            return
        if self.isConfusingNumber(curr):
            self.count+=1
        for i in self.map:
            newNum = curr*10+i
            if newNum!=0:
                self.dfs(newNum,n)
    def isConfusingNumber(self,num):
        temp = num
        rev = 0
        while temp:
            rem = temp%10
            rev = rev*10+self.map[rem]
            temp = temp//10
        if rev!=num:
            return True
        return False
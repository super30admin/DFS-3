#To solvee this problem we use hashmap and dfs as tught in class
#Time Compleity: O(n)
#Space Complexity: O(n)
class Solution:
    def __init__(self):
        self.map = dict()
        self.count = 0

    def confusingNumberII(self, N: int) -> int:
        count = 0
        self.map[0] = 0
        self.map[1] = 1
        self.map[6] = 6
        self.map[8] = 8
        self.map[9] = 6
        self.dfs(N,0)
        return count
    
    def dfs(self,N,current):
        if self.isValid(current):
            self.count += 1
        for key in self.map:
            next = current * 10 + key
            if next <= N and next!=0:
                self.dfs(N,next)
        
    
    def isValid(self,n):
        result = 0
        src = n
        while (n >= 0):
            result = result * 10 + self.map[n%10]
            n = n/10
        return result == src
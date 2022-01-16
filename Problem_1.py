class Solution:
    def confusingNumberII(self, n: int) -> int:
        self.count = 0
        self.hashmap = { 0:0, 1:1, 6:9, 8:8, 9:6}
        self.dfs(n, 0)
        return self.count
    
    def dfs(self, n, curr):
        if curr > n:
            return
        
        if self.isValid(curr):
            self.count += 1
        for key in self.hashmap:
            nextNum = curr * 10 + key
            if nextNum != 0:
                self.dfs(n, nextNum)  
        
    def isValid(self, num):
        result = 0
        initialNum = num
        while num > 0:
            result = result * 10 + self.hashmap[num % 10]
            num //= 10
        return initialNum != result

# Time Complexity: O(1)
# Space Complexity: O(1)
# Because hashmap has only 5 elements
        
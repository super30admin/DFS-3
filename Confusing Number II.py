class Solution:
    #Solution 1
    def confusingNumberII(self, N: int) -> int:
        #Approach: Recursion // DFS
        #Time Complexity: O(5^n)
        #Space Complexity: O(n)
        #where, n is the length of the number N
        
        self.confused = [0, 1, 6, 8, 9]
        self.rotMap = {0: 0, 1: 1, 6: 9, 8: 8, 9: 6}
        self.result = 0
        for n in self.confused[1:]:
            self.dfs(N, n, self.rotMap[n], 10)
        return self.result
    
    def dfs(self, N, num, rotated, digit):
        #base
        if num != rotated:
            self.result += 1
            
        #logic
        for n in self.confused:
            if num * 10 + n > N:
                break
            self.dfs(N, num * 10 + n, self.rotMap[n] * digit + rotated, digit * 10)
    
    #Solution 2
    """
    def confusingNumberII(self, N: int) -> int:
        #Approach: Recursion // DFS
        #Time Complexity: O(n * 5^n)
        #Space Complexity: O(n)
        #where, n is the length of the number N
    
        self.confused = [0, 1, 6, 8, 9]
        self.rotMap = {0: 0, 1: 1, 6: 9, 8: 8, 9: 6}
        self.result = 0
        for num in self.confused[1:]:
            self.dfs(N, num)
        return self.result
    
    def dfs(self, N, curr):
        #base
        if curr > N:
            return
        if self.isConfused(curr):
            self.result += 1
            
        #logic
        for num in self.confused:
            self.dfs(N, curr * 10 + num)
            
    def isConfused(self, N):
        oldN, newN = N, 0
        
        while N:
            rem = N % 10
            if rem not in self.rotMap:
                return False
            newN = newN * 10 + self.rotMap[rem]
            
            N = N // 10

        return newN != oldN
    """
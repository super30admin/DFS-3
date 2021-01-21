'''
Time Complexity : O(5^digits in n) for DFS
Space Complexity : O(1) for DFS 
'''

class Solution:
    def confusingNumberII(self, N: int) -> int:
        self.dic = {}
        self.dic[6] = 9
        self.dic[9] = 6
        self.dic[1] = 1
        self.dic[0] = 0
        self.dic[8] = 8
        self.count = 0
        
        self.dfs(N,0)
        return self.count
        
        
    def dfs(self, N, curr):
        
        if self.isValid(curr):
            self.count+=1
            
        for key in self.dic.keys():
            nextt = curr * 10 + key
            if nextt <= N and nextt != 0:
                self.dfs(N,nextt)
                
    def isValid(self, val):
        res = 0
        ori = val
        while val>0:
            res = res*10 + self.dic[val%10]
            val = val//10
        return res!=ori
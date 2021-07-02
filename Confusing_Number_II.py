class Solution:
    def confusingNumberII(self, n: int) -> int:
        
        if not n :
            return 0
        
        self.h = {0:0, 1:1, 6:9, 8:8, 9:6}
        self.result = 0
        self.dfs(0,n)
        return self.result
    

    def dfs(self,num,n):
        
        if self.isvalid(num):
            self.result += 1
            
        for key in self.h.keys():
            nextnum = num * 10 + key
            if nextnum > 0 and nextnum <= n:
                self.dfs(nextnum, n)
    
    def isvalid(self,num):
        rev = 0
        og = num
        #print(num)
        while num > 0:
            rev = rev * 10 + self.h[num %10]
            num = num // 10
        
        return rev != og


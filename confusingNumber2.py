class Solution:
    # dfs approach
    # TC : O(5**L)
    # SC : O(L) - L is length of number n or number of digits in n
    def isConfusing(self,num)->bool:
        rev = 0
        temp = num
        while temp > 0:
            rem = temp % 10
            rev = rev *10 + self.hmap[rem]
            temp = temp // 10
        return rev != num
    def dfs(self,cur,n):
        # base
        if cur > n:
            return
        # logic
        if self.isConfusing(cur):
            self.ct += 1
        for key in self.hmap.keys():
            newNumber = cur * 10 + key
            if newNumber != 0:
                self.dfs(newNumber,n)
            
    def confusingNumber(self,n:int)->int:
        self.hmap = {0:0,1:1,6:9,8:8,9:6}
        self.ct = 0
        self.dfs(0,n)
        return self.ct
s = Solution()
print(s.confusingNumber(20))
        
        
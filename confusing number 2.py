"""
Time Complexity : O(n)
Space Complexity : O(n)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

Explaination
1. create map of confusing number
2. DFS and for m all number form map
3. check if number os connfusing and add 1 to count
    1. if reversed != original then it is confusing number


"""
class Solution:
    def __init__(self):
        self.count = 0
        
    def confusingNumberII(self, N: int) -> int:
        hm = {0:0, 1:1, 6:9, 8:8, 9:6}
        if N<6: return 0
        self.dfs(0, hm, N)
        return self.count
    
    def dfs(self,cur, hm, N):
        if(self.isConfuse(cur , hm)):
            self.count += 1
        #logic
        for i in hm:
            d = cur*10+i
            
            if d<=N and d!=0:
                self.dfs(d, hm, N)
    
    def isConfuse(self, num, hm):
        src = num
        n = 0
        while num>0:
            n = n*10+hm[num%10]
            num = num//10
        return n!=src
            
        
        
        
        
        
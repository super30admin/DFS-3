from typing import collections
# class Solution:
#     def __init__(self):
#         self.map = {0:0,1:1,6:9,8:8,9:6}
#         self.count = 0

#     def confusingNumberII(self, n: int) -> int:
#         # generate all numers if numnber is confusing increase count
#         self.dfs(0,n)
#         return self.count

#     def dfs(self,currnum,n):
#         # base
#         if self.isconfusing(currnum): self.count+=1
    
#         # logic
#         for key in self.map:
#             newnum = currnum*10+key
#             if newnum!=0 and newnum<=n:
#                 self.dfs(newnum,n)

#     def isconfusing(self,num):
#         temp = num 
#         res = 0
#         while num > 0:
#             last=num%10
#             res = res*10+self.map[last]
#             num = num//10
#         return temp!=res

class Solution:

    def confusingNumberII(self, n: int) -> int:
        # generate all numers if numnber is confusing increase count use bfs
        map = {0:0,1:1,6:9,8:8,9:6}
        q=collections.deque([0])
        count=0
        while q:
            currnum = q.popleft()
            if self.isconfusing(currnum,map): count+=1
            for key in map:
                newnum = currnum*10+key
                if newnum!=0 and newnum<=n:
                    q.append(newnum)
        return count

    def isconfusing(self,num,map):
        temp = num 
        res = 0
        while num > 0:
            last=num%10
            res = res*10+map[last]
            num = num//10
        return temp!=res

        
        
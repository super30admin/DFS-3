# // Time Complexity :O(n)
# // Space Complexity :O(n),worst case
# // Did this code successfully run on Leetcode :yes
# // Any problem you faced while coding this :no

class Solution:
    def __init__(self):
        self.result=0
    def nestedsum(self,nestedli):
        
        q=[]
        for i in nestedli:
            q.append(i)
        depth=1
        while q:
            size=len(q)
            for i in range(size):
                curr=q.pop(0)
                if type(curr)==int:
                    self.result+=depth*curr
                else:
                    for i in curr:
                        q.append(i)
            depth+=1
        return self.result
        
obj=Solution()
print(obj.nestedsum([[1,1],2,[1,1]]))
# // Time Complexity :O(n)
# // Space Complexity :O(n),worst case
# // Did this code successfully run on Leetcode :yes
# // Any problem you faced while coding this :no
class Solution:
    def __init__(self):
        self.result=0
    def nestedsum(self,nestedli):
        self.dfs(nestedli,1)
        return self.result
    def dfs(self,nestedli,depth):
        for i in range(len(nestedli)):
            if type(nestedli[i])==int:
                self.result+=depth*nestedli[i]
            else:
                self.dfs(nestedli[i],depth+1)
obj=Solution()
print(obj.nestedsum([[1,1],2,[1,1]]))
# // Time Complexity :O(n)
# // Space Complexity :O(n),worst case
# // Did this code successfully run on Leetcode :yes
# // Any problem you faced while coding this :no
class Solution:
    def __init__(self):
        self.result=0
    def nestedsum(self,nestedli):
        st=[]
        depth=[]
        for li in nestedli:
            st.append(li)
            depth.append(1)
        while st:
            currdepth=depth.pop()
            curr=st.pop()
            if type(curr)==int:
                self.result+=currdepth*curr
            else:
                for i in curr:
                    st.append(i)
                    depth.append(currdepth+1)
        return self.result
        
obj=Solution()
print(obj.nestedsum([[1,1],2,[1,1]]))
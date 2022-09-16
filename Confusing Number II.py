""""// Time Complexity : O(n^2)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :
"""

class Solution:
    def confusingNumberII(self, n):
        if n==0:
            return 0
        self.h={}
        self.h[0] = 0
        self.h[1] = 1
        self.h[6] = 9
        self.h[8] = 8
        self.h[9] = 6
        self.count=0
        self.li=[]
        self.dfs(n, 0)
        print(self.li)
        return self.count

    def dfs(self, n, curr):
        #base
        if curr>n:
            return

        if self.isValid(curr):
            self.count+=1
            self.li.append(curr)


        #logic
        for i in self.h:
            temp = curr * 10 + i
            if temp!=0:
                self.dfs(n, temp)


    def isValid(self, num):
        curr=0
        temp=num

        while num>0:
            x=num%10
            curr=curr*10 + self.h[x]
            num=num//10


        if temp==curr:
            return False
        else:
            return True


        # return temp!=curr

Obj=Solution()
print(Obj.confusingNumberII(2000))

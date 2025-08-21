"""

A confusing number is a number that when rotated 180 degrees becomes a different number with each digit valid.

We can rotate digits of a number by 180 degrees to form new digits.

When 0, 1, 6, 8, and 9 are rotated 180 degrees, they become 0, 1, 9, 8, and 6 respectively.
When 2, 3, 4, 5, and 7 are rotated 180 degrees, they become invalid.
Note that after rotating a number, we can ignore leading zeros.

For example, after rotating 8000, we have 0008 which is considered as just 8.
Given an integer n, return the number of confusing numbers in the inclusive range [1, n].

TimeComplexity: o(5^x) where x is number of digits of lagest num
SpaceCompexity:O(1)
approach:
start form 1 try genratung all confusing number  this is brute force
at start this looks like DP but this can be done with dfs
yes dfs with number sounds new
we only wnat to genrate number from nums nothing else
start from 0 expand 
but important thing is when to exit
should we exit at 11 which is not confusing 
but 116 is confusing 
so thats aother thing or observe
"""
class Solution:
    def confusingNumberII(self, n: int) -> int:
        
        nums=[0,1,6,8,9]
        def isConfusing(childNum):
            rev=0
            k=childNum
            d={0:0,1:1,6:9,9:6,8:8}
            while(childNum>0):
                rev=d[childNum%10] + rev*10
                childNum=childNum//10
            
            return rev!=k


        def dfs(parentNum,n,nums,ans):
            #base
            if parentNum >n:return 0
            if  isConfusing(parentNum):
                # print(parentNum)
                ans[0]+=1
       #logic
            for i in nums:
                childNum= parentNum*10+i
                if childNum ==0:continue
                
                dfs(childNum,n,nums,ans)
                
            return ans
        ans=[0]
        dfs(0,n,nums,ans)
        return ans[0]

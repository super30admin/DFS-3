# Time Complexity : O(5^L), Where L is number of digits in n
# Space Complexity : O(L), Where L is number of digits in n
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Nothing specific

class Solution:
    def __init__(self):
        self.count=0
        
    def solution(self,number,hashmap,n):
        if(number>n):
            return
        #Check the number is confusing number or not
        if(self.checkconfusingnumber(number,hashmap)):
            self.count+=1
        
        for i in hashmap:
            newnumber=number*10+i
            if(newnumber!=0):
                self.solution(newnumber,hashmap,n)
        
    def checkconfusingnumber(self,number,hashmap):
        temp=number
        rnumber=0
        while(temp>0):
            rnumber=(rnumber*10)+hashmap[(temp%10)]
            temp=temp//10
        return rnumber!=number
    
    def confusingNumberII(self, n: int) -> int:
        hashmap={}
        hashmap[0]=0
        hashmap[1]=1
        hashmap[6]=9
        hashmap[8]=8
        hashmap[9]=6
        self.solution(0,hashmap,n)
        return self.count
        
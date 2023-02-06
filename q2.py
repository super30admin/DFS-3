# Time Complexity : O(4^n), Where n is number of elements in matchsticks
# Space Complexity : O(n), Where n is number of elements in matchsticks
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Nothing specific

from typing import List

class Solution:
    def solution(self,index,array,side_length,square_created):
        #Base Case 
        if(index==len(array)):
            if(square_created[0]==side_length and square_created[1]==side_length and square_created[2]==side_length and square_created[3]==side_length):
                return True
            return False
                
        
        #Actual Logic
        for i in range(4):
        
            if(square_created[i]+array[index]<=side_length):
                square_created[i]=square_created[i]+array[index]#Action
                
                #Recursion
                if(self.solution(index+1,array,side_length,square_created)):
                    return True
                
                square_created[i]=square_created[i]-array[index]#Undo
        return False
    def makesquare(self, matchsticks: List[int]) -> bool:
        if(len(matchsticks)<4):
            return False
        if(sum(matchsticks)%4!=0):
            return False
        
        side=sum(matchsticks)//4
        #print(side)
        #Here we are sorting beacause to hit the base earlier
        matchsticks.sort(reverse=True)
        #print(matchsticks)
        #Here we are trying to fill the elements in square
        square=[0,0,0,0]
        return self.solution(0,matchsticks,side,square)    
        
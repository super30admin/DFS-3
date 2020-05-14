// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None


// Your code here along with comments explaining your approach:
we use DFS in this problem.Instead of traversing through all the numbers in the given range.we try to create all the numbers within the given range using the confused numbers 0,1,6,8,9.
The generated numbers must be checked if done a 180 degree turn gives a valid number or not.If yes we increment the counter.


# Time complexity --> o(5**len(input))
# space complexity --> o(range of the given input)
class Solution:
    def __init__(self):
        self.counter=0
        self.d=dict()
    def backtrack(self,n:int,current:int) -> None:
        if self.isconfusing(current):
            #If the generated number is a confused number then we increment the count
            self.counter=self.counter+1
        #for example given consider the confused numbers are 0,1,6,8,9.
        for key,value in self.d.items():
        #we trying to create all the numbers in the given range.
            nextnum=(current*10)+key
            #we have to make sure that the given number is within the given range and the created number should be zero as it will be running the same loop endlessly.
            #for example 0,1,6,8,9 are confusing numbers.
            #for 0, we get 00,01,06,08,09.
            #Then next it again starts from 00 and then again the same loop continues i.e again the numbers will be 00,01,06,08,09.Inorder to prevent it we see that the created number should not be zero.
            #we run dfs till we have the required numbers in the given range
            if nextnum<=n and nextnum!=0:
                self.backtrack(n,nextnum)
    def isconfusing(self,n:int) -> bool:
    In this we generate the confused number for the given number.
    i.e. for number 186 we to check if 981 which is the confused number of 186 is valid or not.
    #for instance 181,277 is not a confused number as 181 gives 181 which is same as the original number and 277 gives a garbage value.
        orignum=n
        revnum=0
        while n>0:
            revnum=(revnum*10)+self.d[int(n%10)]
            n=int(n/10)
        # print(revnum)
        if orignum!=revnum:
            return True
        return False
        
    def confusingNumberII(self, N: int) -> int:
    #of all the given 10 digits we store the confused numbers in a dictionary
        self.d[0]=0
        self.d[1]=1
        self.d[6]=9
        self.d[8]=8
        self.d[9]=6
        self.backtrack(N,0)
        return self.counter
        
    
        
        
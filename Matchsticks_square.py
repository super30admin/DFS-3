// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None


// Your code here along with comments explaining your approach:
we use backtracking in this problem.
As we have to check if square can be formed or not.
For the input that we have we check the possible combinations by not trying all the combinations i.e.backtracking at the instant where a condition does not satisfy.
Then we check if all the sides in the square have the equal sides then we say that square can be formed using the given matchsticks.
we would have a better time complexity if the given input array is sorted in descending order.

# Time complexity --> o(4**n)
# space complexity --> o(n)
class Solution:
    def backtrack(self,nums:List[int],side:int,cursor:int,result:List[int]) ->bool:
    #If it has traversed through all the match sticks and the sides in the result are equal then we return True indicating square can be formed.
        if cursor==len(nums):
            if result[0]==side and result[1]==side and result[2]==side:
                return True
        for i in range(len(result)):
        #eg: result--> 0 0 0 0 intially, input --> [2,2,2,1,1]
        #first 2 at cursor=0 then result --> 2 0 0 0 .
        #then cursor=1 then we check if input[1]+result[0] is less than the side 2.As it is No.we go to the next index 1.
        #Try with the example 5 5 5 5 4 4 4 4 3 3 3 3 we will have better understanding.
            if result[i]+nums[cursor]<=side:
            #If yes we add the result to the length to the respective side of the square
                result[i]=result[i]+nums[cursor]
                if self.backtrack(nums,side,cursor+1,result):
                    return True
                #backtracking step
                result[i]=result[i]-nums[cursor]
        return False
        
    def makesquare(self, nums: List[int]) -> bool:
        if nums==None or len(nums)==0:
            return False
        sum1=0
        #adding all the given lengths in the array to check if a square can be formed or not.
        for i in nums:
            sum1=sum1+i
        #4 sides in a square if it is not divisible by 4 then square cant be formed using the given input.
        if sum1%4!=0:
            return False
        #we sort the input as it is easy to find the sequence and we will be having less running time
        nums=sorted(nums,reverse=True)
        #we make 4 length array inorder to store the length of the square in the array.
        result=[0 for i in range(4)]
        return self.backtrack(nums,sum1//4,0,result)
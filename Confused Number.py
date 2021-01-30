# Time:- O(2^n)
# Space:-O(2^n)
# Approach:- We have some options on which we can backtrack and form a number and then we can check if
# the number formed is less than the given number and if we reverse it does it form the same number of  or not, if yes then we can increase the result count.
class Solution:
    def confusingNumberII(self, N: int) -> int:
        options=[0,1,6,8,9]
        self.res=0
        # reverse the number and check if it is same as the old number
        def valid(number):
            maps=[0,1,0,0,0,0,9,0,8,6]
            newnumber=0
            oldnumber=number
            while(number>0):
                newnumber=newnumber*10+maps[number%10]
                number//=10
            if newnumber==oldnumber:
                return False
            return True
            
        def cn(number):
            # if number formed is greater than n return
            if number>N:
                return
            # if number formed is less than n and valid then increase res count
            if number<=N and valid(number):
                self.res+=1
            # for all the number in options backtrack and try to form the numbers
            for i in options:
                # action
                number=number*10+i
                # number can't be 0
                if number==0:
                    continue
                # recurse
                cn(number)
                # backtrack
                number//=10
        cn(0)
        return self.res

sol=Solution()
sol.confusingNumberII(100)
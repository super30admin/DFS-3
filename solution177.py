#Time Complexity:O(n)
#Space Complexity:O(n)
#we start by adding the basic confusing numbers in deque and checking in the number is a valid confusing number. for each number popped from the
#deque we insert the combinations of deque with current confusinh number. if the confusing number is valid we increment count by one.
class Solution:
    def confusingNumberII(self, N: int) -> int:
        cNums=[0,1,6,8,9]
        d=collections.deque([1,6,8,9])
        count=0
        while d and d[0]<=N:
            curr=d.popleft()
            if self.isValid(curr):
                count+=1
            for n in cNums:
                d.append(curr*10+n)
        return count
    
    def isValid(self,n:int)->bool:
        confusingNumbers={'0':'0','1':'1','6':'9','8':'8','9':'6'}
        s=str(n)
        for i in range(len(s)):
            if s[i]!=confusingNumbers[s[-i-1]]:
                return True
        return False


#Time Complexity:O(n)
#Space complexity:O(1)
#Did not run completly on leetcode. Encountering TLE for large values of N
class Solution:
    def confusingNumberII(self, N: int) -> int:
        if N<2:
            return 0
        count=0
        self.confusingNums={0:0,1:1,6:9,8:8,9:6}
        for num in range(1,N+1):
            if self.confusingNumbers(num,num,0):
                count+=1
        return count
    
    def confusingNumbers(self,num:int,currNum:int,newNum:int)->bool:
        if num==0:
            if newNum!=currNum:
                return True
            return False
        n=num%10
        if n in self.confusingNums:
            newNum=(newNum*10)+self.confusingNums[n]
            return self.confusingNumbers(num//10,currNum,newNum)
        return False
class Solution:
    def confusingNumberII(self, N: int) -> int:
        digits = [0,1,6,8,9]
        
        queue = deque([0])
        count = 0
        def dfs(num):
            nonlocal count
            if self.isValid(num):
                count+=1
            for i in digits:
                nextVal = num*10+i
                if nextVal<=N and nextVal!=0:
                    dfs(nextVal)
        dfs(0)  
        return count    

                 
    def isValid(self, n: int) -> bool:

        hashmap = {'0': '0', '1': '1', '6': '9', '9': '6', '8': '8'}
        S = str(n)
        
        for index, letter in enumerate(S):
            if letter!=hashmap[S[-index-1]]:
                return True
        return False
Time: N*5^number of digits in N
Space: 5* Number of digits in N

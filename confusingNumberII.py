"""
TC=O(5^# of digits in max number)
SC=0(len of numbers) in stack else O(1) excluding stack
""" 
class Solution():
    def confusingNumberII(self, N):
        """
        :type N: int
        :rtype: int
        """
        self._map = {0:0, 1:1, 6:9, 8:8, 9:6}
        self.count = 0
        self.N=N
        self.dfs(0)
        return self.count
        # to check if a given number is confusing
    def isValidConfusing(self,n):
        src = n
        res = 0
        # Reverse the digits and get the 180 degree rotated equivalent from the map
        while n > 0:
            if n%10 in self._map:
                res = res * 10 + self._map[n%10]
                n = n//10
            else:
                return False
        # If the flipped number is not equal to the original number, it is a confusing number
        return res != src
        
    # To generate all possible candidates
    def dfs(self,n): #0,1,6,8,9--->[01,00,06,08,09][10,11,16,18,19]
        #logic          
        if self.isValidConfusing(n):
            self.count += 1
          
        for k in self._map.keys(): 
            _next = n * 10 + k
            if _next <= self.N and _next != 0:
                self.dfs(_next)
    
    

s=Solution()
val=s.confusingNumberII(20)
print(val)
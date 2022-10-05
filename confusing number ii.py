# Time complexity: O(n)
# Space complexity: O(n)
# Approach: do dfs for only possible number that are put in hashmap.
# check if the number is confusing number

class Solution:
    def __init__(self):
        self.hashmap = dict()
        self.count = 0
    def confusingNumberII(self, n: int) -> int:
        self.hashmap[0] = 0
        self.hashmap[1] = 1
        self.hashmap[6] = 9
        self.hashmap[8] = 8
        self.hashmap[9] = 6
        self.dfs(0,n)
        return self.count
    def dfs(self,number, n):
        if number > n:
            return
        if(self.confusingnumber(number)):
            self.count += 1
        for key in self.hashmap:
            newnumber = (number*10)+ key
            if newnumber != 0:
                self.dfs(newnumber,n)
    def confusingnumber(self,number):
        orinum = number
        newnumber = 0
        while number > 0:
            rem = number % 10
            newnumber = (newnumber * 10) + self.hashmap[rem]
            number = number // 10
        return newnumber != orinum
            
            
            
            
        
        
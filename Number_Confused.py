# Time complexity : O(5^k) --> k = number os digits
# Space complexity : O(5^k)
# Leetcode : Solved and submitted

class Solution:
    def confusingNumberII(self, n: int) -> int:
        # make a hashmas of the numbers from 1-10 with thier inverted number
        self.hashmap = {0:0, 1:1, 6:9, 8:8, 9:6}
        
        # keep a count as the global variable which is incremented when a confusing number is encountered
        self.count = 0
        
        # call the dfs helper function and then return the count
        self.dfs(0, n)
        return self.count
    
    def dfs(self, currNum, n):
        # if the number is already greater than or equal to n, then we simply return
        if currNum >= n:
            return
          
        # we need to form the numbers with the digits present in the hashmap, as other digits are invalid
        for keys in self.hashmap:
            # form the new num
            newNum = currNum * 10 + self.hashmap[keys]
            
            # if the num is less than n, then check for 0, if so then simply continue
            if newNum <= n:
                if newNum == 0:
                    continue
                # check if the number is confusing, if so, then increment the count
                if self.isConfusing(newNum):
                    self.count += 1
                # call the dfs function on the newNum
                self.dfs(newNum, n)
    
    # in this function, we need to invert the whole number, and if it is different, then return True else return False
    def isConfusing(self, num):
        temp = num; res = 0
        while num > 0:
            res = res * 10 + self.hashmap[num%10]
            num = num//10
        return temp != res

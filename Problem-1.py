# Time Complexity : O(5^logN)
# Space Complexity : O(logN)
# Did this code successfully run on Leetcode : No
# Any problem you faced while coding this : No

# Explanation:
# Valid digits are 0,1,6,8,9.
# Use DFS to build numbers.
# Rotate number and check if rotated value differs.

class Solution:
    def confusingNumberII(self, n: int) -> int:
        
        rotate = {0:0,1:1,6:9,8:8,9:6}
        digits = [0,1,6,8,9]
        
        count = 0
        
        def dfs(num):
            nonlocal count
            
            if num > n:
                return
            
            if isConfusing(num):
                count += 1
            
            for d in digits:
                next_num = num*10 + d
                if next_num != 0:
                    dfs(next_num)
        
        def isConfusing(num):
            original = num
            rotated = 0
            
            while num:
                rotated = rotated*10 + rotate[num%10]
                num //= 10
            
            return rotated != original
        
        dfs(0)
        
        return count
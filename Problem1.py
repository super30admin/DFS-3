"""
Time Complexity: O(n^0.7*log n)
Space Complexity: O(log n)
"""
class Solution:
    def confusingNumberII(self, n: int) -> int:
        if n == 0:
            return 0
        hashMap = {0:0, 1:1, 6:9, 8:8, 9:6}
        digits = [0, 1, 6, 8, 9]
        self.count = 0

        def isConfusing(num):
            original = num
            rotated = 0
            while num > 0:
                digit = num % 10
                rotated = rotated * 10 + hashMap[digit]
                num //= 10
            return rotated != original
        
        def dfs(num):
            if num > n:
                return
            if isConfusing(num):
                self.count += 1

            for d in digits:
                if num == 0 and d == 0:
                    continue
                newNum = num * 10 + d
                if newNum <= n:
                    dfs(newNum)
        dfs(0)
        return self.count
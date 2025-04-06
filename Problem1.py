# In this approach, we use a depth-first search (DFS) to explore all possible numbers that can be formed using the digits 0, 1, 6, 8, and 9. We check if the number is confusing by reversing it and comparing it with the original number. If they are different, we count it as a confusing number. The function continues to build numbers until it exceeds the given limit `n`. The final count of confusing numbers is returned.
# This code is for the problem of counting confusing numbers up to a given integer n.
# TC: O(5^d) where d is the number of digits in n, since we can have at most 5 choices (0, 1, 6, 8, 9) for each digit.
# # SC: O(d) for the recursion stack, where d is the number of digits in n.

class Solution:
    def confusingNumberII(self, n: int) -> int:
        if n == 0:
            return 0
        self.count = 0

        def isconfusing(num):
            rev = 0
            temp = num
            while temp > 0:
                rem = temp % 10
                rev = rev * 10 + map[rem]
                temp = temp // 10
            return num != rev

        def dfs(curr, n):
            if curr > n:
                return
            if isconfusing(curr):
                self.count += 1
            for key in map.keys():
                newnum = curr * 10 + key
                if newnum != 0:
                    dfs(newnum, n)
        map = {0: 0, 1: 1, 6: 9, 8: 8, 9: 6}
        dfs(0, n)
        return self.count

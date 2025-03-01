"""
TC: O(5^d) d is number of maximum digits in n
SP: O(5^d)
"""
class Solution:
    def confusingNumberII(self, n: int) -> int:
        confusing_map = {0: 0, 1: 1, 6: 9, 8: 8, 9: 6}

        def isConfusing(n):
            num = 0
            original_n = n
            while n:
                d = n % 10
                if d not in confusing_map:
                    return False
                n = n // 10
                num = num * 10 + confusing_map[d]
            return num != original_n

        result = 0
        confusing_digits = [0, 1, 6, 8, 9]
        q = deque([0])
        while q:
            for i in range(len(q)):
                curr= q.popleft()
                if isConfusing(curr):
                    result += 1
                for j in confusing_digits:
                    new_num = curr * 10 + j
                    if new_num != 0 and new_num <= n:
                        q.append(new_num)


        return result

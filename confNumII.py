class Solution:
    def __init__(self):
        self.valid_digits = [0, 1, 6, 8, 9]
        self.rotation_map = {0: 0, 1: 1, 6: 9, 8: 8, 9: 6}
        self.count = 0

    def confusingNumberII(self, n: int) -> int:
        for digit in self.valid_digits:
            if digit != 0:
                self.dfs(digit, self.rotation_map[digit], 10, n)
        return self.count

    def dfs(self, num, rotated_num, place_value, n):
        if num != rotated_num:
            self.count += 1

        for next_digit in self.valid_digits:
            new_num = num * 10 + next_digit
            if new_num <= n:
                self.dfs(new_num, self.rotation_map[next_digit] * place_value + rotated_num, place_value * 10, n)
        


#TLE Solution
class Solution:
    def confusingNumberII(self, n: int) -> int:

        def is_confusing(num):
            original = num
            rotated_num = 0
            while num > 0:
                digit = num % 10
                if digit not in rotation_map:
                    return False
                rotated_num = rotated_num * 10 + rotation_map[digit]
                num //= 10
            return rotated_num != original

        rotation_map = {0: 0, 1: 1, 6: 9, 8: 8, 9: 6}
        count = 0

        for i in range(1, n + 1):
            if is_confusing(i):
                count += 1

        return count

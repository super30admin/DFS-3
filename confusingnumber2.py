# Time Complexity: O(5^k)
# Space Complexity: O(5^k)

class Solution:
    def confusingNumberII(self, n: int) -> int:
        hash_map = {0: 0, 1: 1, 6: 9, 8: 8, 9: 6}
        queue = deque()
        queue.append(0)
        count = 0

        while queue:
            curr = queue.popleft()
            if self.isconfusing(curr, hash_map):
                count += 1

            for key in hash_map.keys():
                new_num = (curr * 10) + key

                if new_num != 0 and new_num <= n:
                    queue.append(new_num)

        return count

    def isconfusing(self, num, hash_map):
        temp = num
        result = 0

        while num > 0:
            last_digit = num % 10
            result = (result * 10) + hash_map[last_digit]
            num = num // 10

        return result != temp


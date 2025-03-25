'''
    Time Complexity: O(5^k)
    Space Complexity: O(5^k)
'''
class Solution:
    def __init__(self):
        self.confusingMap = {
            0: 0,
            1: 1,
            6: 9,
            8: 8,
            9: 6,
        }
        
    def confusingNumberII(self, n: int) -> int:
        queue = deque()
        queue.append(0)
        count = 0

        while len(queue):
            popped = queue.popleft()

            if self.isConfusing(popped):
                count += 1

            for key in self.confusingMap.keys():
                newNum = popped*10 + key

                if newNum != 0 and newNum <= n:
                    queue.append(newNum)

        return count

    def isConfusing(self, num):
        newNum = 0
        temp = num

        while num:
            rem = num % 10
            newNum = newNum*10 + self.confusingMap[rem]
            num = num // 10

        if temp != newNum:
            return True
        else:
            return False
        
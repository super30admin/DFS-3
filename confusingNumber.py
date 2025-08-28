from collections import defaultdict
class Solution:
    def confusingNumberII(self, n: int) -> int:
        confusingMap = {0:0, 1: 1, 6:9, 8:8, 9:6}
        nums = [0, 1, 6, 8, 9]
        self.res = 0
        def isConfusing(num):
            oldNum = num
            newNum = 0
            while oldNum:
                newNum = newNum*10 + confusingMap[oldNum%10]
                oldNum = oldNum//10

            if num != newNum:
                return True
            return False

        def recurse(num):
            if num > n:
                return
            
            if isConfusing(num):
                self.res += 1

            for dig in nums:
                newNum = num*10 + dig
                if newNum == 0:
                    continue
                
                recurse(newNum)
        recurse(0)
        return self.res

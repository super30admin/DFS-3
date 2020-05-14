'''
Time Complexity: O(4^n)
Space Complexity: O(n)
Did this code successfully run on Leetcode : Yes
Explanation: Use Backtracking to create all number pairs from 0 to N but each number pair would only be of digits 0,3,6,8,9
as these are confusing numbers and at each state of creating a number check if its a valid number ie the source should not
be equal to destination.
'''


class Solution:
    def __init__(self):
        self.count = 0
        self.c_no = {
            0: 0,
            1: 1,
            6: 9,
            8: 8,
            9: 6
        }

    def isConfusing(self, num: int) -> int:
        src = num

        dest = 0
        while num > 0:
            digit = num % 10
            num = num // 10
            dest = dest * 10 + (self.c_no.get(digit))

        return src != dest

    def backTrack(self, N: int, current: int) -> int:
        if self.isConfusing(current):
            self.count += 1

        for key in self.c_no.keys():
            next1 = current * 10 + key
            # next1!=0 needs to taken for 00
            if next1 <= N and next1 != 0:
                self.backTrack(N, next1)

    def confusingNumberII(self, N: int) -> int:
        self.backTrack(N, 0)
        return self.count
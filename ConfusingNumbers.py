'''
Solution:
1.  Can be performed using both DFS (Backtracking) and BFS.
2.  In both the methods, the main idea is to generate next potential confusing number until N from already existing
    confusing digits (or numbers).
3.  Checking whether confusing or not is O(1) time function and update the count if confusing (base case for DFS).

Time Complexity:    O(N) for both DFS and BFS, as N potential nodes (or numbers) can be generated
Space Complexity:   O(H) for DFS and O(N/2) for BFS, which in worst case would be O(N) in both the cases.

--- Passed all testcases successfully on leetcode for both the solutions.
'''


from collections import deque

class ConfusingDFS:

    def __init__(self):

        #   initializations
        self.map = {0: 0, 1: 1, 6: 9, 8: 8, 9: 6}
        self.count = 0

    def __isConfusing(self, n: int) -> bool:

        src = n
        dest = 0

        while (n > 0):
            lastDigit = n % 10
            lastDigitRotated = self.map[lastDigit]
            dest = (dest * 10) + (lastDigitRotated)
            n = int(n / 10)

        return (src != dest)

    def __backtrack(self, N: int, currentValue: 'long') -> None:

        #   base case for checking whether the number is confusing or not
        if (self.__isConfusing(currentValue)):
            self.count += 1

        #   for each potential confusing digit,
        for key in self.map:

            #   generate next potential confusing number and backtrack if < N
            nextValue = (currentValue * 10) + key
            if (nextValue <= N and nextValue != 0):
                self.__backtrack(N, nextValue)

        return

    def confusingNumberII(self, N: int) -> int:

        #   call backtracking helper function
        self.__backtrack(N, 0)

        return self.count


class ConfusingBFS:

    def __isConfusing(self, n: int, mapper: dict) -> bool:

        src = n
        dest = 0

        while (n > 0):
            lastDigit = n % 10
            lastDigitRotated = mapper[lastDigit]
            dest = (dest * 10) + (lastDigitRotated)
            n = int(n / 10)

        return (src != dest)

    def confusingNumberII(self, N: int) -> int:

        #   initializations
        count = 0
        mapper = {0: 0, 1: 1, 6: 9, 8: 8, 9: 6}
        queue = deque([0])

        #   until queue is empty
        while (len(queue) > 0):

            #   check for popped element
            currentValue = queue.popleft()
            if (self.__isConfusing(currentValue, mapper)):
                count += 1

            #   for each potential confusing digit,
            for key in mapper:

                #   generate next potential confusing number and add to queue if < N
                nextValue = (currentValue * 10) + key
                if (nextValue <= N and nextValue != 0):
                    queue.append(nextValue)

        #   return the final count
        return count
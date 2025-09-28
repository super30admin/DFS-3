'''
473 Matchsticks to Square
https://leetcode.com/problems/matchsticks-to-square/description/

You are given an integer array matchsticks where matchsticks[i] is the length of the ith matchstick. You want to use all the matchsticks to make one square. You should not break any stick, but you can link them up, and each matchstick must be used exactly one time.

Return true if you can make this square and false otherwise.

Example 1:
Input: matchsticks = [1,1,2,2,2]
Output: true
Explanation: You can form a square with length 2, one side of the square came two sticks with length 1.

Example 2:
Input: matchsticks = [3,3,3,3,4]
Output: false
Explanation: You cannot find a way to form a square with all the matchsticks.

Constraints:
1 <= matchsticks.length <= 15
1 <= matchsticks[i] <= 10^8

Solution:
1. Backtracking - 1
First, we find the total length and check if it's divisible by 4, and also make sure no stick is longer than a side. Then we sort the sticks in descending order so that bigger ones go first - this helps reduce the number of backtrack options. Finally, we try putting each stick on all four sides using recursion, and backtrack if it overflows.
https://youtu.be/9prSQxNiaCM?t=530 (why greedy doesn't work)
https://youtu.be/9prSQxNiaCM?t=934 (why backtracking works)
Time: O(4^N), Space: O(N), Recursive stack space takes O(N)

2. Backtracking - 2
Logic is identical to Backtracking - 1. The only difference is in the minor change in the structure of the code in backtracking. Easier to understand.
This also prints which matchsticks were used to build each side of the square.
Time: O(4^N), Space: O(N), Recursive stack space takes O(N)

'''
from typing import List
from copy import deepcopy as dcp

def makesquare_1(matchsticks: List[int]) -> bool:
    ''' Backtracking - 1
        Time: O(4^N), Space: O(N)
    '''
    def backtrack(matchsticks, index, square, side):
        # base
        if index == N:
            # we do not need to run this if-statement since this is inherently
            # checked in the if-statement surrounding the
            # action-recursion-backtrack block
            if square[0] == side and square[1] == side and square[2] == side:
                return True
            return False

        # logic
        for i in range(4):
            if square[i] + matchsticks[index] <= side:
                square[i] = matchsticks[index] + square[i]
                if backtrack(matchsticks, index+1, square, side):
                    return True
                square[i] = square[i] - matchsticks[index]
        return False

    if not matchsticks:
        return False

    # sort the matchsticks array by descending order
    # Why? If the largest value in the array > len of side,
    # then we can declare early that forming a square is not possible
    # from the given lengths in the array
    matchsticks.sort(key = lambda x: -x)
    N = len(matchsticks)
    perimeter = 0
    for i in range(N):
        perimeter += matchsticks[i]
    # perimeter of square= 4*side. Hence, perimeter should be divisible by 4
    if perimeter % 4 != 0:
        return False

    side = perimeter/4
    # hence max(matchsticks) <= side. If not, matchsticks array is invalid
    square = [0]*4 # track how much we have added to each side of the square
    return backtrack(matchsticks, 0, square, side)

def makesquare_2(matchsticks: List[int]) -> bool:
    '''
    Backtracking - 2
    Time: O(4^N), Space: O(N)
    '''
    def recurse(matchsticks, square, j):
        nonlocal result
        if j == N:
            if square[0] == square[1] == square[2] == side:
               #result.append(square.copy())
               result.append(dcp(path))
            return

        for i in range(4):
            square[i] = square[i] + matchsticks[j]
            path[i].append(matchsticks[j])
            if square[i] <= side:
                recurse(matchsticks, square, j+1)
            if not result: # don't use else here
                square[i] = square[i] - matchsticks[j]
                path[i].pop()
        return


    N = len(matchsticks)
    perimeter = 0
    for m in matchsticks:
        perimeter += m

    if perimeter % 4 != 0:
        return False, []

    side = perimeter // 4
    square = [0]*4

    result = []
    # path tracks which matchsticks are added for each side of square
    path = [[] for _ in range(4)]
    recurse(matchsticks, square, 0)
    if result:
        return True, result
    return False, []

def run_makesquare():
    tests = [([1,1,2,2,2], True),
             ([1,2,2,2,1], True), # ordering doesn't matter
             ([3,3,3,3,4], False),
             ([5,5,5,5,4,4,4,4,3,3,3,3], True),
    ]
    for test in tests:
        matchsticks, ans = test[0], test[1]
        print(f"\nmatchsticks = {matchsticks}")
        for method in [1, 2]:
            if method == 1:
                is_square = makesquare_1(matchsticks)
                print(f"Method {method}: square possible = {is_square}")
            elif method == 2:
                is_square, square = makesquare_2(matchsticks)
                print(f"Method {method}: square possible = {is_square}")
                if is_square:
                    print(f"Sides of square = {square}")
            success = (ans == is_square)
            print(f"Pass: {success}")
            if not success:
                print("Failed")
                return

run_makesquare()

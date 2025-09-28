'''
1088 Confusing Number II
https://leetcode.com/problems/confusing-number-ii/description/

A confusing number is a number that when rotated 180 degrees becomes a different number with each digit valid.

We can rotate digits of a number by 180 degrees to form new digits.
When 0, 1, 6, 8, and 9 are rotated 180 degrees, they become 0, 1, 9, 8, and 6 respectively.
When 2, 3, 4, 5, and 7 are rotated 180 degrees, they become invalid.

Note that after rotating a number, we can ignore leading zeros.
For example, after rotating 8000, we have 0008 which is considered as just 8.

Given an integer n, return the number of confusing numbers in the inclusive range [1, n].

Example 1:
Input: n = 20
Output: 6
Explanation: The confusing numbers are [6,9,10,16,18,19].
6 converts to 9.
9 converts to 6.
10 converts to 01 which is just 1.
16 converts to 91.
18 converts to 81.
19 converts to 61.

Example 2:
Input: n = 100
Output: 19
Explanation: The confusing numbers are [6,9,10,16,18,19,60,61,66,68,80,81,86,89,90,91,98,99,100].

Constraints:
1 <= n <= 10^9

Solution:
1. Brute Force
For each number from 1 to n, check if it is a confusing number or not.
Time: O(nL), Space: O(1)

2. DFS
We build numbers using only the digits {0,1,6,8,9}. By using DFS, we generate the confusing numbers up to n. By doing so, we don't need to traverse every number from 1 to n (as we did in brute force)

Consider the digit 1 in the map
1*10 + 0 = 10 (confusing no. 1)
1*10 + 1 = 11 (not confusing since rotated(11) = 11)
1*10 + 6 = 16 (confusing no. 91)
1*10 + 8 = 18 (confusing no. 81)
1*10 + 9 = 19 (confusing no. 61)

Consider the digit 6 in the map
6*10 + 0 = 60 (confusing no. 9)
6*10 + 1 = 61 (confusing no. 19)
6*10 + 6 = 66 (confusing no. 99)
6*10 + 8 = 68 (confusing no. 89)
6*10 + 9 = 69 (confusing no. 69)

https://youtu.be/eglgM0NoRX0?t=172

Time: O(5^L) (size of map = 5), L = no. of digits in n
Space: O(L) (Recursive stack space)

3. BFS
see archive

'''
def confusingNumberII_bruteforce(n: int) -> int:
    def is_confusing(num):
        original = num
        rotated = 0
        while num != 0: # O(L), L = no. of digits
            r = num % 10
            if r not in h:
                return False
            rotated = rotated*10 + h[r]
            num = num // 10
        if rotated == original:
            return False
        return True

    result = []
    count = 0
    h={0:0,1:1,6:9,9:6,8:8}
    for num in range(1,n+1): # O(n)
        if is_confusing(num):
            result.append(num)
            count += 1
    return count, result

def confusingNumberII_dfs(n: int) -> int:
    def isConfusing(num):
        rotated = 0 # reverse of 106 is 901
        temp = num
        while temp > 0:
            rem = temp % 10
            if rem not in map:
                return False
            rotated = rotated*10 + map[rem]
            temp = temp // 10
        return rotated != num

    def dfs(curr, n):
        nonlocal count
        if curr > n:
            return

        if isConfusing(curr):
            count += 1

        for k in map:
            new = curr*10 + k
            if new != 0: # infinite recursion w/o check! dfs(0)->dfs(0)->...
                dfs(new, n)

    if n <= 1:
        return 0
    map = {0:0, 1:1, 6:9, 8:8, 9:6}
    count = 0
    dfs(0, n)
    return count

def run_confusingNumberII():
    tests = [(20, 6), (100, 19)]
    for test in tests:
        n, ans = test[0], test[1]
        print(f"\nn = {n}")
        for method in ['bruteforce', 'dfs']:
            if method == 'bruteforce':
                count, confusings = confusingNumberII_bruteforce(n)
                print(f"{method}: count = {count}")
                print(f"confusing nos. = {confusings}")
            elif method == 'dfs':
                count = confusingNumberII_dfs(n)
                print(f"{method}: count = {count}")
            success = (ans == count)
            print(f"Pass: {success}")
            if not success:
                print(f"Failed")
                return

run_confusingNumberII()

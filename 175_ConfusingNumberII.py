class Solution:
    def __init__(self):
        # when flipped 180 degrees, valid numbers are given below and their corresponding value.
        self.flipN = [['0','0'],['1','1'],['6','9'],['8','8'],['9','6']]

    def ConfusingNumberII(self, N):
        number = str(N) # convert the number to string to access each digit individually.

        totalValid = self.calcTotal(number) # to get the count of valid numbers within given range after flipping.

        print(totalValid)

        # taking each digit range at once, like first 1 digit then increase to 2 digit and so on.
        for length in range(1, len(number)+1):
            curr = ['' for i in range(length)]

            # call backtracking function and substract non confusing numbers from totalValid
            totalValid = totalValid - self.backtracking(curr, 0, length-1, number)

        return totalValid

    # this function is used to find out all the valid non-confusing numbers in the given range.
    def backtracking(self, curr, left, right, number):
        retVal = 0

        # base case
        if left > right:
            currString = ''
            currString = currString.join(curr) # convert character array to a string.

            # check for either length of current string is less than given number or
            # current number is less than given number then add 1 to return count.
            if len(currString) < len(number) or int(currString) <= int(number):
                print("currString(non-confusing numbers): ", currString)
                retVal += 1

            return retVal

        # recursive case
        for p in self.flipN:
            # iterate for all elements in flipped valid numbers and check for palindromes.
            # (this goes for each increment in count of digits in number)
            curr[left] = p[0]
            curr[right] = p[1]

            # edge cases to handle: to avoid confusing numbers
            # 1. avoid numbers with first number as '0'.
            # 2. avoid 6 and 9 in case of single digit.
            if ((curr[0] == '0' and len(curr) > 1) or (left == right and p[0] != p[1])):
                continue
            retVal += self.backtracking(curr, left + 1, right - 1, number)

        return retVal

    # calculate total Valid numbers
    def calcTotal(self, number):
        # base case
        if len(number) == 0:
            return 1

        # recursive case
        first = number[0]

        # other than first rest of the places can take all the 5 values in the valid list.
        # (calculating permutation for valid numbers in he given range)
        retVal = self.countBefore(first) * pow(5, len(number) - 1)

        if first == 0 or first == 1 or first == 6 or first == 8 or first == 9:
            # if first integer is among the above 5 numbers then repeat the procedure for remaining digits
            # eg. - split the range - 633 can be split to (0-599) and (600-633) and add the count of both
            # to get the valid numbers
            retVal += self.calcTotal(number[1:])

        return retVal

    # for each char in N, keeping a count of valid numbers before it.
    def countBefore(self, ch):
        count = 0
        for p in self.flipN:
            if p[0] < ch:
                count += 1
            else:
                break
        return count


sol = Solution()
print(sol.ConfusingNumberII(633))

class Solution:
    def confusingNumberII(self, N: int) -> int:
        '''
         Time Complexity: O(5^n), where n is the number of digits in N.
         In the worst case, we generate all possible numbers with '01689' digits, which is 5^n.
         Space Complexity: O(n), where n is the number of digits in N. Because of recursion depth, which is at most the number of digits in N.
        '''
        # Define the confusing pairs of digits
        confusing_pairs = {'0': '0', '1': '1', '6': '9', '8': '8', '9': '6'}

        # Function to check if a number is confusing
        def is_confusing(num_str):
            # Reverse the number and replace digits based on confusing_pairs
            rotated = ''.join([confusing_pairs[char]
                              for char in num_str[::-1]])
            # Check if the rotated number is different from the original
            return rotated != num_str

        # Function to count confusing numbers
        def count_confusing_numbers(num_str, length):
            nonlocal count
            if len(num_str) == length:
                # Check if the number is not a leading zero, within the range, and confusing
                if num_str[0] != '0' and int(num_str) <= N and is_confusing(num_str):
                    count += 1

            if len(num_str) + 1 <= length:
                # Recursively generate numbers by appending '01689' digits
                for char in '01689':
                    count_confusing_numbers(num_str + char, length)

        count = 0
        num_digits = len(str(N))

        # Iterate through different lengths of numbers
        for length in range(1, num_digits + 1):
            for char in '01689':
                # Start generating numbers with '01689' digits
                count_confusing_numbers(char, length)

        return count

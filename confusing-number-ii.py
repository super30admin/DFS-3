# TIME COMPLEXITY: O(5^# of digits in max number)
# SPACE COMPLEXITY: O(1), explicit, O(length of number) stack space
class Solution(object):
    def confusingNumberII(self, N):
        """
        :type N: int
        :rtype: int
        """
        _map = {0:0, 1:1, 6:9, 8:8, 9:6}
        count = [0]
        
        # Function to check if a given number is confusing
        def isConfusing(n):
            src = n
            result = 0
            # Reverse the digits and get the 180 degree rotated equivalent from the map
            while n > 0:
                if n%10 in _map:
                    result = result * 10 + _map.get(n%10)
                    n = n//10
                else:
                    return False
            # If the flipped number is not equal to the original number, it is a confusing number
            return result != src
        
        # Function to recursively generate all possible candidates
        def dfs(n):
            # Logic            
            if isConfusing(n):
                count[0] += 1
                
            # Recursive Case
            for k in _map.keys():
                _next = n * 10 + k
                if _next <= N and _next != 0:
                    dfs(_next)
    
        
        dfs(0)
        return count[0]
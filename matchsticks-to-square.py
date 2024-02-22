# Approach - Put a matchstick at each and every place and check if we are able to form the square. Or else we backtrack.

class Solution:
    def makesquare(self, matchsticks: List[int]) -> bool:
        total = 0
        for i in matchsticks:
            total += i
        if total%4 != 0: return False # If total is not divided by 4, return False directly
        arr = [0,0,0,0] #To store and check if the combinations give us 4 sides of square
        matchsticks.sort(reverse = True) # calculations become too lengthy for big numbers
        # Sorting in reverse manner helps in forming less combinations (we get right 
        # combinations lttle bit quicker)
        return self.backtrack(matchsticks, 0, arr ,total/4)

    def backtrack(self, matchsticks, idx, arr, side) -> bool:
        # base
        if arr[0] == side and arr[1] == side and arr[2] == side and arr[3] == side: return True
        if idx == len(matchsticks): return False # We couldn't find any combination even after
        # traversing all matchsticks elements
        # action
        for i in range(4): 
            if arr[i] + matchsticks[idx] <= side: # check where we can add the given idx
                arr[i] += matchsticks[idx]
                if (self.backtrack(matchsticks, idx+1, arr, side)): return True # if we manage to go till end return true
                arr[i] -= matchsticks[idx] # Backtracking, we couldn't form the other combination after adding idx to the i. Hence backtrack
        return False

        
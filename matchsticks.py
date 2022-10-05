# Time complexity: O(n)
# Space complexity: O(n)-recursive stack space
# Approach: create a array of size 4 and keep adding the value at index in array till its not larger than the maxlength of a side
# Do for loop based backtracking.


class Solution:
    def makesquare(self, matchsticks: List[int]) -> bool:
        sums = sum(matchsticks)
        if sums < 4:
            return False
        if sums % 4 != 0:
            return False
        side = sums//4
        array = [0 for i in range(4)]
        matchsticks.sort(reverse = True)
        return self.backtrack(matchsticks,0,side,array)
       
    
    def backtrack(self, matchsticks, index,side,array):
        if(index == len(matchsticks)):
            if(array[0] == side and array[1] == side and array[2]== side and array[3]==side):
                return True
            return False
    
        for i in range(4):
            if(array[i]+matchsticks[index] <= side):
                array[i] += matchsticks[index]
                if(self.backtrack(matchsticks, index+1, side, array)):
                    return True
                array[i] -= matchsticks[index]
        return False
    
    
    
    
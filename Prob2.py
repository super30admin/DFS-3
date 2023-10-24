class Solution:
    def makesquare(self, matchsticks: List[int]) -> bool:

        #Backtracking - TC O(4^n)

        totalsum=sum(matchsticks)
        if totalsum%4!=0: return False #if sum isn't a multiple of 4 then immediately a False.
        side=totalsum/4 
        if max(matchsticks)>side: return False #if there's any matchstick bigger than ideal equal length of rach side of the square -> FALSE
        square=[0]*4 #let's group them into 4 groups
        matchsticks.sort(reverse=True) #this is required to get over TLE.
        #If we have all smaller matchsticks in the end, it helps reduce overall comparisions in extreme cases.

        def backtrack(matchsticks,square,idx,side):
            #base
            if idx==len(matchsticks):
                if square[0]==square[1]==square[2]==square[3]==side:
                    return True
                return False
            #logic
            for i in range(4):
                if square[i]+matchsticks[idx]<=side: #if curr matchstick fits in a group
                    #ACTION
                    square[i]+=matchsticks[idx] #add to the group
                    #RECURSE
                    if backtrack(matchsticks, square, idx + 1, side): #then go to next matchstick and check from the 1st group -> backtrack 
                        return True
                    #BACKTRACK
                    square[i]-=matchsticks[idx] #remove from group to explore all possibilities
            return False
        
        return backtrack(matchsticks, square, 0, side)




        
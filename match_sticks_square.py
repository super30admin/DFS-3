
#Time Complexity: O(4 ^N) #N is #sticks

#Space Complexity: O(N) 


class Solution:
    def makesquare(self, matchsticks: List[int]) -> bool:
        n = len(matchsticks)
        if n<4:
            return 0
        matchsticks.sort(reverse=True)
        
        total_sum = sum(matchsticks)
        if total_sum %4 !=0:
            return False
        def backtrack(sides,index,s):
            #base
            if sides[0]==s and sides[1]==s and sides[2]==s and sides[3]==s:
                return True
            if index ==  n:
                return False
            
            #logic
            for i in range(0,4):
                cur = matchsticks[index]
                if cur+sides[i]<=s:
                    sides[i]+=cur #action
                    if backtrack(sides,index+1,s): return True
                    sides[i]-=cur #undo
        
        return backtrack([0,0,0,0],0,total_sum//4)
        
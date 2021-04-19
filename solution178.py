#Time Complexity:O(4^n)
#Space Complexity:O(1)
#Approach:For the four sides of the square,use backtracking to find all possible combinations of matchsticks that form the sides of the square
class Solution:
    def makesquare(self, matchsticks: List[int]) -> bool:
        if not matchsticks or len(matchsticks)<4 or sum(matchsticks)%4!=0 or max(matchsticks)>sum(matchsticks)//4:
            return False
        side=sum(matchsticks)//4
        matchsticks.sort(reverse=True)
        return self.backtrack(matchsticks,[0,0,0,0],0,side)
    
    def backtrack(self,matchsticks:List[int],square:List[int],index:int,side:int)->bool:
        if index==len(matchsticks):
            return square[0]==square[1]==square[2]==side
        for i in range(4):
            if square[i]+matchsticks[index]<=side:
                square[i]+=matchsticks[index]
                if self.backtrack(matchsticks,square,index+1,side):
                    return True
                square[i]-=matchsticks[index]
        return False
#Time Complexity: O(4^n)
#Space Complexity: O(n)
#successfully ran on leetcode

class Solution:
    def makesquare(self, matchsticks: List[int]) -> bool:
        if len(matchsticks)==0:
            return False
        total = 0
        for i in matchsticks:
            total+=i
        if total%4!=0:
            return False
        side =total//4
        matchsticks.sort(reverse=True)
        return self.backtracking(matchsticks,side,0,[0,0,0,0])
    def backtracking(self,matchsticks,side,index,sides):
        if index==len(matchsticks):
            if sides[0]==side and sides[1]==side and sides[2]==side:
                return True
            return False
        for i in range(4):
            if sides[i]+matchsticks[index]<=side:
                sides[i]+=matchsticks[index]
                if self.backtracking(matchsticks,side,index+1,sides):
                    return True
                sides[i]-=matchsticks[index]
        return False